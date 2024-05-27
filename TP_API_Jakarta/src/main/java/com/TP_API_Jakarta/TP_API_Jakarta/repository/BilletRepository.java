package com.TP_API_Jakarta.TP_API_Jakarta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.TP_API_Jakarta.TP_API_Jakarta.model.Billet;
import java.util.List;
import java.util.Optional;

@Repository
public interface BilletRepository extends JpaRepository<Billet, String> {
    List<Billet> findAll();

    List<Billet> findAllByDeletedAtNull();

    Optional<Billet> findOneByUuid(String uuid);
}


