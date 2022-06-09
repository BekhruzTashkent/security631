package uz.pdp.lesson631.service;

import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.lesson631.entity.Attachment;
import uz.pdp.lesson631.entity.Category;
import uz.pdp.lesson631.entity.Product;
import uz.pdp.lesson631.payload.productDto;
import uz.pdp.lesson631.repository.AttachmentRepository;
import uz.pdp.lesson631.repository.CategoryRepository;
import uz.pdp.lesson631.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

@Autowired
    ProductRepository productRepository;

@Autowired
    CategoryRepository categoryRepository;

@Autowired
AttachmentRepository attachmentRepository;

    public List<Product> getProduct(){
    List<Product> productRepositoryAll = productRepository.findAll();
    return productRepositoryAll;
}

    public Optional<Product> getProductById(Integer id){
        Optional<Product> byId = productRepository.findById(id);
        return byId;
    }

    public String insertProduct(productDto productDto1){

        Category category = new Category();
        category.setName(productDto1.getCategoryName());
        category.setParentCategory(productDto1.getParentCategory());
        Category category1 = categoryRepository.save(category);

        Attachment attachment = new Attachment();
        attachment.setName(productDto1.getAttachmentName());
        attachment.setSize(productDto1.getSize());
        attachment.setContentType(productDto1.getContentType());
        Attachment attachment1 = attachmentRepository.save(attachment);

        Product product = new Product();
        product.setName(productDto1.getName());
        product.setPrice(productDto1.getPrice());
        product.setCategory(category1);
        product.setAttachmentList((List<Attachment>) attachment1);
        productRepository.save(product);

        return "saved";
    }

    public String updateProduct(Integer id, productDto productDto1){
        Optional<Product> byId = productRepository.findById(id);
        if(!byId.isPresent()){
            return "no such";
        }
        Category category = new Category();
        category.setName(productDto1.getCategoryName());
        category.setParentCategory(productDto1.getParentCategory());
        Category category1 = categoryRepository.save(category);

        Attachment attachment = new Attachment();
        attachment.setName(productDto1.getAttachmentName());
        attachment.setSize(productDto1.getSize());
        attachment.setContentType(productDto1.getContentType());
        Attachment attachment1 = attachmentRepository.save(attachment);

        Product product = byId.get();
        product.setName(productDto1.getName());
        product.setPrice(productDto1.getPrice());
        product.setCategory(category1);
        product.setAttachmentList((List<Attachment>) attachment1);
        productRepository.save(product);

        return "saved";
    }

    public String deleteProduct(Integer id){
        productRepository.deleteById(id);
        return "deleted";
    }

}
