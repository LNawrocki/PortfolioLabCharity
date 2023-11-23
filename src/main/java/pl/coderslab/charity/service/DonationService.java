package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Donation;

import java.util.List;

public interface DonationService {

    void save(Donation donation);

    List<Donation> findAll();

    Integer numberOfGifts();
}
