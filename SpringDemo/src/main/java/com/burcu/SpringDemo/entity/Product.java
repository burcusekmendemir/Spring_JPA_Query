package com.burcu.SpringDemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String productName;
    private String productCategory;
    private double productPrice;
    private Integer productUnitInStock;
    private String productDescription;
    private  boolean isProductCategoryAvailable;
}
