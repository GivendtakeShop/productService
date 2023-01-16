package com.giventake.productcatalog.repositories;

import com.giventake.productcatalog.entities.Product;
import com.giventake.productcatalog.entities.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {

    List<Product> findByTypeIs(ProductType type);

    List<Product> findByPriceIs( long price);

    List<Product> findByPriceGreaterThan(long price);

    List<Product> findByPriceLessThan(long price);

    List<Product> findByPriceBetween(long priceMin, long priceMax);

    List<Product> findByName(String name);

    List<Product> findByOrderByPriceAsc();

    List<Product> findByOrderByPriceDesc();

    List<Product> findByOrderByNameAsc();

    List<Product> findByOrderByNameDesc();
}
