package pl.coderslab.charity.institution;

import java.util.List;

public interface InstitutionService {

    List<Institution> findAll();
    void save(Institution institution);
    Institution getById(Integer id);
    void delete(Integer id);

    Institution get(Integer institutionId);
}
