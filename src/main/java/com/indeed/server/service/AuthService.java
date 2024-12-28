package com.indeed.server.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.indeed.server.dto.LoginDto;
import com.indeed.server.jwtconf.JwtTokenProvider;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService implements IAuthService {

    private AuthenticationManager authenticationManager;
    
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public String login(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(),
                loginDto.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token="";
		try {
			token = jwtTokenProvider.generateToken(authentication);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return token;
    }
}