package ridehub.app.Services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ridehub.app.DTOs.DriveDTO.DriverRequestDTO;
import ridehub.app.DTOs.DriveDTO.DriverResponseDTO;
import ridehub.app.Entity.Driver;
import ridehub.app.Entity.User;
import ridehub.app.Repository.DriverRepository;
import ridehub.app.Repository.UserRepository;
import ridehub.app.enums.DriverEnums.DriverDocsStatus;

@Service 
@RequiredArgsConstructor 
public class DriverService {
    
    private final DriverRepository driverRepository;
    private final UserRepository userRepository;
    private final VehicleService vehicleService;

    public Driver toEntity(DriverRequestDTO dto){
        Driver driver = new Driver();
        driver.setCnh(dto.cnh());
        driver.setCpf(dto.cpf());
        driver.setDriverDocsStatus(DriverDocsStatus.PENDING);
        driver.setVehicle(vehicleService.vehicleDriver(dto.vehicle()));
        return driver;
    }

    public DriverResponseDTO toResponseDTO(Driver driver){
        return new DriverResponseDTO(driver.getDriverId(),driver.getUser(),driver.getVehicle(), driver.getDriverDocsStatus());
    }

    public DriverResponseDTO requestDriver(DriverRequestDTO dto, UUID id){
        User user = userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Usuário não encontrado"));
    
        if(user.getDriver() == null){
            Driver driver = toEntity(dto);
            driver.setUser(user);

            driverRepository.save(driver);

            return toResponseDTO(driver); 
        }
      
        throw new IllegalArgumentException("User has a rider profile");

    }

    public void approvedDriver(UUID id){
        Driver driver = driverRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Rider Profile not found"));

        driver.setDriverDocsStatus(DriverDocsStatus.ACTIVE);
        driverRepository.save(driver);

    }

}
