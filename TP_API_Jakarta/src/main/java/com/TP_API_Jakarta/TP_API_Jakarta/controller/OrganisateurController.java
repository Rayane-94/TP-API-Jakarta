package com.TP_API_Jakarta.TP_API_Jakarta.controller;

import com.TP_API_Jakarta.TP_API_Jakarta.dto.CreateOrganisateur;
import com.TP_API_Jakarta.TP_API_Jakarta.dto.UpdateOrganisateur;
import com.TP_API_Jakarta.TP_API_Jakarta.model.Organisateur;
import com.TP_API_Jakarta.TP_API_Jakarta.service.OrganisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organisateurs")
public class OrganisateurController {

    private final OrganisateurService service;

    @Autowired
    public OrganisateurController(OrganisateurService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Organisateur>> findAll() {
        return new ResponseEntity<>(service.findAllOrganisateurs(), HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Organisateur> findOneById(@PathVariable String uuid) {
        Organisateur organisateur = service.findOrganisateurById(uuid);
        if(organisateur != null) {
            return new ResponseEntity<>(organisateur, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Organisateur> save(@RequestBody CreateOrganisateur createOrganisateur) {
        Organisateur createdOrganisateur = service.create(createOrganisateur);
        return new ResponseEntity<>(createdOrganisateur, HttpStatus.CREATED);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<?> delete(@PathVariable String uuid) {
        boolean isDeleted = service.delete(uuid);
        if(isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<?> update(
            @PathVariable String uuid,
            @RequestBody UpdateOrganisateur updateOrganisateur) {
        boolean isUpdated = service.update(uuid, updateOrganisateur);
        if(isUpdated) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
