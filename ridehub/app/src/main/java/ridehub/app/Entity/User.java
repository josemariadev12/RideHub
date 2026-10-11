package ridehub.app.Entity;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ridehub.app.DTOs.UserDTO.UserLoginDTO;
import ridehub.app.enums.UserEnums.UserRoles;
import ridehub.app.enums.UserEnums.UserType;

@Entity 
@Table (name="tb_user")
@Getter  @Setter  @NoArgsConstructor  @AllArgsConstructor //lombok
public class User implements UserDetails {  

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

    @Enumerated(EnumType.STRING) @ElementCollection 
    @CollectionTable (name="tb_user_roles", joinColumns = @JoinColumn (name= "user_id")) 
    @Column (name= "user_roles")
    private Set<UserRoles> userRoles;

    @OneToOne (mappedBy="user")
    private Driver driver;

    @OneToMany (mappedBy="user")
    private List<Ride> rides;


    public String getNickname(){
        return this.username;
    }
    
    @Override 
    public String getUsername(){
        return this.email;
    }
    
    @Override 
    public String getPassword(){
        return this.password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        if(userRoles == null) throw new NullPointerException("INVALID AUTHORITY");
        if(!userRoles.isEmpty()){
            return userRoles.stream().map(roles -> new SimpleGrantedAuthority("ROLE_" + roles)).collect(Collectors.toList());
        }else throw new IllegalStateException("NO AUTHORITY");
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

   public boolean isLoginCorrect(UserLoginDTO dto, PasswordEncoder passwordEncoder){
     return passwordEncoder.matches(dto.password(), this.password);
   }



}
