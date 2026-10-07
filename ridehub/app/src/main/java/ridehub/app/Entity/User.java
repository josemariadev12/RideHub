package ridehub.app.Entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ridehub.app.enums.UserEnums.UserRoles;
import ridehub.app.enums.UserEnums.UserType;

@Entity 
@Table (name="tb_user")
@Getter  @Setter  @NoArgsConstructor  @AllArgsConstructor //lombok
public class User {
    
    @Id 
    @GeneratedValue (strategy= GenerationType.UUID)
    @Column (name = "user_id")
    private UUID userId;
    
    @Column (unique= true)
    private String username;

    
    @Column (name= "Email", unique= true)
    private String email;

    private String password;

    @Column (name="Phone_Number",unique= true)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column (name="user_type")
    private UserType userType;

    @Enumerated(EnumType.STRING)
    @Column (name= "user_roles")
    private UserRoles userRoles;

    @OneToOne (mappedBy="user")
    private Driver driver;

    @OneToMany (mappedBy="user")
    private List<Ride> rides;

}
