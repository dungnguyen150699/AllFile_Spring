package com.example.authservice;

import com.example.authservice.dto.UserTokenDTO;
import com.example.authservice.security.JwtUsernameAndPasswordAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
//    private final AuthenticationManager authenticationManager;
//
//    @PostMapping("/x")
//    public ResponseEntity<UserTokenDTO> login(@RequestBody @Valid UserTokenDTO request) throws Exception {
//        try {
//            System.out.println(bCryptPasswordEncoder.encode(request.getPassword()));
//            Authentication authenticate = authenticationManager
//                    .authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
//
//            UserDetailImpl user = (UserDetailImpl) authenticate.getPrincipal();
//            String token = new JwtUsernameAndPasswordAuthenticationFilter().
//                    successfulAuthentication(authenticate);
//            request.setToken(token);
//            return ResponseEntity.ok()
//                    .header(HttpHeaders.AUTHORIZATION,token)
//                    .body(request);
//        } catch (Exception ex) {
//            if(ex instanceof AuthenticationException) {
//                throw new InternalAuthenticationServiceException("Invalid username/password!");
//            }
//            throw ex;
//        }
////    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//    }
}
