package ridehub.app.Controller;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ridehub.app.DTOs.UserDTO.UserLoginDTO;
import ridehub.app.DTOs.UserDTO.UserLoginResponseDTO;
import ridehub.app.DTOs.UserDTO.UserRequestDTO;
import ridehub.app.DTOs.UserDTO.UserResponseDTO;
import ridehub.app.Services.AuthService;
import ridehub.app.Services.UserService;

@RestController
@RequestMapping  ("/auth") @RequiredArgsConstructor 
public class UserController {

    private final UserService userService;
    private final JwtEncoder jwtEnconder;
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;


    @GetMapping ("/users")
    public List<UserResponseDTO> findAll(){
        return userService.findAll();
    }

    @PostMapping ("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody UserRequestDTO dto){
        
        return ResponseEntity.ok(userService.create(dto));
    }

    @PostMapping ("/login")
    public ResponseEntity<UserLoginResponseDTO> login(@RequestBody UserLoginDTO dto){
        
        var user = userDetailsService.loadUserByUsername(dto.email());
        if(passwordEncoder.matches(dto.password(), user.getPassword())==false){
            throw new BadCredentialsException("User or Password Incorrect");
        };

        var now = Instant.now();
        var expiredIn = 500L;

        var claims = JwtClaimsSet
                    .builder()
                    .issuer("RideHub")
                    .subject(user.getUsername())
                    .issuedAt(now)
                    .expiresAt(now.plusSeconds(expiredIn))
                    .build();
        var jwtValue = jwtEnconder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return ResponseEntity.ok(new UserLoginResponseDTO(jwtValue, expiredIn));

    }

    @GetMapping ("/users/{id}")
    public UserResponseDTO findById(@PathVariable UUID id){
        return userService.findById(id);
    }

    @PutMapping("/users/{id}")
    public UserResponseDTO update(@PathVariable UUID id,@RequestBody UserRequestDTO dto){
        return userService.update(id, dto);
    }
    
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        userService.delete(id);
        return ResponseEntity.ok("Conta foi deletada");
    }

    

}
