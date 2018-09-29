package com.oscarjeancesar.pucmm.practica10oscarjeancesar.data;

import com.oscarjeancesar.pucmm.practica10oscarjeancesar.model.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, Long> {
    Familia findById(long id);
}
