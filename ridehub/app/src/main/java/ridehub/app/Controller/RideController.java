package ridehub.app.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ridehub.app.DTOs.RideDTO.RideRequestDTO;
import ridehub.app.DTOs.RideDTO.RideResponseDTO;
import ridehub.app.Services.RideService;

@RestController 
@RequestMapping @RequiredArgsConstructor 
public class RideController {
    private final RideService rideService;

    @GetMapping ("/rides")
    public List<RideResponseDTO> findAll(){
        return rideService.findAll();
    }

    @GetMapping ("/rides/{id}")
    public RideResponseDTO findById(@PathVariable UUID id){
        return rideService.findById(id);
    }

    @PostMapping ("/rides")
    public RideResponseDTO create(@RequestBody RideRequestDTO dto){
        return rideService.create(dto);
    }

    @PutMapping("/rides/{id}")
    public RideResponseDTO update(@PathVariable UUID id, @RequestBody RideRequestDTO dto){
        return rideService.update(id, dto);
    }

    @DeleteMapping("/rides/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id ){
        rideService.delete(id);
        return ResponseEntity.ok("Corrida foi deletada com sucesso!");
    }
}
