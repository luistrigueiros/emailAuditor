package ie.vhi.emailAuditor;

public interface Email {
    String toAddress();
    String fromAddress();

    String subject();

    String content();
}
