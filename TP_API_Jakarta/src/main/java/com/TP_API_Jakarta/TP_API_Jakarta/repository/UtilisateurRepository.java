package com.TP_API_Jakarta.TP_API_Jakarta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TP_API_Jakarta.TP_API_Jakarta.model.Utilisateur;
import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {
    List<Utilisateur> findAll();

	List<Utilisateur> findAllByDeletedAtNull();

	// SELECT * FROM Utilisateur where uuid = ?
	Optional<Utilisateur> findOneByUuid(String uuid);
}
