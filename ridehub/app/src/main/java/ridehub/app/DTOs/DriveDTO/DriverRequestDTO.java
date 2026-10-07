package ridehub.app.DTOs.DriveDTO;

import ridehub.app.Entity.Vehicle;


public record DriverRequestDTO(String cnh, String cpf, Vehicle vehicle) {

}
