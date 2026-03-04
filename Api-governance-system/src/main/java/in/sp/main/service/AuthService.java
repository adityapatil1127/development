package in.sp.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.sp.main.dto.LoginRequest;
import in.sp.main.dto.LoginResponse;
import in.sp.main.dto.RegisterRequest;
import in.sp.main.entity.User;
import in.sp.main.repository.UserRepository;
import in.sp.main.security.JwtUtil;

@Service
public class AuthService {

	@Autowired
    private  JwtUtil jwtUtil;

    @Autowired 
    private UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    public AuthService(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

  
    public void register(RegisterRequest req) {
        User u = new User();
        u.setName(req.getName());
        u.setEmail(req.getEmail());
        u.setPassword(encoder.encode(req.getPassword()));

        if(req.getRole() == null || req.getRole().isEmpty()){
            u.setRole("DEV");
        } else {
            u.setRole(req.getRole());
        }

        repo.save(u);
    }

  
    public LoginResponse login(LoginRequest req) {

        User u = repo.findByEmail(req.getEmail())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        if(!encoder.matches(req.getPassword(), u.getPassword())){
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(u.getId(), u.getEmail());

        return new LoginResponse(token,u.getRole());
    }
}