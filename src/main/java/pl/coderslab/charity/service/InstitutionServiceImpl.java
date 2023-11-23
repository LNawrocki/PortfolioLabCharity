package pl.coderslab.charity.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class InstitutionServiceImpl implements InstitutionService{

    private final InstitutionRepository institutionRepository;

    @Override
    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }

//    TODO - void czy Institution
    @Override
    public void save(Institution institution) {
        institutionRepository.save(institution);
    }

    @Override
    public  Institution getById(Integer id) {
        return institutionRepository.getInstitutionById(id);
    }

    @Override
    public void delete(Integer id) {
       institutionRepository.deleteById(id);
    }
}
