package ridehub.app.Entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name = "tb_vehicle")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor 
public class Vehicle {

    @Id 
    @GeneratedValue (strategy= GenerationType.UUID)

    @Column (name = "vehicle_id")
    private UUID vehicleId;
    private String brand; //marca
    private String model;

    @Column (unique= true)
    private String plate; //placa

    private String color;
    private Integer year;
}
