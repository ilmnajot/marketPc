package uz.marketpc.marketpc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.marketpc.marketpc.entity.AttachmentContent;
import uz.marketpc.marketpc.service.AttachmentContentService;

@Repository
public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, Long> {

    boolean existsById(Long id);
}
