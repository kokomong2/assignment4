package kokomong.assignment4.service;


import kokomong.assignment4.domain.Food;
import kokomong.assignment4.domain.Restaurant;
import kokomong.assignment4.dto.FoodDto;
import kokomong.assignment4.repository.FoodRepository;
import kokomong.assignment4.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FoodService {

//    private final FoodDto foodDto;
    private final FoodRepository foodRepository;


    @Transactional
    public void PostFoods(List<FoodDto> foodWrapper, Long restaurantId) {



        for (FoodDto foodDto : foodWrapper) {
            String foodName = foodDto.getName();
            int foodPrice = foodDto.getPrice();

            checkFoodName(foodName,restaurantId);
            checkFoodPrice(foodPrice);

            Food food = Food.builder().
                    name(foodName).
                    price(foodPrice).
                    restaurantId(restaurantId).
                    build();
            foodRepository.save(food);
        }
    }
    public void checkFoodName(String foodName, Long restaurantId){
        List<Food> foodlist = foodRepository.findByRestaurantId(restaurantId);
        for(Food food :foodlist){
            if(Objects.equals(food.getName(), foodName)){
                throw new IllegalArgumentException("동일한 음식 이름이 있습니다.");
            }
        }
    }
    public void checkFoodPrice(int foodPrice){
        if(foodPrice<100||foodPrice>1000000){
            throw new IllegalArgumentException("음식값은 100원부터 1000000원까지 입력 가능합니다.");
        }
        if(foodPrice%100!=0){
            throw new IllegalArgumentException("음식값은 100원 단위로 입력해야합니다.");
        }
    }

}
