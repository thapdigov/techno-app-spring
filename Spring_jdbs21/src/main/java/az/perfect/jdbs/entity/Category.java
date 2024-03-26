package az.perfect.jdbs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class Category {
    private int category_id;
    private String category_name;

    public Category(int category_id) {
        this.category_id = category_id;
    }
}
