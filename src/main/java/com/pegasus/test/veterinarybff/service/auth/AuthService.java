package com.pegasus.test.veterinarybff.service.auth;

public interface AuthService {
	Boolean validateBasicAuthentication(String userName, String password, String basicAuthHeaderValue);

}
