package ie.vhi.emailAuditor;

public interface Email {
    String getToAddress();
    String getFromAddress();

    String getSubject();

    String getContent();
}
