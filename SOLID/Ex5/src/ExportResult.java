public class ExportResult {
    public final String contentType;
    public final byte[] bytes;
    public final String errorMessage; // null when ok

    public ExportResult(String contentType, byte[] bytes) {
        this.contentType = contentType;
        this.bytes = bytes;
        this.errorMessage = null;
    }

    // factory for error results
    public static ExportResult error(String message) {
        return new ExportResult("", new byte[0], message);
    }

    private ExportResult(String contentType, byte[] bytes, String errorMessage) {
        this.contentType = contentType;
        this.bytes = bytes;
        this.errorMessage = errorMessage;
    }
}
