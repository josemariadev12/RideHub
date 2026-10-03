package ridehub.app.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ridehub.app.DTOs.UserDTO.UserRequestDTO;
import ridehub.app.DTOs.UserDTO.UserResponseDTO;
import ridehub.app.Services.UserService;

@RestController 
@RequestMapping @RequiredArgsConstructor 
public class UserController {

    private final UserService userService;

    @GetMapping ("/users")
    public List<UserResponseDTO> findAll(){
        return userService.findAll();
    }

    @PostMapping ("/users")
    public UserResponseDTO create(@RequestBody UserRequestDTO dto){
        return userService.create(dto);
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
