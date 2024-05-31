package com.TP_API_Jakarta.TP_API_Jakarta.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import com.TP_API_Jakarta.TP_API_Jakarta.repository.BilletRepository;
import com.TP_API_Jakarta.TP_API_Jakarta.repository.EpreuveRepository;
import com.TP_API_Jakarta.TP_API_Jakarta.dto.CreateBillet;
import com.TP_API_Jakarta.TP_API_Jakarta.dto.UpdateBillet;
import com.TP_API_Jakarta.TP_API_Jakarta.model.Billet;
import com.TP_API_Jakarta.TP_API_Jakarta.model.Epreuve;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class BilletService {
	private final BilletRepository repository;

    @Autowired
    public BilletService(BilletRepository repository) {
		this.repository = repository;
	}

	@Autowired
    private EpreuveRepository epreuveRepository;

	public List<Billet> findAllBillets() {
		return repository.findAllByDeletedAtNull();
	}

	public Billet findBilletById(String uuid) {
		return repository.findOneByUuid(uuid).orElse(null);
	}

	public Billet createBillet(CreateBillet billetDto) {
        
        Epreuve epreuve = epreuveRepository.findById(billetDto.getEpreuveUuid())
                .orElseThrow(() -> {
                    return new RuntimeException("Epreuve not found");
                });

        Billet billet = new Billet(billetDto.getPrix(), billetDto.getNbBillet());
        billet.setEpreuve(epreuve);

        return repository.save(billet);
    }

	@Transactional
	public boolean delete(String uuid) {
		Billet BilletASupprimer = findBilletById(uuid);
		if(BilletASupprimer != null && BilletASupprimer.getDeletedAt() == null) {
			BilletASupprimer.setDeletedAt(LocalDateTime.now());
			repository.save(BilletASupprimer);
			return true;
		}
		return false;
	}

	public boolean update(String uuid, UpdateBillet Billet) {
		Billet BilletAModifier = findBilletById(uuid);

		if(BilletAModifier != null) {
			BilletAModifier.setPrix(Billet.getPrix());
			BilletAModifier.setNbBillet(Billet.getNbBillet());
			repository.save(BilletAModifier);
			return true;
		}
		return false;
		
	}

}
