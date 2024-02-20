package ma.arkToDoApp.services.securityService;

import org.springframework.security.core.userdetails.UserDetailsService;
public interface IUserService {
    UserDetailsService userDetailsService();
}
