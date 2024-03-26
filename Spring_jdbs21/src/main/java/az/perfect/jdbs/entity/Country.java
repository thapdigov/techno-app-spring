package az.perfect.jdbs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Country {
    private int country_id;
    private String country_name;

    public Country(int country_id) {
        this.country_id = country_id;
    }
}
