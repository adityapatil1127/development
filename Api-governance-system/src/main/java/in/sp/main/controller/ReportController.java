package in.sp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.repository.CustomerRepository;
import in.sp.main.repository.PaymentRepository;
import in.sp.main.security.JwtUtil;
import in.sp.main.util.ApiAccessValidator;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/dev/report")
public class ReportController {

	@Autowired
	private JwtUtil jwtUtil;
@Autowired
private ApiAccessValidator validator;
@Autowired
private PaymentRepository Prepository;

@Autowired
private CustomerRepository Crepository;


@GetMapping("/genetre")
public String generateReport(HttpServletRequest request) {

	String token = request.getHeader("Authorization").substring(7);
       Long userId = jwtUtil.extractUserId(token);
       
       validator.validate(userId, 3L);
       
       Long totalPayments = Prepository.count();
       Long totalCustomers = Crepository.count();
       
       return  "Report -> Total Payments: " + totalPayments +
               ", Total Customers: " + totalCustomers ;
}
}