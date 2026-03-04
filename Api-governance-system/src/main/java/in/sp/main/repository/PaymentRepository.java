package in.sp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
