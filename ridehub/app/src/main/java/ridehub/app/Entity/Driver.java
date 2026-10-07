package ridehub.app.Entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ridehub.app.enums.DriverEnums.DriverDocsStatus;
import ridehub.app.enums.DriverEnums.DriverStatus;

@Entity 
@Table (name = "tb_driver")
@AllArgsConstructor @NoArgsConstructor @Getter  @Setter 
public class Driver {

    @Id 
    @GeneratedValue (strategy= GenerationType.UUID) @Column (name="driver_id")
    private UUID driverId;

    @Column (unique=true) @NotBlank 
    private String cnh;

    @Column(unique=true) @NotBlank 
    private String cpf;

    @Enumerated (EnumType.STRING)
    private DriverDocsStatus driverDocsStatus;

    private String latitude;
    private String longitude;

    @Enumerated (EnumType.STRING)
    private DriverStatus driverStatus;

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn (name="user_id", nullable= false)
    private User user;

    @OneToOne(fetch= FetchType.EAGER)
    @JoinColumn (name="vehicle_id", nullable= false)
    private Vehicle vehicle;

    @OneToMany (mappedBy="driver")
    private List<Ride> rides;

}
