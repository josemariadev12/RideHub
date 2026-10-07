package ridehub.app.DTOs.DriveDTO;

import java.util.UUID;

import ridehub.app.Entity.User;
import ridehub.app.Entity.Vehicle;
import ridehub.app.enums.DriverEnums.DriverDocsStatus;

public record DriverResponseDTO(UUID driverId, User user, Vehicle vehicle, DriverDocsStatus driverDocsStatus) {

}
