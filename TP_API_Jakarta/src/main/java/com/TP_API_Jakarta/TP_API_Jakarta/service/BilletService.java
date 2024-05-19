package com.TP_API_Jakarta.TP_API_Jakarta.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import com.TP_API_Jakarta.TP_API_Jakarta.repository.BilletRepository;
import com.TP_API_Jakarta.TP_API_Jakarta.dto.CreateBillet;
import com.TP_API_Jakarta.TP_API_Jakarta.dto.UpdateBillet;
import com.TP_API_Jakarta.TP_API_Jakarta.model.Billet;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class BilletService {
	private final BilletRepository repository;

    @Autowired
    public BilletService(BilletRepository repository) {
		this.repository = repository;
	}

	public List<Billet> findAllBillets() {
		return repository.findAllByDeletedAtNull();
	}

	public Billet findBilletById(String uuid) {
		return repository.findOneByUuid(uuid).orElse(null);
	}

	public Billet create(CreateBillet Billet) {
		Billet BilletACreer = new Billet(
            Billet.getPrix(),
            Billet.getNbBillet()
            
		);
		return repository.save(BilletACreer);
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
