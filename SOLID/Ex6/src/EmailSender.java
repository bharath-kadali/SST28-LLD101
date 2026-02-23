public class EmailSender extends NotificationSender {
    public EmailSender(AuditLog audit) { super(audit, new EmailValidator()); }

    @Override
    public void send(Notification n) {
        if (validator != null) validator.validate(n);
        String body = n.body;
        if (body.length() > 40) body = body.substring(0, 40);
        System.out.println("EMAIL -> to=" + n.email + " subject=" + n.subject + " body=" + body);
        audit.add("email sent");
    }
}
