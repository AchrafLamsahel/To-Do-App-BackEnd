package ma.arkToDoApp.security.securityService;

import ma.arkToDoApp.security.dto.JwtAuthenticationResponse;
import ma.arkToDoApp.security.dto.SignUpRequest;
import ma.arkToDoApp.security.dto.SigninRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);
    JwtAuthenticationResponse signin(SigninRequest request);
}
