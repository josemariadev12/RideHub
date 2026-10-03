package ridehub.app.Services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ridehub.app.DTOs.UserDTO.UserRequestDTO;
import ridehub.app.DTOs.UserDTO.UserResponseDTO;
import ridehub.app.Entity.User;
import ridehub.app.Repository.UserRepository;
import ridehub.app.enums.UserEnums.UserRoles;
import ridehub.app.enums.UserEnums.UserType;

@Service @RequiredArgsConstructor 
public class UserService {
    private final UserRepository userRepository;

    public User toEntity(UserRequestDTO dto){
        User user = new User();
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        user.setPhone(dto.phone());
        user.setUsername(dto.username());
        user.setUserRoles(UserRoles.USER);
        user.setUserType(UserType.PASSENGER);

        return user;
    }

    public UserResponseDTO toResponse(User user){

        return new UserResponseDTO(user.getUserId(),user.getUsername(), user.getEmail(),user.getPhone(),user.getUserType(),user.getUserRoles());
           
    }

    public UserResponseDTO create(UserRequestDTO dto){
        User user = toEntity(dto);
        userRepository.save(user);

        UserResponseDTO userResponseDTO = toResponse(user);

        return userResponseDTO;
    }

    

    public List<UserResponseDTO> findAll(){
        List<UserResponseDTO> user = userRepository.findAll().stream().map( users -> toResponse(users)).toList();
        return user;
    }

    public UserResponseDTO findById(UUID id){
        UserResponseDTO user = userRepository.findById(id).map(users -> toResponse(users)).orElseThrow(()-> new IllegalArgumentException("Esse ID não existe.")); 
        return user;
    }

    public UserResponseDTO update(UUID id, UserRequestDTO dto){
        User user = userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("ID não encontrado"));
        
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        user.setPhone(dto.phone());
        user.setUsername(dto.username());
        
        userRepository.save(user);
        
        return toResponse(user);
    }

    public void delete(UUID id){
        User user = userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("ID não encontrado"));
        userRepository.delete(user);
    }

}
