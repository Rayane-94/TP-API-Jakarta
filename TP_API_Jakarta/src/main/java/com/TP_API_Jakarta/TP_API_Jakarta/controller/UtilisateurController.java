package com.TP_API_Jakarta.TP_API_Jakarta.controller;

import com.TP_API_Jakarta.TP_API_Jakarta.dto.CreateUser;
import com.TP_API_Jakarta.TP_API_Jakarta.dto.UpdateUser;
import com.TP_API_Jakarta.TP_API_Jakarta.model.Utilisateur;
import com.TP_API_Jakarta.TP_API_Jakarta.service.UtilisateurService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UtilisateurController {

	private final UtilisateurService service;

	@Autowired
	public UtilisateurController(UtilisateurService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Utilisateur>> findAll() {
		return new ResponseEntity<>(service.findAllUtilisateurs(), HttpStatus.OK);
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<Utilisateur> findOneById(@PathVariable String uuid) {
		Utilisateur student = service.findUtilisateurById(uuid);
		if(student != null) {
			return new ResponseEntity<>(service.findUtilisateurById(uuid), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Utilisateur> save(@Valid @RequestBody CreateUser utilisateur) {
		Utilisateur createdUtilisateur = service.create(utilisateur);
		return new ResponseEntity<>(createdUtilisateur, HttpStatus.CREATED);
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
	public ResponseEntity<?> mettreAJourTotalement(
			@PathVariable String uuid,
			@RequestBody UpdateUser student) {
		boolean isUpdated = service.update(uuid, student);
		if(isUpdated) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
