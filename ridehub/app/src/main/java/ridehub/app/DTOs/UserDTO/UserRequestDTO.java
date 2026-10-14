package ridehub.app.DTOs.UserDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(@NotBlank String username, @Email @NotBlank  String email,@NotBlank @Size (min=8, max=30) String password,@NotBlank @Size(min=9,max=9) String phone) {

}
