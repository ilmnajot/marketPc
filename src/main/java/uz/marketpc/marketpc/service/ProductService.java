package uz.marketpc.marketpc.service;

import uz.marketpc.marketpc.entity.Products;
import uz.marketpc.marketpc.entity.api.ApiResponse;
import uz.marketpc.marketpc.entity.dto.ProductsDTO;

import java.util.List;

public interface ProductService {
    List<ProductsDTO> getProducts();
    ApiResponse saveProduct(ProductsDTO productsDTO);
    Products getProduct(Long id);
    void deleteProduct(Long id);
    ApiResponse editProduct(Long id, ProductsDTO productsDTO);
}
