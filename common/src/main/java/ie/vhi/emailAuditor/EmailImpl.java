package ie.vhi.emailAuditor;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EmailImpl implements Email{
    private String toAddress;
    private String fromAddress;
    private String subject;
    private String content;
}
