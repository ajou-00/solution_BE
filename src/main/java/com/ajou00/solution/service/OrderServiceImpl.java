package com.ajou00.solution.service;

import com.ajou00.solution.domain.Order;
import com.ajou00.solution.domain.Product;
import com.ajou00.solution.dto.OrderDto;
import com.ajou00.solution.repository.OrderRepository;
import com.ajou00.solution.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    private final ProductRepository productRepository;

    @Override
    public void insertOrder(List<OrderDto> orderDtoList) {

        for(OrderDto orderDto : orderDtoList){
            //orderDto의 productNum으로 상품 조회
            Product product = productRepository.findByProductNum(orderDto.getProductNum());

            if(product==null){
                Product newProduct = new Product();
                newProduct.setProductNum(orderDto.getProductNum());
                newProduct.setOrderCnt(0L);
                newProduct.setTotal(10L);
                newProduct.setRandom(false);
                productRepository.save(newProduct);

                product = newProduct;
            }

            //주문 생성
            Order order = Order.builder()
                    .userName(orderDto.getUserName())
                    .productNum(orderDto.getProductNum())
                    .quantity(orderDto.getQuantity())
                    .timestamp(LocalDateTime.now())
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


}
