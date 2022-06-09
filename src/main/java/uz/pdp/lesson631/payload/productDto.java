package uz.pdp.lesson631.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class productDto {

    private String name;
    private String price;
    private String categoryName;
    private String parentCategory;
    private String attachmentName;
    private String size;
    private String contentType;
}
