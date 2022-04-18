package recipes.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import recipes.repositories.UserRepository;

public record UserDetailsServiceImpl(UserRepository repository) implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return repository()
                .findByEmail(username)
                .stream()
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
    }
}
