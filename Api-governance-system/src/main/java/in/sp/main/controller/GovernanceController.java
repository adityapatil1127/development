package in.sp.main.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import in.sp.main.dto.ApiRequestDto;
import in.sp.main.security.JwtUtil;
import in.sp.main.service.GovernanceService;

@RestController
@RequestMapping("/access")
public class GovernanceController {

    @Autowired
    private GovernanceService service;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/request")
    public String request(HttpServletRequest request,
                          @RequestBody ApiRequestDto dto) {

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return " Authentication Token Missing";
        }

        String token = authHeader.substring(7);

        Long userId = jwtUtil.extractUserId(token);

        service.requestAccess(userId, dto.getApiId());

        return "Access Requested By User ID: " + userId;
    }
}