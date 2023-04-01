package uz.marketpc.marketpc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.marketpc.marketpc.entity.Products;
import uz.marketpc.marketpc.repository.ProductRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;}
    public List<Products> getProducts(){

    }
//        List<Products> productsList = productRepository.findAll();
//        if (productsList.isEmpty())
//            return null;
//        return productRepository.findAll();
//    }
//
//    public Products saveProduct(Products products){
//
//    }
//}
