package com.transaction.Transaction.service;

import com.transaction.Transaction.dto.OrderRequest;
import com.transaction.Transaction.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
