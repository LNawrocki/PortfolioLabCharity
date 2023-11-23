package pl.coderslab.charity.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DonationServiceImpl implements DonationService {

    private final DonationRepository donationRepository;

    @Override
    public void save(Donation donation) {
        donationRepository.save(donation);
    }

    @Override
    public List<Donation> findAll() {
        return donationRepository.findAll();
    }

    public Integer numberOfGifts() {
        List<Donation> donationsList = donationRepository.findAll();
        Integer giftsQty = 0;
        for (
                Donation donation : donationsList) {
            giftsQty += donation.getQuantity();
        }
        return giftsQty;
    }
}
