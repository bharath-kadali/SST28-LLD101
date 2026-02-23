import java.util.Optional;

public class AttendanceRule implements EligibilityRule {
    private final int minPct;

    public AttendanceRule(int minPct) { this.minPct = minPct; }

    @Override
    public Optional<String> check(StudentProfile s) {
        if (s.attendancePct < minPct) return Optional.of("attendance below " + minPct);
        return Optional.empty();
    }
}
