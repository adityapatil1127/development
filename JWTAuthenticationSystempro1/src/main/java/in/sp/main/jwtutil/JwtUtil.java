package in.sp.main.jwtutil;


import java.security.Key;
import java.util.Base64;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtUtil {

    
	@Value("${jwt.secret}")
	private String secret;
	
	private Key getSigningkey() {
		byte[] keyBytes= Base64.getDecoder().decode(secret);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
	public String generateToken(String username) {
	return Jwts.builder()
	 
	 .setSubject(username)
	 .setIssuedAt(new Date())
	 .setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
	 .signWith(getSigningkey(), SignatureAlgorithm.HS256)
	 .compact();
	}
	
}
