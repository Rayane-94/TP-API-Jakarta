package com.TP_API_Jakarta.TP_API_Jakarta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.TP_API_Jakarta.TP_API_Jakarta.model.Organisateur;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrganisateurRepository extends JpaRepository<Organisateur, String> {
    List<Organisateur> findAll();

    List<Organisateur> findAllByDeletedAtNull();  

    Optional<Organisateur> findOneByUuid(String uuid);
}