package kokomong.assignment4.repository;

import kokomong.assignment4.domain.Food;
import kokomong.assignment4.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
