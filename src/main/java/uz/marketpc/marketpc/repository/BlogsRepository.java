package uz.marketpc.marketpc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.marketpc.marketpc.entity.Blogs;
@Repository
public interface BlogsRepository extends JpaRepository<Blogs, Long> {
    boolean existsById(Long id);


}
