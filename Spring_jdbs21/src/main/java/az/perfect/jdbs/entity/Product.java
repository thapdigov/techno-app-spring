package az.perfect.jdbs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Builder
public class Product {

    private int product_id;
    private String product_name;
    private int quantity;
    private Country country;
    private Category category;

    public Product(int product_id, String product_name, int quantity, Country country, Category category) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.quantity = quantity;
        this.country = country;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product:" +
                "\n"+  "\nproduct_id=" + product_id + "\nproduct_name=" + product_name +  "\nquantity=" + quantity +
                "\ncountry=" + country +
                "\ncategory=" + category
                ;
    }
}
