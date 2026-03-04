package in.sp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.entity.Payment;
import in.sp.main.repository.PaymentRepository;
import in.sp.main.security.JwtUtil;
import in.sp.main.util.ApiAccessValidator;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/dev/payment")
public class PaymentController {
	
	@Autowired
	private PaymentRepository repository;
 
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private ApiAccessValidator validator;

	@PostMapping("/add")
  public Payment addPayment( @RequestBody Payment payment, HttpServletRequest request) {
	  
		String token= request.getHeader("Authorization").substring(7);
		Long userId =jwtUtil.extractUserId(token);
		
	
		validator.validate(userId, 1L);
		
		return repository.save(payment);
  }
	
}
