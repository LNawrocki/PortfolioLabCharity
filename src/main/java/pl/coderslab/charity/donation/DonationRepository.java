package pl.coderslab.charity.donation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Integer> {

    List<Donation> findDonationsByInstitution_Id(Integer id);

}
