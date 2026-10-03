package ridehub.app.DTOs.UserDTO;

import java.util.UUID;

import ridehub.app.enums.UserEnums.UserRoles;
import ridehub.app.enums.UserEnums.UserType;

public record UserResponseDTO( UUID userId, String username,String email, String phone, UserType userType, UserRoles userRoles) {

}
