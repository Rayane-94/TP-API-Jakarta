package com.TP_API_Jakarta.TP_API_Jakarta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.TP_API_Jakarta.TP_API_Jakarta.repository.UtilisateurRepository;
import com.TP_API_Jakarta.TP_API_Jakarta.dto.CreateUser;
import com.TP_API_Jakarta.TP_API_Jakarta.dto.UpdateUser;
import com.TP_API_Jakarta.TP_API_Jakarta.model.Utilisateur;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class UtilisateurService {
	private final UtilisateurRepository repository;

    @Autowired
    public UtilisateurService(UtilisateurRepository repository) {
		this.repository = repository;
	}

	public List<Utilisateur> findAllUtilisateurs() {
		return repository.findAllByDeletedAtNull();
	}

	public Utilisateur findUtilisateurById(String uuid) {
		return repository.findOneByUuid(uuid).orElse(null);
	}

	public Utilisateur create(CreateUser Utilisateur) {
		Utilisateur UtilisateurACreer = new Utilisateur(
				Utilisateur.getNom(),
				Utilisateur.getPrenom(),
                Utilisateur.getEmail(),
                Utilisateur.getMdp()
		);
		return repository.save(UtilisateurACreer);
	}

	@Transactional
	public boolean delete(String uuid) {
		Utilisateur UtilisateurASupprimer = findUtilisateurById(uuid);
		if(UtilisateurASupprimer != null && UtilisateurASupprimer.getDeletedAt() == null) {
			UtilisateurASupprimer.setDeletedAt(LocalDateTime.now());
			repository.save(UtilisateurASupprimer);
			return true;
		}
		return false;
	}

	public boolean update(String uuid, UpdateUser Utilisateur) {
		Utilisateur UtilisateurAModifier = findUtilisateurById(uuid);

		if(UtilisateurAModifier != null) {
			UtilisateurAModifier.setPrenom(Utilisateur.getPrenom());
			UtilisateurAModifier.setNom(Utilisateur.getNom());
			repository.save(UtilisateurAModifier);
			return true;
		}
		return false;
	}

}
