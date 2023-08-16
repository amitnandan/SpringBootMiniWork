package com.transaction.Transaction.service.impl;

import com.transaction.Transaction.dto.OrderRequest;
import com.transaction.Transaction.dto.OrderResponse;
import com.transaction.Transaction.entity.Order;
import com.transaction.Transaction.entity.Payment;
import com.transaction.Transaction.exception.PaymentException;
import com.transaction.Transaction.repository.OrderRepository;
import com.transaction.Transaction.repository.PaymentRepository;
import com.transaction.Transaction.service.OrderService;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.UUID;


@Service
public class OrderServiceImpl implements OrderService {


    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();


        if( !payment.getType().equals("DEBIT")){
            throw new PaymentException("PAYMENT CARD TYPE DO NOT SUPPORT");
        }

        payment.setOrderId(order.getId());

        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");
        return orderResponse;
    }
}
