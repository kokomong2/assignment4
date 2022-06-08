package kokomong.assignment4.dto.orders;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FoodOrderRequestDto {
    Long id;
    int quantity;
    @Builder
    public FoodOrderRequestDto(Long id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }
}