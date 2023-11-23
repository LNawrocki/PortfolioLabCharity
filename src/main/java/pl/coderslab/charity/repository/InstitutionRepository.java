package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.entity.Institution;

import java.util.OptionalInt;

public interface InstitutionRepository extends JpaRepository<Institution, Integer> {
    Institution getInstitutionById(Integer id);
    void deleteById(Integer id);
}
