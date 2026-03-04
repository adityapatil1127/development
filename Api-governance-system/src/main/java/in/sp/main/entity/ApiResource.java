package in.sp.main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Setter @Getter
public class ApiResource {

	@Id @GeneratedValue
	private Long id;
	
	private String apiName;
	
	private int maxUsagePerDay;
}
