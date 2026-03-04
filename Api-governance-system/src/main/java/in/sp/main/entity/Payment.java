package in.sp.main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Payment {
  
	@Id @GeneratedValue
	private Long id;
	
	private String accountNumber;
	private double amount;
	private String ststus;
	
	
}
