package uz.marketpc.marketpc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.marketpc.marketpc.entity.Products;
@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
    boolean existsById(Long id);
}
