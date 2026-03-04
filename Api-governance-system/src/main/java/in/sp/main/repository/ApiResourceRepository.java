package in.sp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.entity.ApiResource;

public interface ApiResourceRepository extends JpaRepository<ApiResource, Long> {

}
