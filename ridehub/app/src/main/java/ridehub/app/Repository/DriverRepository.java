package ridehub.app.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ridehub.app.Entity.Driver;
import ridehub.app.enums.DriverEnums.DriverDocsStatus;
import ridehub.app.enums.DriverEnums.DriverStatus;

public interface DriverRepository extends JpaRepository<Driver, UUID> {
    List<Driver> findByUserUserIdAndDriverStatus(UUID userId, DriverDocsStatus driverDocsStatus);
    List<Driver> findByDriverStatus(DriverStatus driverStatus);
}
