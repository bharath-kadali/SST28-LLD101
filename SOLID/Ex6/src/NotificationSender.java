public abstract class NotificationSender {
    protected final AuditLog audit;
    protected final NotificationValidator validator;

    protected NotificationSender(AuditLog audit, NotificationValidator validator) {
        this.audit = audit;
        this.validator = validator;
    }

    // convenience constructor when no validator provided
    protected NotificationSender(AuditLog audit) {
        this(audit, null);
    }

    public abstract void send(Notification n);
}
