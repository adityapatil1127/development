package in.sp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.entity.AccessRequest;

public interface AccessRequestRepository extends JpaRepository<AccessRequest, Long> {

	 boolean existsByUserIdAndApiId(Long userId, Long apiId);
	
	
	
}
