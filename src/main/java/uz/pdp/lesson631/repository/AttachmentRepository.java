package uz.pdp.lesson631.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.lesson631.entity.Attachment;


public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
}
