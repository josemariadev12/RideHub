package ridehub.app.DTOs.RideDTO;

import java.math.BigDecimal;
import java.util.UUID;

import ridehub.app.enums.RideEnums.RideStatus;

public record RideResponseDTO(UUID rideId,String origin, String destination, BigDecimal price, RideStatus rideStatus) {

}
