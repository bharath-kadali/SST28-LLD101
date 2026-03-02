import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;
import java.util.List;

/**
 * Starter demo that shows why mutability is risky.
 *
 * After refactor:
 * - direct mutation should not compile (no setters)
 * - external modifications to tags should not affect the ticket
 * - service "updates" should return a NEW ticket instance
 */
public class TryIt {

    public static void main(String[] args) {
        TicketService service = new TicketService();

        IncidentTicket t = service.createTicket("TCK-1001", "reporter@example.com", "Payment failing on checkout");
        System.out.println("Created: " + t);

        // Demonstrate updates that return NEW ticket instances
        t = service.assign(t, "agent@example.com");
        t = service.escalateToCritical(t);
        System.out.println("\nAfter service updates (new instances): " + t);

        // Demonstrate external mutation via leaked list reference is prevented
        List<String> tags = t.getTags();
        try {
            tags.add("HACKED_FROM_OUTSIDE");
            System.out.println("\nExternal mutation succeeded unexpectedly: " + t);
        } catch (UnsupportedOperationException e) {
            System.out.println("\nExternal mutation prevented: " + e.getClass().getSimpleName());
        }

        // Starter compiles; after refactor, you should redesign updates to create new objects instead.
    }
}
