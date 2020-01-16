package sv.mh.fe.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import sv.mh.fe.models.User;
import sv.mh.fe.repositories.UserRepository;
import sv.mh.fe.security.Cryptographic;

@RestController
public class LoginController {

	final static Logger logger = LoggerFactory.getLogger(LoginController.class); 
	
	private final String HEADER = "Authorization";
	private final String PREFIX = "Bearer ";
	private final String SECRET = "mySecretKey";	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Cryptographic cryptographic;
	
	@PostMapping("/auth")
	public User login(@RequestParam("user") String username, @RequestParam("pwd") String pwd) {		
				
		User user = null;		
		try {		
			List<User> users = userRepository.findByUserAndPassword(username,  cryptographic.encrypt(pwd));
			logger.info(users.toString());
			if(!users.isEmpty()) {
				user = users.get(0);
				logger.info(user.toString());
				String token = getJWTToken(user);	
				user.setToken(token);
			}			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	private String getJWTToken(User user) {				
		List<GrantedAuthority> grantedAuthorities = 
				AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRol().getNombre());
		logger.info(user.getRol().getNombre());
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(user.getUser())
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						SECRET.getBytes()).compact();

		return PREFIX + token;
	}	
}
