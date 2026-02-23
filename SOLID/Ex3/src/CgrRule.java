import java.util.Optional;

public class CgrRule implements EligibilityRule {
    private final double min;

    public CgrRule(double min) { this.min = min; }

    @Override
    public Optional<String> check(StudentProfile s) {
        if (s.cgr < min) return Optional.of("CGR below " + String.format("%.1f", min));
        return Optional.empty();
    }
}
