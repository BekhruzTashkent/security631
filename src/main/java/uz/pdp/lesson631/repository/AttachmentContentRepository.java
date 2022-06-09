package uz.pdp.lesson631.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.lesson631.entity.Attachment_Content;



public interface AttachmentContentRepository extends JpaRepository<Attachment_Content, Integer> {
}
