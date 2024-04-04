package com.orcs.orcamentos.repositories;


import com.orcs.orcamentos.models.OrcModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrcRepository extends JpaRepository<OrcModel, UUID> {
    @Query("SELECT o FROM OrcModel o WHERE o.idOrc = :id")
    Optional<OrcModel> findByIdOrc(int id);
}
