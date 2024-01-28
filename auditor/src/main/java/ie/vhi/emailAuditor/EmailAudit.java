package ie.vhi.emailAuditor;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "email_audit")
public class EmailAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String toAddress;
    private String fromAddress;
    private String subject;

    public static EmailAudit buildFrom(Email email) {
        EmailAudit emailAudit = new EmailAudit();
        emailAudit.setToAddress(email.getToAddress());
        emailAudit.setFromAddress(email.getFromAddress());
        emailAudit.setSubject(email.getSubject());
        return emailAudit;
    }
}
