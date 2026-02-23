import java.util.List;

public class OnboardingService {
    private final StudentStore store;
    private final RawParser parser;
    private final Validator validator;
    private final ConfirmationPrinter printer;

    // New primary constructor depends on abstractions
    public OnboardingService(StudentStore store, RawParser parser, Validator validator, ConfirmationPrinter printer) {
        this.store = store;
        this.parser = parser;
        this.validator = validator;
        this.printer = printer;
    }

    // Backwards-compatible convenience constructor for Main which passes a FakeDb
    public OnboardingService(FakeDb db) {
        this(new DbStudentStore(db), new RawParser(), new Validator(), new ConfirmationPrinter());
    }

    // Orchestrates steps but delegates parsing/validation/persistence/printing
    public void registerFromRawInput(String raw) {
        printer.printInput(raw);

        ParsedInput in = parser.parse(raw);
        List<String> errors = validator.validate(in);
        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        String id = IdUtil.nextStudentId(store.count());
        StudentRecord rec = new StudentRecord(id, in.name, in.email, in.phone, in.program);
        store.save(rec);
        printer.printSuccess(id, store.count(), rec);
    }
}
