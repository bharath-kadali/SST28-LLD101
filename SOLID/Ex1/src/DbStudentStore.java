public class DbStudentStore implements StudentStore {
    private final FakeDb db;

    public DbStudentStore(FakeDb db) { this.db = db; }

    @Override
    public void save(StudentRecord r) { db.save(r); }

    @Override
    public int count() { return db.count(); }
}
