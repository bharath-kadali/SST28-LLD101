public class FakeEligibilityStoreAdapter implements EligibilityStore {
    private final FakeEligibilityStore delegate;

    public FakeEligibilityStoreAdapter(FakeEligibilityStore delegate) { this.delegate = delegate; }

    @Override
    public void save(String roll, String status) { delegate.save(roll, status); }
}
