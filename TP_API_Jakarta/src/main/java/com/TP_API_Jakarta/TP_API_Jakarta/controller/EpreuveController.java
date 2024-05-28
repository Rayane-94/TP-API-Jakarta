package com.TP_API_Jakarta.TP_API_Jakarta.controller;

import com.TP_API_Jakarta.TP_API_Jakarta.dto.CreateEpreuve;
import com.TP_API_Jakarta.TP_API_Jakarta.dto.UpdateEpreuve;
import com.TP_API_Jakarta.TP_API_Jakarta.model.Epreuve;
import com.TP_API_Jakarta.TP_API_Jakarta.service.EpreuveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/epreuves")
public class EpreuveController {

    private final EpreuveService service;

    @Autowired
    public EpreuveController(EpreuveService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Epreuve>> findAll() {
        return new ResponseEntity<>(service.findAllEpreuves(), HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Epreuve> findOneById(@PathVariable String uuid) {
        Epreuve epreuve = service.findEpreuveById(uuid);
        if(epreuve != null) {
            return new ResponseEntity<>(epreuve, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Epreuve> save(@RequestBody CreateEpreuve createEpreuve) {
        Epreuve createdEpreuve = service.create(createEpreuve);
        return new ResponseEntity<>(createdEpreuve, HttpStatus.CREATED);
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
            @RequestBody UpdateEpreuve updateEpreuve) {
        boolean isUpdated = service.update(uuid, updateEpreuve);
        if(isUpdated) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}