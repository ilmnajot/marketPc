package uz.marketpc.marketpc.service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.marketpc.marketpc.entity.Products;
import uz.marketpc.marketpc.entity.api.ApiResponse;
import uz.marketpc.marketpc.entity.dto.ProductsDTO;
import uz.marketpc.marketpc.entity.mappers.ProductsMappers;
import uz.marketpc.marketpc.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class ProductServiceImpl  implements ProductService {
    private final ProductRepository productRepository;
    private final ProductsMappers mapper;
    @Override
    public List<ProductsDTO> getProducts() {
        return productRepository.findAll(Sort.by("id"))
                .stream()
                .map(mapper::ProductsToProductsDto)
                .collect(Collectors.toList());
    }
    @Override
    public ApiResponse saveProduct(ProductsDTO productsDTO){
        Products products = mapper.ProductsDtoToProducts(productsDTO);
        productRepository.save(products);
        return new ApiResponse("product saved", true);
    }
    @Override
    public Products getProduct(Long id) {
        boolean existsById = productRepository.existsById(id);
        if (existsById)
            return productRepository.findById(id).get();
        return null;
    }
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
            }
    @Override
    public ApiResponse editProduct(Long id, ProductsDTO productsDTO) {
        boolean existsById = productRepository.existsById(id);
        if (existsById) {
            Optional<Products> byId = productRepository.findById(id);
        }
            return null;

    }
}