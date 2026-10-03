package ridehub.app.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ridehub.app.Entity.Ride;

public interface RideRepository extends JpaRepository<Ride, UUID>{

}
