package kokomong.assignment4.validator;

import kokomong.assignment4.dto.RestaurantDto;
import org.springframework.stereotype.Component;

@Component
public class RestaurantValidator {

    public static void productValidation(RestaurantDto restaurantDto){

        if (restaurantDto.getMinOrderPrice()<1000 || restaurantDto.getMinOrderPrice()>100000){
            throw new IllegalArgumentException("최소 주문가격은 1000원부터 100000원사이로 입력해주세요 ");
        }
        if(restaurantDto.getMinOrderPrice()%100!=0){
            throw new IllegalArgumentException("최소주문 가격은 100원 단위로 입력해주세요");
        }
        if(restaurantDto.getDeliveryFee()<0|| restaurantDto.getDeliveryFee()>10000){
            throw new IllegalArgumentException("기본 배달비는 0원부터 10000원 사이로 입력해주세요");
        }
        if(restaurantDto.getDeliveryFee()%500!=0){
            throw new IllegalArgumentException("기본 배달비는 500원 단위로 입력해주세요");
        }
    }
}
