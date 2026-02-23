public class DefaultAddOnPriceProvider implements AddOnPriceProvider {
    @Override
    public double price(AddOn a) {
        if (a == AddOn.MESS) return 1000.0;
        if (a == AddOn.LAUNDRY) return 500.0;
        if (a == AddOn.GYM) return 300.0;
        return 0.0;
    }
}
