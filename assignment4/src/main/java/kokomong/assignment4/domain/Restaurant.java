package kokomong.assignment4.domain;

import kokomong.assignment4.dto.RestaurantDto;
import kokomong.assignment4.validator.RestaurantValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;


@NoArgsConstructor
@Entity
@Getter
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int minOrderPrice;

    @Column(nullable = false)
    private int deliveryFee;

    public Restaurant(String restaurantName, int minOrderPrice, int deliveryFee) {
        this.name = restaurantName;
        this.minOrderPrice = minOrderPrice;
        this.deliveryFee = deliveryFee;
    }

    public Restaurant(RestaurantDto restaurantDto){

        RestaurantValidator.productValidation(restaurantDto);


        this.name = restaurantDto.getName();
        this.minOrderPrice = restaurantDto.getMinOrderPrice();
        this.deliveryFee = restaurantDto.getDeliveryFee();
    }

}
