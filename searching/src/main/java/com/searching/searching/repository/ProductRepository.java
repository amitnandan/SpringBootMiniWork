package com.searching.searching.repository;

import com.searching.searching.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product , Long> {

//JPQL query search by name and description

    @Query(
            "Select p from Product p WHERE"
            +" p.name LIKE CONCAT('%',:query,'%')"
            +"Or p.description LIKE CONCAT('%',:query,'%')"

    )
    List<Product> searchProducts( String query);


    //Native sql query
    @Query(
            value = "Select * from products p where"
                    +" p.name LIKE CONCAT('%',:query,'%')"
                    +"Or p.description LIKE CONCAT('%',:query,'%')"
        ,nativeQuery = true
    )

    List<Product> searchProductsSQL( String query);
}
