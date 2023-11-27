package pl.coderslab.charity.institution;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitutionRepository extends JpaRepository<Institution, Integer> {
    Institution getInstitutionById(Integer id);
    void deleteById(Integer id);
}
