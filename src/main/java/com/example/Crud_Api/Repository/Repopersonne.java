package com.example.Crud_Api.Repository;

import com.example.Crud_Api.Model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repopersonne
        extends JpaRepository<Personne, Long> {
}
