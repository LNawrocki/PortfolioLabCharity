package pl.coderslab.charity.institution;

import java.util.List;

public interface InstitutionService {

    List<Institution> findAll();
    Institution save(Institution institution);
    Institution getById(Integer id);
    void delete(Integer institutionId);
    Institution get(Integer institutionId);
}
