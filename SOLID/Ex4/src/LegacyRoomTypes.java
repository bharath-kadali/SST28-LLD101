public class LegacyRoomTypes {
    public static final int SINGLE = 1;
    public static final int DOUBLE = 2;
    public static final int TRIPLE = 3;
    public static final int DELUXE = 4;

    public static String nameOf(int t) {
        switch (t) {
            case SINGLE: return "SINGLE";
            case DOUBLE: return "DOUBLE";
            case TRIPLE: return "TRIPLE";
            default: return "DELUXE";
        }
    }
}
