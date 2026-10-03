package ridehub.app.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ridehub.app.Entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, UUID>{

}
