package com.transaction.Transaction.dto;

import com.transaction.Transaction.entity.Order;
import com.transaction.Transaction.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    private Order order;
    private Payment payment;

}
