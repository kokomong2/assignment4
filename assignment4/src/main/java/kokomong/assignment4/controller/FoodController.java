package kokomong.assignment4.controller;


import kokomong.assignment4.domain.Food;
import kokomong.assignment4.domain.Restaurant;
import kokomong.assignment4.dto.FoodDto;
import kokomong.assignment4.repository.FoodRepository;
import kokomong.assignment4.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FoodController {
    private final FoodRepository foodRepository;
    private final FoodService foodService;

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getFoods(@PathVariable Long restaurantId){
//        return foodRepository.findByRestaurantId(restaurantId);
        return foodRepository.findByRestaurantId(restaurantId);
    }

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void postFoods(@RequestBody List<FoodDto> foodWrapper, @PathVariable Long restaurantId ){
        foodService.PostFoods(foodWrapper,restaurantId);
    }

    @GetMapping("/foods")
    public List<Food> getAllFoods(){

        return foodRepository.findAll();

    }

}
