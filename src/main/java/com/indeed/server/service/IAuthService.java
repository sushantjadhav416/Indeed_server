package com.indeed.server.service;

import com.indeed.server.dto.LoginDto;

public interface IAuthService {
	
	public String login(LoginDto loginDto); 

}
