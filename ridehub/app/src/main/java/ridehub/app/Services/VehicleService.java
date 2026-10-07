package ridehub.app.Services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ridehub.app.DTOs.VehicleDTO.VehicleRequestDTO;
import ridehub.app.DTOs.VehicleDTO.VehicleResponseDTO;
import ridehub.app.Entity.Vehicle;
import ridehub.app.Repository.VehicleRepository;

@Service @RequiredArgsConstructor 
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public Vehicle toEntity(VehicleRequestDTO dto){
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(dto.brand());
        vehicle.setColor(dto.color());
        vehicle.setModel(dto.model());
        vehicle.setPlate(dto.plate());
        vehicle.setYear(dto.year());

        return vehicle;
    }

    public VehicleResponseDTO toResponseDTO(Vehicle vehicle){
        return new VehicleResponseDTO(vehicle.getVehicleId(),vehicle.getBrand(),vehicle.getModel(),vehicle.getPlate(),vehicle.getColor(),vehicle.getYear());
    }


    public VehicleResponseDTO create(VehicleRequestDTO dto){
        Vehicle vehicle = toEntity(dto);
        vehicleRepository.save(vehicle);

        return toResponseDTO(vehicle);
    }

    public List<VehicleResponseDTO> findAll(){
        List<VehicleResponseDTO> vehicle = vehicleRepository.findAll().stream().map(vehicles -> toResponseDTO(vehicles)).toList();
        return vehicle;
    }

    public VehicleResponseDTO findById(UUID id){
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("ID não existe"));
         return toResponseDTO(vehicle);
    }

    public VehicleResponseDTO update(UUID id, VehicleRequestDTO dto){
        
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("ID não existe"));
        
        vehicle.setBrand(dto.brand());
        vehicle.setColor(dto.color());
        vehicle.setModel(dto.model());
        vehicle.setPlate(dto.plate());
        vehicle.setYear(dto.year());

        vehicleRepository.save(vehicle);
        
       return toResponseDTO(vehicle);
    }

    public Vehicle vehicleDriver(Vehicle vehicleDriver ){
        Vehicle vehicle = new Vehicle();
        
        vehicle.setBrand(vehicleDriver.getBrand());
        vehicle.setColor(vehicleDriver.getColor());
        vehicle.setModel(vehicleDriver.getModel());
        vehicle.setPlate(vehicleDriver.getPlate());
        vehicle.setYear(vehicleDriver.getYear());

        vehicleRepository.save(vehicle);
        
        return vehicle;
    }

    public void delete(UUID id){
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("ID não existe"));
        vehicleRepository.delete(vehicle);
    }





}
