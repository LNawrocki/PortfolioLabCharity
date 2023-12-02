package pl.coderslab.charity.donation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Integer> {

    List<Donation> findDonationsByInstitution_Id(Integer id);

    @Query(value = "SELECT COUNT(d) FROM Donation d")
    Integer numberOfDonations();

    @Query(value = "SELECT SUM(d.quantity) FROM Donation d")
    Integer numberOfBags();
}
