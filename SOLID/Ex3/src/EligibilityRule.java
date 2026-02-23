import java.util.Optional;

public interface EligibilityRule {
    // returns Optional.empty() if rule passes, otherwise Optional.of(reason)
    Optional<String> check(StudentProfile s);
}
