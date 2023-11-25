package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Institution;

import java.util.List;

public interface InstitutionService {

    List<Institution> findAll();
    void save(Institution institution);
    Institution getById(Integer id);
    void delete(Integer id);

    Institution get(Integer institutionId);
}
