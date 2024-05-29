package com.TP_API_Jakarta.TP_API_Jakarta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import com.TP_API_Jakarta.TP_API_Jakarta.repository.OrganisateurRepository;
import com.TP_API_Jakarta.TP_API_Jakarta.dto.CreateOrganisateur;
import com.TP_API_Jakarta.TP_API_Jakarta.dto.UpdateOrganisateur;
import com.TP_API_Jakarta.TP_API_Jakarta.model.Organisateur;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrganisateurService {
    private final OrganisateurRepository repository;

    @Autowired
    public OrganisateurService(OrganisateurRepository repository) {
        this.repository = repository;
    }

    public List<Organisateur> findAllOrganisateurs() {
        return repository.findAllByDeletedAtNull();
    }

    public Organisateur findOrganisateurById(String uuid) {
        return repository.findOneByUuid(uuid).orElse(null);
    }

    public Organisateur create(CreateOrganisateur organisateurDto) {
        Organisateur organisateur = new Organisateur(
            organisateurDto.getNom(),
            organisateurDto.getPrenom(),
            organisateurDto.getLieu()
        );
        return repository.save(organisateur);
    }

    @Transactional
    public boolean delete(String uuid) {
        Optional<Organisateur> organisateurOpt = repository.findOneByUuid(uuid);
        if (organisateurOpt.isPresent()) {
            Organisateur organisateur = organisateurOpt.get();
            organisateur.setDeletedAt(LocalDateTime.now());
            repository.save(organisateur);
            return true;
        }
        return false;
    }

    public boolean update(String uuid, UpdateOrganisateur organisateurDto) {
        Optional<Organisateur> organisateurOpt = repository.findOneByUuid(uuid);

        if (organisateurOpt.isPresent()) {
            Organisateur organisateur = organisateurOpt.get();
            organisateur.setNom(organisateurDto.getNom());
            organisateur.setPrenom(organisateurDto.getPrenom());
            organisateur.setLieu(organisateurDto.getLieu());
            repository.save(organisateur);
            return true;
        }
        return false;
    }
}
