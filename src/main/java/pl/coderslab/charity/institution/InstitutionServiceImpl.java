package pl.coderslab.charity.institution;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

    @Override
    public Institution get(Integer institutionId){
        return institutionRepository.getInstitutionById(institutionId);
    }
}
