package pl.coderslab.charity.donation;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.institution.Institution;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantity;

    @ManyToMany
    List<Category> category;
    @ManyToOne
    private Institution institution;
    private  String street;
    private String city;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "pick_up_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @Column(name = "pick_up_time")
    private LocalTime pickUpTime;
    @Column(name = "pick_up_comment")
    private String pickUpComment;
    private String phone;
}
