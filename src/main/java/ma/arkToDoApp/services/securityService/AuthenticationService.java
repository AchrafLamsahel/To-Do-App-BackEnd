package ma.arkToDoApp.services.securityService;

import ma.arkToDoApp.dtos.JwtAuthenticationResponse;
import ma.arkToDoApp.dtos.SignUpRequest;
import ma.arkToDoApp.dtos.SigninRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);
    JwtAuthenticationResponse signin(SigninRequest request);
}
