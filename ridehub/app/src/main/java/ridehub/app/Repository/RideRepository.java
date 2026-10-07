package ridehub.app.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ridehub.app.Entity.Ride;
import ridehub.app.enums.DriverEnums.DriverStatus;
import ridehub.app.enums.RideEnums.RideStatus;

public interface RideRepository extends JpaRepository<Ride, UUID>{
    List<Ride> findByUserUserIdAndRideStatus(UUID id, RideStatus rideStatus );
    List<Ride> findByDriverStatusAndRideStatus(DriverStatus driverStatus, RideStatus rideStatus);
}
