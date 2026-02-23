
public class HostelFeeCalculator {
    private final BookingStore store;
    private final RoomPriceProvider roomProvider;
    private final AddOnPriceProvider addOnProvider;

    public HostelFeeCalculator(BookingStore store, RoomPriceProvider roomProvider, AddOnPriceProvider addOnProvider) {
        this.store = store;
        this.roomProvider = roomProvider;
        this.addOnProvider = addOnProvider;
    }

    public HostelFeeCalculator(FakeBookingRepo repo) {
        this(new FakeBookingRepoAdapter(repo), new DefaultRoomPriceProvider(), new DefaultAddOnPriceProvider());
    }

    // Orchestrates calculation using providers; printing and persistence separated.
    public void process(BookingRequest req) {
        Money monthly = calculateMonthly(req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new java.util.Random(1).nextInt(1000)); // deterministic-ish
        store.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(BookingRequest req) {
        double base = roomProvider.basePrice(req.roomType);

        double add = 0.0;
        for (AddOn a : req.addOns) {
            add += addOnProvider.price(a);
        }

        return new Money(base + add);
    }
}
