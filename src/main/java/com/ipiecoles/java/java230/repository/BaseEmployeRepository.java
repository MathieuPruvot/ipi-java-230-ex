package com.ipiecoles.java.java230.repository;

import com.ipiecoles.java.java230.model.Employe;
import org.joda.time.LocalDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseEmployeRepository<T extends Employe> extends PagingAndSortingRepository<T, Long> {

    T findByMatricule(String matricule);

    List<T> findByNomAndPrenom(String nom, String prenom);

    List<T> findByNomIgnoreCase(String nom);

    @Query(value = "SELECT * FROM T where upper(T.nom)=upper(:string) OR upper(T.prenom)=upper(:string); ", nativeQuery = true)
    List<T> findByNomOrPrenomAllIgnoreCase(@Param("string") String nomOuPrenom);

    Page<T> findByNomIgnoreCase(String nom, Pageable pageable);

    List<T> findByDateEmbaucheBefore(LocalDate dateEmbauche);

    List<T> findByDateEmbaucheAfter(LocalDate dateEmbauche);

    Page<T> OrderByDateEmbaucheDesc(Pageable pageable);

    List<T> findBySalaireGreaterThanOrderBySalaireDesc(Double salaire);

    @Query("select avg(salaire) from T")
    Double moyenneSalaire();

}
