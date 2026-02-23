import java.util.*;

public class EligibilityEngine {
    private final EligibilityStore store;
    private final List<EligibilityRule> rules;

    public EligibilityEngine(EligibilityStore store, List<EligibilityRule> rules) {
        this.store = store;
        this.rules = rules;
    }

    // Backwards-compatible convenience constructor
    public EligibilityEngine(FakeEligibilityStore store) {
        this(new FakeEligibilityStoreAdapter(store), java.util.Arrays.asList(
            new DisciplinaryRule(),
            new CgrRule(8.0),
            new AttendanceRule(75),
            new CreditsRule(20)
        ));
    }

    public void runAndPrint(StudentProfile s) {
        ReportPrinter p = new ReportPrinter();
        EligibilityEngineResult r = evaluate(s); // now uses rule objects
        p.print(s, r);
        store.save(s.rollNo, r.status);
    }

    public EligibilityEngineResult evaluate(StudentProfile s) {
        List<String> reasons = new ArrayList<>();
        String status = "ELIGIBLE";

        for (EligibilityRule rule : rules) {
            Optional<String> result = rule.check(s);
            if (result.isPresent()) {
                status = "NOT_ELIGIBLE";
                reasons.add(result.get());
                break; // preserve original else-if behavior: stop at first failure
            }
        }

        return new EligibilityEngineResult(status, reasons);
    }
}

class EligibilityEngineResult {
    public final String status;
    public final List<String> reasons;
    public EligibilityEngineResult(String status, List<String> reasons) {
        this.status = status;
        this.reasons = reasons;
    }
}
