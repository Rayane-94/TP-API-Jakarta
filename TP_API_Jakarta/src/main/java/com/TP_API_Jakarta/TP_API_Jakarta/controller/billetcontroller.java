package com.TP_API_Jakarta.TP_API_Jakarta.controller;

import com.TP_API_Jakarta.TP_API_Jakarta.dto.CreateBillet;
import com.TP_API_Jakarta.TP_API_Jakarta.dto.UpdateBillet;
import com.TP_API_Jakarta.TP_API_Jakarta.model.Billet;
import com.TP_API_Jakarta.TP_API_Jakarta.service.BilletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/billets")
public class BilletController {

	private final BilletService service;

     @Autowired
	 public BilletController(BilletService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Billet>> findAll() {
		return new ResponseEntity<>(service.findAllBillets(), HttpStatus.OK);
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<Billet> findOneById(@PathVariable String uuid) {
		Billet billet = service.findBilletById(uuid);
		if(billet != null) {
			return new ResponseEntity<>(service.findBilletById(uuid), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Billet> save(@RequestBody CreateBillet createBillet) { 
    Billet createdBillet = service.create(createBillet); 
    return new ResponseEntity<>(createdBillet, HttpStatus.CREATED);
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
			@RequestBody UpdateBillet student) {
		boolean isUpdated = service.update(uuid, student);
		if(isUpdated) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

    
}