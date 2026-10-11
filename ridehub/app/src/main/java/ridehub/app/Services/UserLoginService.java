package ridehub.app.Services;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ridehub.app.Repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import ridehub.app.DTOs.UserDTO.UserLoginDTO;
import ridehub.app.Entity.User;
@Service @RequiredArgsConstructor //LOGICA PARA SPRING SECURITY
public class UserLoginService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override 
    public UserDetails loadUserByUsername(String username){
        User userDetails = userRepository.findUserByEmail(username).orElseThrow(() -> new BadCredentialsException("User or Password Incorrect"));
        return userDetails;
    }



}
