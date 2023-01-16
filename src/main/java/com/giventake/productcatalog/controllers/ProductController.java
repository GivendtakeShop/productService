package com.giventake.productcatalog.controllers;

import static com.giventake.productcatalog.constants.PathConstant.*;

import com.giventake.productcatalog.entities.Product;
import com.giventake.productcatalog.entities.ProductType;
import com.giventake.productcatalog.requestDTOs.ProductRequestDTO;
import com.giventake.productcatalog.responseDTOs.ProductResponseDTO;
import com.giventake.productcatalog.responseDTOs.mappers.ProductResponseMapper;
import com.giventake.productcatalog.services.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(V1+PRODUCT)
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    private final ProductService productService;
    private final ProductResponseMapper productResponseMapper;

    @GetMapping
    public List<ProductResponseDTO> getProducts(){
        return productService.getProducts()
                .stream().map(productResponseMapper::productToProductResponseDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductResponseDTO getProduct(@PathVariable String id){
        return productResponseMapper
                .productToProductResponseDTO(productService.getProduct(id));
    }

    @PostMapping
    public ProductResponseDTO addProduct(@RequestBody ProductRequestDTO product){
        return productResponseMapper
                .productToProductResponseDTO(productService.addProduct(product));

    }

    @DeleteMapping("/{id}")
    public boolean deleteProduct(@PathVariable String id){
        return  productService.deleteProduct(id);
    }


    @PutMapping("/{id}")
    public  ProductResponseDTO updateProduct(@PathVariable String id, @RequestBody ProductRequestDTO product){
        return productResponseMapper
                .productToProductResponseDTO(productService.updateProduct(id, product));
    }

    @GetMapping("/type")
    public List<ProductResponseDTO> getProductsByType(@RequestParam ProductType type){
        return productService.getProductsByType(type)
                .stream().map(productResponseMapper::productToProductResponseDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/price")
    public List<ProductResponseDTO> getProductsByPrice(@RequestParam long price){
        return productService.getProductsByPrice(price)
                .stream().map(productResponseMapper::productToProductResponseDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/price/greater")
    public List<ProductResponseDTO> getProductsByPriceGreaterThan(@RequestParam long price){
        return productService.getProductsByPriceGreaterThan(price)
                .stream().map(productResponseMapper::productToProductResponseDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/price/less")
    public List<ProductResponseDTO> getProductsByPriceLessThan(@RequestParam long price){
        return productService.getProductsByPriceLessThan(price)
                .stream().map(productResponseMapper::productToProductResponseDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/price/between")
    public List<ProductResponseDTO> getProductsByPriceBetween(@RequestParam long priceMin, @RequestParam long priceMax){
        return productService.getProductsByPriceBetween(priceMin, priceMax)
                .stream().map(productResponseMapper::productToProductResponseDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/name")
    public List<ProductResponseDTO> getProductsByName(@RequestParam String name){
        return productService.getProductsByName(name)
                .stream().map(productResponseMapper::productToProductResponseDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/price/asc")
    public List<ProductResponseDTO> getProductsByOrderByPriceAsc(){
        return productService.getProductsByOrderByPriceAsc()
                .stream().map(productResponseMapper::productToProductResponseDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/price/desc")
    public List<ProductResponseDTO> getProductsByOrderByPriceDesc(){
        return productService.getProductsByOrderByPriceDesc()
                .stream().map(productResponseMapper::productToProductResponseDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/name/asc")
    public List<ProductResponseDTO> getProductsByOrderByNameAsc(){
        return productService.getProductsByOrderByNameAsc()
                .stream().map(productResponseMapper::productToProductResponseDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/name/desc")
    public List<ProductResponseDTO> getProductsByOrderByNameDesc(){
        return productService.getProductsByOrderByNameDesc()
                .stream().map(productResponseMapper::productToProductResponseDTO)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}/updateQuantity")
    public ProductResponseDTO updateQuantity(@PathVariable String id, @RequestParam Integer quantity){
        return productResponseMapper.productToProductResponseDTO(productService.updateQuantity(id, quantity));


    }
}
