package uz.marketpc.marketpc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.marketpc.marketpc.entity.Orders;

import javax.persistence.criteria.Order;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    boolean existsById(Long id);
}
