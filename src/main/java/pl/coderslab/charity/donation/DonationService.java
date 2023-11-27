package pl.coderslab.charity.donation;

import java.util.List;

public interface DonationService {

    void save(Donation donation);

    List<Donation> findAll();

    Integer numberOfGifts();

    List<Donation> findDonationsByInstitution_Id(Integer id);

    void deleteDonation(Donation donation);
}
