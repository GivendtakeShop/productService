package com.giventake.productcatalog.services.product;

import com.giventake.productcatalog.entities.Product;
import com.giventake.productcatalog.entities.ProductType;
import com.giventake.productcatalog.requestDTOs.ProductRequestDTO;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getProducts();

    Product addProduct(ProductRequestDTO product);

    boolean deleteProduct(String id);

    Product getProduct(String id);

    Product updateProduct(String id, ProductRequestDTO product);

    List<Product> getProductsByType(ProductType type);

    List<Product> getProductsByPrice(long price);

    List<Product> getProductsByPriceGreaterThan(long price);

    List<Product> getProductsByPriceLessThan(long price);

    List<Product> getProductsByPriceBetween(long priceMin, long priceMax);

    List<Product> getProductsByName(String name);

    List<Product> getProductsByOrderByPriceAsc();

    List<Product> getProductsByOrderByPriceDesc();

    List<Product> getProductsByOrderByNameAsc();

    List<Product> getProductsByOrderByNameDesc();
}
