package com.bbx2.ikeagoconlibros.user.controller;



import com.bbx2.ikeagoconlibros.user.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @PostMapping("/user")
    public User login(@RequestParam("username") String email, @RequestParam("password") String pwd) {
        System.err.println("asdasd");
        String token = getJWTToken(email);
        User user = new User();
        user.setEmail(email);
        user.setToken(token);
        return user;

    }

    private String getJWTToken(String email) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.createAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("ikeagoconlibrosJWT")
                .setSubject(email)
                .claim(
                        "authorities",
                        grantedAuthorities.stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList())
                )
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+600000))
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();


    return "Bearer " + token;
    }
}