public class WhatsAppSender extends NotificationSender {
    public WhatsAppSender(AuditLog audit) { super(audit, new WhatsAppValidator()); }

    @Override
    public void send(Notification n) {
        if (validator != null) validator.validate(n);
        System.out.println("WA -> to=" + n.phone + " body=" + n.body);
        audit.add("wa sent");
    }
}
