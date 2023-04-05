package uz.marketpc.marketpc.controller;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import uz.marketpc.marketpc.entity.Products;
import uz.marketpc.marketpc.entity.api.ApiResponse;
import uz.marketpc.marketpc.entity.dto.ProductsDTO;
import uz.marketpc.marketpc.service.ProductService;
import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    @GetMapping("/all")
    @PreAuthorize(value = "hasAuthority('READ_ALL_PRODUCT')")
    public List<ProductsDTO> getProducts(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return productService.getProducts();

    }
    @PostMapping
    @PreAuthorize(value = "hasAuthority('CREATE')")
    public ApiResponse saveProduct(@RequestBody ProductsDTO productsDTO){
        return productService.saveProduct(productsDTO);
    }
    @GetMapping("/{id}")
    @PreAuthorize(value = "hasAuthority('READ_ONE')")
    public HttpEntity<?> getProductById(@PathVariable Long id){
        Products product = productService.getProduct(id);
        if (product!=null)
            return ResponseEntity.ok(product);
        return ResponseEntity.ok(null);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize(value ="hasAuthority('DELETE')")
    public HttpEntity<?> deleteById(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok("data deleted");
    }
    @PutMapping("/{id}")
    @PreAuthorize(value = "hasAuthority('UPDATE')")
    public HttpEntity<?> updateProduct(@PathVariable Long id, @RequestBody ProductsDTO productsDTO){
        return ResponseEntity.ok(productService.editProduct(id, productsDTO));
    }
}
