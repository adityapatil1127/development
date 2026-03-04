package in.sp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.entity.ApiUsageLog;

public interface ApiUsageLogRepository extends JpaRepository<ApiUsageLog, Long>{

}
