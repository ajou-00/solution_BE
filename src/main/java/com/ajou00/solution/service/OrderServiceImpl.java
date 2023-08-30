package com.ajou00.solution.service;

import com.ajou00.solution.domain.Order;
import com.ajou00.solution.domain.Product;
import com.ajou00.solution.dto.OrderByDateDto;
import com.ajou00.solution.dto.OrderDto;
import com.ajou00.solution.repository.MemberRepository;
import com.ajou00.solution.repository.OrderRepository;
import com.ajou00.solution.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    private final ProductRepository productRepository;
    private final MemberRepository memberRepository;

    @Override
    public void insertOrder(List<OrderDto> orderDtoList) {

        for(OrderDto orderDto : orderDtoList){
            //orderDto의 productNum으로 상품 조회
            Product product = productRepository.findByProductNum(orderDto.getProductNum());

//            if(product==null){
//                Product newProduct = new Product();
//                newProduct.setProductNum(orderDto.getProductNum());
//                newProduct.setOrderCnt(0L);
//                newProduct.setTotal(10L);
//                newProduct.setRandom(false);
//                productRepository.save(newProduct);
//
//                product = newProduct;
//            }

            //주문 생성
            Order order = Order.builder()
                    .userName(orderDto.getUserName())
                    .productNum(orderDto.getProductNum())
                    .quantity(orderDto.getQuantity())
                    .timestamp(orderDto.getTimestamp())
                    .build();

            //주문 DB 저장
            orderRepository.save(order);

            //해당 상품의 기존 Cnt 값에 수량 추가 후 저장
            product.setOrderCnt(product.getOrderCnt()+orderDto.getQuantity());

            //Cnt가 total 이상일 경우 추첨 대상
            if(product.getOrderCnt() >= product.getTotal()){
                product.setRandom(true);
            }

            productRepository.save(product);

        }
    }

    @Override
    public List<Order> findAll() {

        List<Order> orderList = orderRepository.findAll();

        return orderList;
    }

    @Override
    public List<OrderByDateDto> findOrderByDate(List<Order> orderList) {

        List<OrderByDateDto> resultList = new ArrayList<>();

        for (Order order : orderList) {
            LocalDate orderDate = order.getTimestamp();
            System.out.println("orderDate = " + orderDate);
            boolean existingDate = false;

            // 이미 리스트에 해당 날짜가 있는지 확인
            for (OrderByDateDto dto : resultList) {
                if (dto.getDate().isEqual(orderDate)) {
                    dto.setSales(dto.getSales() + 1);
                    existingDate = true;
                    break;
                }
            }

            // 리스트에 해당 날짜가 없으면 새로운 OrderByDateDto 생성
            if (!existingDate) {
                OrderByDateDto dto = new OrderByDateDto();
                dto.setDate(orderDate);
                dto.setSales(1L);
                resultList.add(dto);
            }
        }

        return resultList;
    }

    public List<Order> findOrderByProductNum(Long productNum) {
        List<Order> orderList = orderRepository.findByProductNum(productNum);
        return orderList;
    }

    @Override
    public List<Order> getOrderListByUserName(String userName) {
        return orderRepository.findByUserName(userName);
    }

}
