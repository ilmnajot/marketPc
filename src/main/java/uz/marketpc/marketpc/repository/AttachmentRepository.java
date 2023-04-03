package uz.marketpc.marketpc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.marketpc.marketpc.entity.Attachment;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}
