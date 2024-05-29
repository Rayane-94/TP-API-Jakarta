package com.TP_API_Jakarta.TP_API_Jakarta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import com.TP_API_Jakarta.TP_API_Jakarta.repository.EpreuveRepository;
import com.TP_API_Jakarta.TP_API_Jakarta.dto.CreateEpreuve;
import com.TP_API_Jakarta.TP_API_Jakarta.dto.UpdateEpreuve;
import com.TP_API_Jakarta.TP_API_Jakarta.model.Epreuve;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EpreuveService {
    private final EpreuveRepository repository;

    @Autowired
    public EpreuveService(EpreuveRepository repository) {
        this.repository = repository;
    }

    public List<Epreuve> findAllEpreuves() {
        return repository.findAllByDeletedAtNull();  // Utilisez la méthode correcte
    }

    public Epreuve findEpreuveById(String uuid) {
        return repository.findOneByUuid(uuid).orElse(null);
    }

    public Epreuve create(CreateEpreuve epreuveDto) {
        Epreuve epreuve = new Epreuve(
            epreuveDto.getNomEpreuve(),
            epreuveDto.getDate(),
            epreuveDto.getAdresse()
        );
        return repository.save(epreuve);
    }

    @Transactional
    public boolean delete(String uuid) {
        Optional<Epreuve> epreuveOpt = repository.findOneByUuid(uuid);
        if (epreuveOpt.isPresent()) {
            Epreuve epreuve = epreuveOpt.get();
            epreuve.setDeletedAt(LocalDateTime.now());  // Marque comme supprimé
            repository.save(epreuve);
            return true;
        }
        return false;
    }

    public boolean update(String uuid, UpdateEpreuve epreuveDto) {
        Optional<Epreuve> epreuveOpt = repository.findOneByUuid(uuid);

        if (epreuveOpt.isPresent()) {
            Epreuve epreuve = epreuveOpt.get();
            epreuve.setNomEpreuve(epreuveDto.getNomEpreuve());
            epreuve.setDate(epreuveDto.getDate());
            epreuve.setAdresse(epreuveDto.getAdresse());
            repository.save(epreuve);
            return true;
        }
        return false;
    }
}
