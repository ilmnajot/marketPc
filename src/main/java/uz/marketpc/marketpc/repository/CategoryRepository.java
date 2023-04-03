package uz.marketpc.marketpc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.marketpc.marketpc.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsById(Long id);
}
