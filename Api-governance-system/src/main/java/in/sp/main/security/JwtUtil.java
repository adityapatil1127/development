package in.sp.main.security;

import java.util.Date;
import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")//reads the secret key from appli
    private String secret;//store seckey used to sign &verify

   //create method
  private SecretKey getSignKey() {
	  //converts bae64 string to byte format
	  byte[] keyBytes = Decoders.BASE64.decode(secret);
	  return Keys.hmacShaKeyFor(keyBytes); //its create secure hmac key for signig jwt
  }

   public String generateToken(Long userId,String email) {
	   return Jwts.builder() //start jwt
			   .subject(email) 
			   .claim("userId", userId)
               .issuedAt(new Date())
               .expiration(new Date(System.currentTimeMillis()+86400000))
               .signWith(getSignKey()) //sign token using secret key
               .compact(); //convert evething into final jwt String
   }
    
    public String extractEmail(String token) {
    	return Jwts.parser()
    			.verifyWith(getSignKey()) //token verfiy
    			.build()
    			.parseSignedClaims(token)//parse tokken & check if valid
    			.getPayload()
    			.getSubject();// extract stored email
    	
    }
    
    public Long extractUserId(String token) {
    	return Jwts.parser()
    			.verifyWith(getSignKey())//verify token
    			.build()
                .parseSignedClaims(token)//read token
                .getPayload()
                .get("userId",Long.class);//custom claim "userId"
    }
}