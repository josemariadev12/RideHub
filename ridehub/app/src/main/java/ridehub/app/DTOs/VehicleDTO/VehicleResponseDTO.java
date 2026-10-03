package ridehub.app.DTOs.VehicleDTO;

import java.util.UUID;

public record VehicleResponseDTO(UUID vehicleId, 
                            String brand, 
                            String model,
                            String plate,
                            String color,
                        Integer year) {

}
