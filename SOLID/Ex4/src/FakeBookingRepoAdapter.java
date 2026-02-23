public class FakeBookingRepoAdapter implements BookingStore {
    private final FakeBookingRepo delegate;

    public FakeBookingRepoAdapter(FakeBookingRepo delegate) { this.delegate = delegate; }

    @Override
    public void save(String id, BookingRequest req, Money monthly, Money deposit) { delegate.save(id, req, monthly, deposit); }
}
