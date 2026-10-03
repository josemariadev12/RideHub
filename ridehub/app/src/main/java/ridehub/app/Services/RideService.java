package ridehub.app.Services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ridehub.app.DTOs.RideDTO.RideRequestDTO;
import ridehub.app.DTOs.RideDTO.RideResponseDTO;
import ridehub.app.Entity.Ride;
import ridehub.app.Repository.RideRepository;
import ridehub.app.enums.RideEnums.RideStatus;

@Service @RequiredArgsConstructor 
public class RideService {

    private final RideRepository rideRepository;

    public Ride toEntity(RideRequestDTO dto){
        Ride ride = new Ride();
        ride.setDestination(
            dto.destination()
        );
        ride.setOrigin(dto.origin());

        return ride;
    }

    public RideResponseDTO toResponseDTO(Ride ride){
        return new RideResponseDTO(ride.getRideId(),ride.getOrigin(),ride.getDestination(),ride.getPrice(),ride.getRideStatus());   
    }

    public RideResponseDTO create(RideRequestDTO dto){
        Ride ride = toEntity(dto);
        ride.setRideStatus(RideStatus.REQUESTED);
        rideRepository.save(ride);
        return toResponseDTO(ride);
    }

    public List<RideResponseDTO> findAll(){
        List<RideResponseDTO> ride = rideRepository.findAll().stream().map(rides -> toResponseDTO(rides)).toList();
        return ride;
    }

    public RideResponseDTO findById(UUID id){
        Ride ride = rideRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("ID não encontrado"));
        return toResponseDTO(ride);
    }
    
    public RideResponseDTO update( UUID id, RideRequestDTO dto){
        Ride ride = rideRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("ID não encontrado"));
        ride.setDestination(
            dto.destination()
        );
        ride.setOrigin(dto.origin());
        rideRepository.save(ride);

        return toResponseDTO(ride);
    }

    public void delete(UUID id){
        Ride ride = rideRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("ID não encontrado"));
        rideRepository.delete(ride);
    }

}
