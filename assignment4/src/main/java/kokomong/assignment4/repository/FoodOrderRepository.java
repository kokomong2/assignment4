package kokomong.assignment4.repository;

import kokomong.assignment4.domain.Food;
import kokomong.assignment4.domain.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodOrderRepository extends JpaRepository<FoodOrder,Long> {
    List<FoodOrder> findByRestaurantId(Long restaurantId);
}
