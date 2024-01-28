package ie.vhi.emailAuditor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailAuditRepository extends JpaRepository<EmailAudit, Long> {
}
