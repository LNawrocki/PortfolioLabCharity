package pl.coderslab.charity.institution;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.donation.Donation;
import pl.coderslab.charity.donation.DonationService;

import java.util.List;

@Service
@AllArgsConstructor
public class InstitutionServiceImpl implements InstitutionService {

    private final InstitutionRepository institutionRepository;
    private final DonationService donationService;

    @Override
    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }

    @Override
    public Institution save(Institution institution) {return institutionRepository.save(institution); }

    @Override
    public Institution getById(Integer id) {
        return institutionRepository.getInstitutionById(id);
    }

    @Override
    public void delete(Integer institutionId) {
        List<Donation> donationsByInstitutionId = donationService.findDonationsByInstitution_Id(institutionId);
        if (!donationsByInstitutionId.isEmpty()) {
            for (Donation donation : donationsByInstitutionId) {
                donationService.deleteDonation(donation);
            }
            institutionRepository.deleteById(institutionId);
        } else {
            institutionRepository.deleteById(institutionId);
        }
    }

    @Override
    public Institution get(Integer institutionId) {
        return institutionRepository.getInstitutionById(institutionId);
    }
}
