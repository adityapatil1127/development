package in.sp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.entity.Customer;
import in.sp.main.repository.CustomerRepository;
import in.sp.main.security.JwtUtil;
import in.sp.main.util.ApiAccessValidator;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/dev/customer")
public class CustomerController {
@Autowired
	private JwtUtil jwtUtil;

@Autowired
private CustomerRepository repository;
	
@Autowired
private ApiAccessValidator validator;

@PostMapping("/add")
public Customer addcustomer( @RequestBody  Customer customer, HttpServletRequest request) {
	
	String token =request.getHeader("Authorization").substring(7);
	Long userId = jwtUtil.extractUserId(token);
	
	validator.validate(userId, 2L);
	
	return repository.save(customer);
}

}
