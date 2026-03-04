package in.sp.main.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.dto.LoginRequest;
import in.sp.main.dto.LoginResponse;
import in.sp.main.dto.RegisterRequest;
import in.sp.main.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService service;
	
	@PostMapping("/register")
	public String register(@RequestBody RegisterRequest req) {
		service.register(req);
		return "Registered Successfully";
	}
    @PostMapping("/login")
	public  LoginResponse login(@RequestBody LoginRequest req) {
	return 	service.login(req);
	}
    
    
    }

