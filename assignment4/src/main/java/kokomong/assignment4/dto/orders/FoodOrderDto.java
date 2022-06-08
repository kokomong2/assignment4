package kokomong.assignment4.dto.orders;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodOrderDto {
    String name;
    int quantity;
    int price;
}