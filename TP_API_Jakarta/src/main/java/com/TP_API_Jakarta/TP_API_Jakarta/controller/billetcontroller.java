/*package com.TP_API_Jakarta.TP_API_Jakarta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.TP_API_Jakarta.TP_API_Jakarta.model.Billet;
import com.service.BilletService;

public class BilletController {

     @Autowired
    private BilletService service;

    @PostMapping("/api/billets")
	public ResponseEntity<Billet> save(@RequestBody Billet billet) {
		Billet createdBillet = service.create(billet);
		return new ResponseEntity<>(createdBillet, HttpStatus.CREATED);
	}
    
}*/
