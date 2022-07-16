package project_conten_02.prokhnov.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "user_login_name")
    @NotEmpty(message = "User login name is required!")
    @Size(min = 4, max = 32, message = "User login name must have between 4 and 32 characters.")
    private String userLoginName;

    @Column(name = "user_email")
    @Email(message = "Please enter a valid email")
    @NotEmpty(message = "Email is required!")
    private String userEmail;

    @Column(name = "user_password")
    @Size(min = 4, max = 32, message = "User password must have between 4 and 32 characters.")
    private String userPassword;

    @Column(name = "user_name")
    @NotEmpty(message = "User name is required!")
    private String userName;

    @Column(name = "user_last_name")
    @NotEmpty(message = "User last name is required!")
    private String userLastName;

    @Column(name = "user_is_active")
    private Boolean userIsActive;

    @Column(name = "user_create_date")
    @CreatedDate
    private Date userCreateDate;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role) {
        if (roles == null) {
            roles = new HashSet<>();
        }
        roles.add(role);
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return userEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userIsActive;
    }
}
