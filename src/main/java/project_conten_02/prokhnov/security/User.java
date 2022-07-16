package project_conten_02.prokhnov.security;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.Set;

//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Getter
//@Setter
//@ToString
//@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

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
    private Date userCreateDate;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
