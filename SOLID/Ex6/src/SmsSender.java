public class SmsSender extends NotificationSender {
    public SmsSender(AuditLog audit) { super(audit, new SmsValidator()); }

    @Override
    public void send(Notification n) {
        if (validator != null) validator.validate(n);
        System.out.println("SMS -> to=" + n.phone + " body=" + n.body);
        audit.add("sms sent");
    }
}
