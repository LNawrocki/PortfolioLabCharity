package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Donation;

import java.util.List;

public interface DonationService {

    void save(Donation donation);

    List<Donation> findAll();

    Integer numberOfGifts();

    List<Donation> findDonationsByInstitution_Id(Integer id);

    void deleteDonation(Donation donation);
}
