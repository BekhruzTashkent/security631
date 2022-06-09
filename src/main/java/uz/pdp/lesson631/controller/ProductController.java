package uz.pdp.lesson631.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.lesson631.entity.Product;
import uz.pdp.lesson631.payload.productDto;
import uz.pdp.lesson631.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productSecurity")
public class ProductController {

    @Autowired
    ProductService productService;

    @PreAuthorize(value = "hasAnyRole('SUPER-ADMIN','OPERATOR')")
    @GetMapping
    public List<Product> getProduct(){
       return productService.getProduct();
    }

    @PreAuthorize(value = "hasAnyRole('SUPER-ADMIN','OPERATOR')")
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Integer id){
        return productService.getProductById(id);
    }

    @PreAuthorize(value = "hasAnyRole('SUPER-ADMIN','MODERATOR')")
    @PostMapping
    public String insertProduct(@RequestBody productDto productDto1){
        productService.insertProduct(productDto1);
        return "saved";
    }

    @PreAuthorize(value = "hasAnyRole('SUPER-ADMIN','MODERATOR')")
    @PutMapping("/{id}")
    public String updateProduct(@PathVariable Integer id, @RequestBody productDto productDto1){
        productService.updateProduct(id, productDto1);
        return "updated";
    }

    @PreAuthorize(value = "hasAnyRole('SUPER-ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
        return "deleted";
    }

}
