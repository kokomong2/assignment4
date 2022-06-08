package kokomong.assignment4.dto;

import lombok.Getter;


@Getter
public class RestaurantDto {

//    @NotBlank(message = "번호를 입력해주세요")
    private String name;

//    @Min(value = 1000, message = "최소 가격은 1000원 이상으로 설정해주세요")
//    @Max(value = 100000, message = "최소 가격은 100000원 이하로 설정해주세요")
    private int minOrderPrice;

//    @Min(value = 0, message = "0이상으로 설정해주세요")
//    @Max(value = 10000, message = "100000이하로 설정해주세요")
    private int deliveryFee;

}
