package kokomong.assignment4.service;


import kokomong.assignment4.domain.Food;
import kokomong.assignment4.domain.FoodOrder;
import kokomong.assignment4.domain.Orders;
import kokomong.assignment4.domain.Restaurant;
import kokomong.assignment4.dto.orders.FoodOrderDto;
import kokomong.assignment4.dto.orders.FoodOrderRequestDto;
import kokomong.assignment4.dto.orders.OrderRequestDto;
import kokomong.assignment4.repository.FoodOrderRepository;
import kokomong.assignment4.repository.FoodRepository;
import kokomong.assignment4.repository.OrderRepository;
import kokomong.assignment4.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;
    private final FoodOrderRepository foodOrderRepository;

    @Transactional
    public Orders toResponseOrder(OrderRequestDto orderRequestDto){

        Long restaurantId = orderRequestDto.getRestaurantId();              //받아온 음식점ID를 통해
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(); //해당 음식점을 가져옴
        String restaurantName = restaurant.getName();                           //음식점 이름을 가져옴

        int deliveryFee = restaurant.getDeliveryFee();                          //해당 음식점의 배달비용을 가져옴옴
       List<Food> foods = foodRepository.findByRestaurantId(restaurantId);      //해당 음식점ID에 해당하는 음식들 리스트 가져옴
        int totalPrice = deliveryFee;                                                     //총 계산비용 선언
        for (FoodOrderRequestDto value:orderRequestDto.getFoods()){// foods리스트의 값 하나하나를 value에 넣음 {id:1, quantity:1}
            Long id = value.getId();                                //foodId 꺼냄
            for(Food food : foods){                                 //아까 음식점ID에 해당하는 음식 리스트에서 음식들을 하나씩 가져옴
                if(food.getId()==id){                           // 해당 음식의 음식id가 foodID와 동일하다면 진행
                    String foodName = food.getName();           //해당 음식의 음식이름
                    int foodPrice = food.getPrice();            //해당 음식의 음식가격
                    int quantity = value.getQuantity();         //해당 음식의 주문 갯수
                    isValidQuantity(quantity);
                    FoodOrder foodOrder = FoodOrder.builder().name(foodName).quantity(quantity).price(foodPrice*quantity).restaurantId(restaurantId).build(); // foodOrder에 저장
                    foodOrderRepository.save(foodOrder);// foodOrder저장
                    totalPrice+= foodPrice*quantity; // 총금액에 음식 가격* 갯수 추가
                }
            }
        }
        if(totalPrice<restaurant.getMinOrderPrice()){
            throw new IllegalArgumentException("최종 금액을 최소금액보다 높게 주문해주세요");
        }
        List<FoodOrder> foodOrderList = foodOrderRepository.findByRestaurantId(restaurantId); // 음식점 id에 들어가있는 음식 리스트 뽑음
        Orders orders = Orders.builder().
                restaurantName(restaurantName).
                foods(foodOrderList).
                deliveryFee(deliveryFee).
                totalPrice(totalPrice).
                build();


        return orderRepository.save(orders);

    }

    private void isValidQuantity(int quantity){
        if(quantity<1||quantity>100){
            throw new IllegalArgumentException("한 음식의 배달갯수는 1~100개로 입력해주세요");
        }
    }
}
