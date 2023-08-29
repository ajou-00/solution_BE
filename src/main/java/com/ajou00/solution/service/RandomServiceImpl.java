package com.ajou00.solution.service;

import com.ajou00.solution.domain.Order;
import com.ajou00.solution.domain.Product;
import com.ajou00.solution.domain.Random;
import com.ajou00.solution.dto.RandomResponseDto;
import com.ajou00.solution.repository.OrderRepository;
import com.ajou00.solution.repository.ProductRepository;
import com.ajou00.solution.repository.RandomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RandomServiceImpl implements RandomService{

    @Autowired
    private final RandomRepository randomRepository;

    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    private final ProductRepository productRepository;


    @Override
    public void lottery(List<Order> orderList, List<Product> randomProductList) {
        //1. randomList를 for문으로 돌면서 추첨해야하는 product의 productNum조회 & 내부 for문에서 orderList에서
        //randomList에 있던 productNum일 경우 해당 productNum을 갖는 order를 찾고, 해당 product의 total 수 만큼
        //order의 quantity 개수를 더해가면서 order을 random 하게 골라서 Random 객체를 생성해서 해당 order의 orderId와
        //해당 order을 한 userName을 넣어서 List<Random>에 넣기

        List<Random> result = new ArrayList<>();
        List<Order> eligibleOrders = new ArrayList<>();

        for (Order order : orderList) {
            for (Product product : randomProductList) {
                if (order.getProductNum().equals(product.getProductNum())) {
                    eligibleOrders.add(order);
                    break;
                }
            }
        }

        Collections.shuffle(eligibleOrders);

        for (Order order : eligibleOrders) {
            long totalSelectedQuantity = result.stream()
                    .filter(random -> random.getOrderId().equals(order.getId()))
                    .mapToLong(random -> orderRepository.findById(random.getOrderId()).get().getQuantity())
                    .sum();

            for (Product product : randomProductList) {
                if (order.getProductNum().equals(product.getProductNum())) {
                    long remainingQuantity = product.getTotal() - totalSelectedQuantity;
                    if (remainingQuantity >= order.getQuantity()) {
                        Random random = Random.builder()
                                .orderId(order.getId())
                                .userName(order.getUserName())
                                .build();
                        result.add(random);
                        randomRepository.save(random);
                    }
                    break;
                }
            }
        }
    }

    @Override
    public List<RandomResponseDto> showUserResult(String userName) {
        List<Random> randomList = randomRepository.findByUserName(userName);
        List<RandomResponseDto> dtoList = new ArrayList<>();

        for (Random random : randomList) {
            RandomResponseDto randomResponseDto = new RandomResponseDto();
            randomResponseDto.setOrderId(random.getOrderId());

            Optional<Order> order = orderRepository.findById(random.getOrderId());
            randomResponseDto.setProductNum(order.get().getProductNum());
            randomResponseDto.setQuantity(order.get().getQuantity());

            Product product = productRepository.findByProductNum(order.get().getProductNum());

            randomResponseDto.setProductName(product.getName());

            dtoList.add(randomResponseDto);
        }

        return dtoList;
    }
}
