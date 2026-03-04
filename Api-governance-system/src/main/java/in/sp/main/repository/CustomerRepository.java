package in.sp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
