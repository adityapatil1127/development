package in.sp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.dto.AuthRequest;
import in.sp.main.dto.AuthResponse;
import in.sp.main.entities.User;
import in.sp.main.jwtutil.JwtUtil;
import in.sp.main.repository.UserRepository;

@RestController
public class AuthController {
	
	@Autowired
	private UserRepository repository;

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	
	
	@PostMapping("/register")
	public String register(@RequestBody User user) {
		 user.setPassword(encoder.encode(user.getPassword()));
	
		 repository.save(user);
	  return "user Registered";
	}
	  @PostMapping("/login")
	  public AuthResponse login(@RequestBody AuthRequest req) {
		  User user = repository.findByUsername(req.getUsername())
		  .orElseThrow(() -> new RuntimeException("user not found"));
	 
		  if(!encoder.matches(req.getPassword(), user.getPassword()))
   	     throw new RuntimeException("Invalid");
	  
	  String token =jwtUtil.generateToken(user.getUsername());
	  return new AuthResponse(token);
	  
	  
	}
	
	
}
