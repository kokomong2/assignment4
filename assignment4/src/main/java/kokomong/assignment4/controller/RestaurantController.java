package kokomong.assignment4.controller;

import kokomong.assignment4.domain.Restaurant;
import kokomong.assignment4.dto.RestaurantDto;
import kokomong.assignment4.repository.RestaurantRepository;
import kokomong.assignment4.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

//@Slf4j
@RequiredArgsConstructor
@RestController
public class RestaurantController {

    private final RestaurantRepository restaurantRepository;

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants(){

        return restaurantRepository.findAll();

    }

    @PostMapping("/restaurant/register")
    public Restaurant postRestaurants(@RequestBody RestaurantDto restaurantDto){

        Restaurant restaurant = new Restaurant(restaurantDto);

        return restaurantRepository.save(restaurant);
    }

}
