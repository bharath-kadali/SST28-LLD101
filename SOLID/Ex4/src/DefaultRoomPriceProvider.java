public class DefaultRoomPriceProvider implements RoomPriceProvider {
    @Override
    public double basePrice(int roomType) {
        switch (roomType) {
            case LegacyRoomTypes.SINGLE: return 14000.0;
            case LegacyRoomTypes.DOUBLE: return 15000.0;
            case LegacyRoomTypes.TRIPLE: return 12000.0;
            default: return 16000.0;
        }
    }
}
