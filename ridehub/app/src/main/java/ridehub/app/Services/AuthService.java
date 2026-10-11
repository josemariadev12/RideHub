package ridehub.app.Services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ridehub.app.DTOs.UserDTO.UserLoginDTO;
import ridehub.app.DTOs.UserDTO.UserLoginResponseDTO;

@Service @RequiredArgsConstructor 
public class AuthService {

    private final UserDetailsService userDetailsService;
    

    //public boolean login(UserLoginDTO dto, PasswordEncoder passwordEncoder){}

}
