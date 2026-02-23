public class LegacyFlags {
    public static final int NONE = 0;
    public static final int WARNING = 1;
    public static final int SUSPENDED = 2;

    public static String nameOf(int f) {
        switch (f) {
            case WARNING: return "WARNING";
            case SUSPENDED: return "SUSPENDED";
            default: return "NONE";
        }
    }
}
