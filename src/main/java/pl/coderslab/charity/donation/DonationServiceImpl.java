package pl.coderslab.charity.donation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

    @Override
    public Integer numberOfDonations() {
        return donationRepository.numberOfDonations();
    }

    @Override
    public Integer numberOfBags() {
        return donationRepository.numberOfBags();
    }


    @Override
    public List<Donation> findDonationsByInstitution_Id(Integer id) {
        return donationRepository.findDonationsByInstitution_Id(id);
    }

    @Override
    public void deleteDonation(Donation donation) {
        donationRepository.delete(donation);
    }

}
