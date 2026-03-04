package in.sp.main.entity;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class AccessRequest {

	@Id @GeneratedValue
	private Long id;
	
	private Long userId;
	private Long apiId;
	private LocalDate expiryDate;  
	 
	@Enumerated(EnumType.STRING)
	private RequestStatus status;
	
	
}
