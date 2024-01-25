package com.burcu.SpringDemo.repository;

import com.burcu.SpringDemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    /*
   # Ürün ismine göre ürünü bulunuz.
# Ürün isminin içerdiği harf veya kelimeye göre ürünü bulunuz.
# Belirli fiyat aralığındaki ürünleri listeleyiniz.
    */
    //codeium
    Optional<Product> findByProductName(String productName);
    Optional<Product> findByProductNameIgnoreCase(String productName);

    List<Product> findAllByProductNameLikeIgnoreCase(String productName);
    List<Product> findAllByProductNameContainingIgnoreCase(String productName);
    List<Product> findAllByProductPriceBetween(Double start, Double end);

    /**
     *
     * Belirli bir stok adedinin üzerindeki ürünleri listeleyiniz.
     * Belirli bir fiyata eşit ve bu fiyatın üstündeki ürünleri listeleyiniz.
     * Bir kategoriye ait kaç adet ürün olduğunu listeleyiniz.
     * Bir üründen kaç tane olduğunu listeleyiniz.
     * Girilen kategorinin varlığını kontrol ediniz. (true,false)
     * Kategorisi 'null' olan ürünleri listeleyiniz.
     * Baş harfi girilen kategoriye ait ürünleri listeleyiniz.
     */

    //Girilen fiyatın üstündeki ürünleri listeleyiniz.
    List<Product> findAllByProductPriceGreaterThan(Double price);

    //Belirli bir fiyata eşit ve bu fiyatın üstündeki ürünleri listeleyiniz.
    List<Product> findAllByProductPriceGreaterThanEqual(Double price);

    //Bir kategoriye ait kaç adet ürün olduğunu listeleyiniz.
    @Query("select o.productCategory,count(p) from Product o group by o.productCategory")
    Integer categoryCount();

    //Bir üründen kaç tane olduğunu listeleyiniz.
    @Query("select o.productName, count(p) from Product o group by o.productName")
    Integer productCount();

    //Girilen kategorinin varlığını kontrol ediniz. (true,false)
    List<Product> findAllByIsProductCategoryAvailableTrue(String productCategory);

    //Kategorisi 'null' olan ürünleri listeleyiniz.
    List<Product> findAllByProductCategoryIsNull();

    //Baş harfi girilen kategoriye ait ürünleri listeleyiniz.
    List<Product> findAllByProductNameStartingWith(String productName);

}
