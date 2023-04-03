package uz.marketpc.marketpc.entity.mappers;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;
import uz.marketpc.marketpc.entity.Products;
import uz.marketpc.marketpc.entity.dto.ProductsDTO;

@Mapper(componentModel = "spring")
public interface ProductsMappers {
    ProductsDTO ProductsToProductsDto(Products products);
    Products ProductsDtoToProducts(ProductsDTO productsDTO);
}
