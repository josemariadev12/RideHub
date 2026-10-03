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
import ridehub.app.DTOs.VehicleDTO.VehicleRequestDTO;
import ridehub.app.DTOs.VehicleDTO.VehicleResponseDTO;
import ridehub.app.Services.VehicleService;

@RestController
@RequestMapping @RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping("/vehicles")
    public List<VehicleResponseDTO> findAll(){
        return vehicleService.findAll();
    }
    
    @GetMapping ("/vehicles/{id}")
    public VehicleResponseDTO findById(@PathVariable UUID id){
        return vehicleService.findById(id);
    }

    @PostMapping("/vehicles")
    public VehicleResponseDTO create(@RequestBody VehicleRequestDTO dto){
        return vehicleService.create(dto);
    }

    @PutMapping ("/vehicles/{id}")
    public VehicleResponseDTO update(@PathVariable UUID id, @RequestBody VehicleRequestDTO dto){
        return vehicleService.update(id, dto);

    }


    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        vehicleService.delete(id);
        return ResponseEntity.ok("veiculo foi deletado com sucesso!");
    }



}
