package pl.coderslab.charity.user;

import lombok.Data;
import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Entity
@Data
@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @Email
    @Column(unique = true)
    private String email;
    @NotBlank
    @Size(min = 4)
    private String password;
    @Column(nullable = false)
    private String role = "ROLE_USER";
    @Column(nullable = false)
    private Boolean active = false;
    @Column(name = "uuid")
    private String uuId;
    @Column(name = "uuid_expiration_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate uuIdExpirationDate;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
