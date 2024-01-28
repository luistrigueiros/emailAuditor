package ie.vhi.emailAuditor;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class EmailImpl implements Email, Serializable {
    private String toAddress;
    private String fromAddress;
    private String subject;
    private String content;
}
