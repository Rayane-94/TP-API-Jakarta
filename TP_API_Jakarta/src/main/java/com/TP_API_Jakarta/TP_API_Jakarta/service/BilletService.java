package com.TP_API_Jakarta.TP_API_Jakarta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.TP_API_Jakarta.TP_API_Jakarta.repository.BilletRepository;
import com.TP_API_Jakarta.TP_API_Jakarta.repository.EpreuveRepository;
import com.TP_API_Jakarta.TP_API_Jakarta.repository.UtilisateurRepository;
import com.TP_API_Jakarta.TP_API_Jakarta.dto.CreateBillet;
import com.TP_API_Jakarta.TP_API_Jakarta.dto.UpdateBillet;
import com.TP_API_Jakarta.TP_API_Jakarta.model.Billet;
import com.TP_API_Jakarta.TP_API_Jakarta.model.Epreuve;
import com.TP_API_Jakarta.TP_API_Jakarta.model.Utilisateur;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BilletService {
    private static final Logger logger = LoggerFactory.getLogger(BilletService.class);

    private final BilletRepository repository;
    private final EpreuveRepository epreuveRepository;
    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public BilletService(BilletRepository repository, EpreuveRepository epreuveRepository, UtilisateurRepository utilisateurRepository) {
        this.repository = repository;
        this.epreuveRepository = epreuveRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<Billet> findAllBillets() {
        return repository.findAllByDeletedAtNull();
    }

    public Billet findBilletById(String uuid) {
        return repository.findOneByUuid(uuid).orElse(null);
    }

    public Billet createBillet(CreateBillet billetDto) {
        Epreuve epreuve = epreuveRepository.findById(billetDto.getEpreuveUuid()).orElse(null);
        Utilisateur utilisateur = utilisateurRepository.findById(billetDto.getUtilisateurUuid()).orElse(null);

        if (epreuve != null && utilisateur != null) {
            Billet billet = new Billet(billetDto.getPrix(), billetDto.getNbBillet());
            billet.setEpreuve(epreuve);
            billet.setUtilisateur(utilisateur);

            return repository.save(billet);
        } else {
            logger.error("Epreuve or Utilisateur not found with given UUIDs");
            return null;
        }
    }

    @Transactional
    public boolean delete(String uuid) {
        Billet billetASupprimer = findBilletById(uuid);
        if (billetASupprimer != null && billetASupprimer.getDeletedAt() == null) {
            billetASupprimer.setDeletedAt(LocalDateTime.now());
            repository.save(billetASupprimer);
            return true;
        }
        return false;
    }

    public boolean update(String uuid, UpdateBillet billetDto) {
        Billet billetAModifier = findBilletById(uuid);

        if (billetAModifier != null) {
            billetAModifier.setPrix(billetDto.getPrix());
            billetAModifier.setNbBillet(billetDto.getNbBillet());
            repository.save(billetAModifier);
            return true;
        }
        return false;
    }
}
