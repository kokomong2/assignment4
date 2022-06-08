package kokomong.assignment4.repository;

import kokomong.assignment4.domain.Food;
import kokomong.assignment4.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food,Long> {
    List<Food> findByRestaurantId(Long restaurantId);
}
