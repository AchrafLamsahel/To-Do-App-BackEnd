package ma.arkToDoApp.services.securityService;

import lombok.AllArgsConstructor;
import ma.arkToDoApp.enumurations.ExceptionsMessage;
import ma.arkToDoApp.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements IUserService {
    private final UserRepository userRepository;
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) {
                return userRepository.findByEmail(email)
                        .orElseThrow(() -> new UsernameNotFoundException(
                                ExceptionsMessage.USER_NOT_FOUND.getMessage()));
            }
        };
    }
}
