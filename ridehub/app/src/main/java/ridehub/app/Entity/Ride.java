package ridehub.app.Entity;

import java.math.BigDecimal;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ridehub.app.enums.RideEnums.RideStatus;

@Entity 
@Table(name = "tb_ride")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor 
public class Ride {

    @Id 
    @GeneratedValue (strategy= GenerationType.UUID)
    @Column (name="ride_id")
    private UUID rideId;

    private String origin;
    private String destination;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    
    @Column (name= "ride_status")
    private RideStatus rideStatus;

    @ManyToOne  (fetch= FetchType.EAGER)
    @JoinColumn (name="user_id", nullable= false)
    private User user;

    @ManyToOne (fetch= FetchType.EAGER)
    @JoinColumn (name="driver_id", nullable= true)
    private Driver driver;
}
