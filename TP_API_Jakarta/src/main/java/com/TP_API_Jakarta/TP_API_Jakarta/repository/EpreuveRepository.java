package com.TP_API_Jakarta.TP_API_Jakarta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.TP_API_Jakarta.TP_API_Jakarta.model.Epreuve;
import java.util.List;
import java.util.Optional;

@Repository
public interface EpreuveRepository extends JpaRepository<Epreuve, String> {
    List<Epreuve> findAll();

    List<Epreuve> findAllByDeletedAtNull();  

    Optional<Epreuve> findOneByUuid(String uuid);
}
