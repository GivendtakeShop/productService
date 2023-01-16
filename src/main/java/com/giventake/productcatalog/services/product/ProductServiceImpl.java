package com.giventake.productcatalog.services.product;


import com.giventake.productcatalog.entities.Product;
import com.giventake.productcatalog.entities.ProductType;
import com.giventake.productcatalog.exceptions.BusinessException;
import com.giventake.productcatalog.exceptions.ExceptionPayload;
import com.giventake.productcatalog.exceptions.ExceptionPayloadFactory;
import com.giventake.productcatalog.repositories.ProductRepository;
import com.giventake.productcatalog.requestDTOs.ProductRequestDTO;
import com.giventake.productcatalog.requestDTOs.mappers.ProductRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductRequestMapper productRequestMapper;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(ProductRequestDTO product) {
        product.validate();

        return productRepository
                .save(productRequestMapper.productRequestDTOToProduct(product));
    }

    @Override
    public boolean deleteProduct(String id) {
        productRepository.deleteById(id);
        return true;
        }

    @Override
    public Product getProduct(String id) {
        return productRepository.findById(id)
                .orElseThrow(()-> new BusinessException(ExceptionPayloadFactory.PRODUCT_NOT_FOUND.get()));
    }


    @Override
    public Product updateProduct(String id, ProductRequestDTO product) {
        Product productToUpdate = productRepository.findById(id)
                .orElseThrow(()-> new BusinessException(ExceptionPayloadFactory.PRODUCT_NOT_FOUND.get()));
        productToUpdate.setType(product.getType());
        productToUpdate.setName(product.getName());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setDescription(product.getDescription());

        return productToUpdate;
    }

    @Override
    public List<Product> getProductsByType(ProductType type) {
        return productRepository.findByTypeIs(type);
    }

    @Override
    public List<Product> getProductsByPrice(long price) {
        return productRepository.findByPriceIs(price);
    }

    @Override
    public List<Product> getProductsByPriceGreaterThan(long price) {
        return productRepository.findByPriceGreaterThan(price);
    }

    @Override
    public List<Product> getProductsByPriceLessThan(long price) {
        return productRepository.findByPriceLessThan(price);
    }

    @Override
    public List<Product> getProductsByPriceBetween(long priceMin, long priceMax) {
        return productRepository.findByPriceBetween(priceMin, priceMax);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getProductsByOrderByPriceAsc() {
        return productRepository.findByOrderByPriceAsc();
    }

    @Override
    public List<Product> getProductsByOrderByPriceDesc() {
        return productRepository.findByOrderByPriceDesc();
    }

    @Override
    public List<Product> getProductsByOrderByNameAsc() {
        return  productRepository.findByOrderByNameAsc();
    }

    @Override
    public List<Product> getProductsByOrderByNameDesc() {
        return productRepository.findByOrderByNameDesc();
    }
}
