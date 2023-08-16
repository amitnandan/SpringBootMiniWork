package com.searching.searching.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String sku ;
    private String name ;
    private String description;
    private boolean active;
    private String imageUrl ;
    @CurrentTimestamp
    private LocalDateTime dateCreated ;
    @UpdateTimestamp
    private LocalDateTime dataUpdated;

}
