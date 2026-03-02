package com.example.tickets;

import java.util.ArrayList;
import java.util.List;

/**
 * Service layer that creates tickets.
 *
 * CURRENT STATE (BROKEN ON PURPOSE):
 * - creates partially valid objects
 * - mutates after creation (bad for auditability)
 * - validation is scattered & incomplete
 *
 * TODO (student):
 * - After introducing immutable IncidentTicket + Builder, refactor this to stop mutating.
 */
public class TicketService {

    public IncidentTicket createTicket(String id, String reporterEmail, String title) {
        // scattered validation (incomplete on purpose)
        if (id == null || id.trim().isEmpty()) throw new IllegalArgumentException("id required");
        if (reporterEmail == null || !reporterEmail.contains("@")) throw new IllegalArgumentException("email invalid");
        if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("title required");
        List<String> tags = new ArrayList<>();
        tags.add("NEW");

        // Use Builder to create immutable ticket in a valid state
        return IncidentTicket.builder()
                .id(id)
                .reporterEmail(reporterEmail)
                .title(title)
                .priority("MEDIUM")
                .source("CLI")
                .customerVisible(false)
                .tags(tags)
                .build();
    }

    public IncidentTicket escalateToCritical(IncidentTicket t) {
        List<String> tags = new ArrayList<>(t.getTags());
        tags.add("ESCALATED");
        return IncidentTicket.Builder.from(t)
                .priority("CRITICAL")
                .tags(tags)
                .build();
    }

    public IncidentTicket assign(IncidentTicket t, String assigneeEmail) {
        // scattered validation
        if (assigneeEmail != null && !assigneeEmail.contains("@")) {
            throw new IllegalArgumentException("assigneeEmail invalid");
        }
        return IncidentTicket.Builder.from(t)
                .assigneeEmail(assigneeEmail)
                .build();
    }
}
