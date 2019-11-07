package sv.mh.fe.controller;

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

@RestController
public class LoginController {

	final static Logger logger = LoggerFactory.getLogger(LoginController.class); 
	
	
	@Autowired
	private UserRepository userRepository;
	

	
	@PostMapping("/auth")
	public User login(@RequestParam("nit") String username, @RequestParam("pwd") String pwd) {		
		
		List<User> users = userRepository.findByNitAndPwd(username,pwd);
		User user = null;
		
		logger.info("users.size:"+users.size());
		
		if(!users.isEmpty()) {
			String token = getJWTToken(username);
			user = users.get(0);
			user.setToken(token);
		}
		
		/*
		User user = new User();
		List<User> users = userRepository.findAll();
		logger.info("users.size:"+users.size());*/
		return user;
	}

	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}
