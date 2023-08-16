package com.transaction.Transaction.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payments")
@Entity
public class Payment {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id ;
        private String type ;
        private String cardName;

        private String cardNumber;

        private int expiryYear;
        private int expirtMonth;

        private int cvc;

        private Long orderId;
}
