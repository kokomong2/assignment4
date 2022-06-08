package kokomong.assignment4.dto.orders;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderRequestDto {
    private Long restaurantId;
    private List<FoodOrderRequestDto> foods;
    @Builder
    public OrderRequestDto(Long restaurantId, List<FoodOrderRequestDto> foods) {
        this.restaurantId = restaurantId;
        this.foods = foods;
    }
}