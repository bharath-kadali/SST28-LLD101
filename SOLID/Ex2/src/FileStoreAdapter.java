public class FileStoreAdapter implements InvoiceStore {
    private final FileStore delegate = new FileStore();

    @Override
    public void save(String name, String content) { delegate.save(name, content); }

    @Override
    public int countLines(String name) { return delegate.countLines(name); }
}
