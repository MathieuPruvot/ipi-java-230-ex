package com.ipiecoles.java.java230.repository;

import com.ipiecoles.java.java230.model.Employe;
import org.joda.time.LocalDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeRepository extends PagingAndSortingRepository<Employe, Long> {

    Employe findByMatricule(String matricule);

    List<Employe> findByNomAndPrenom(String nom, String prenom);

    List<Employe> findByNomIgnoreCase(String nom);

    List<Employe> findByNomOrPrenomAllIgnoreCase(String nomeOuPrenom);

    Page<Employe> findByNomIgnoreCase(String nom,  Pageable pageable);

    List<Employe> findByDateEmbaucheBefore(LocalDate dateEmbauche);

    List<Employe> findByDateEmbaucheAfter(LocalDate dateEmbauche);

    List<Employe> findBySalaireGreaterThanOrderBySalaireDesc(Double salaire);

    Page<Employe> OrderByDateEmbaucheDesc(Pageable pageable);

}
