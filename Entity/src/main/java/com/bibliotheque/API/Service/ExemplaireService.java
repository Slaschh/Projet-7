package com.bibliotheque.API.Service;

import com.bibliotheque.API.Entity.Exemplaire;
import com.bibliotheque.API.Repository.ExemplaireRepository;
import com.bibliotheque.API.Utility.LoggingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExemplaireService {

    @Autowired
    ExemplaireRepository exemplaireRepository;

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    public List<Exemplaire> findAll() {
        logger.info("List Exemplaire");
        List<Exemplaire> exemplaires = this.exemplaireRepository.findAll();
        return exemplaires;
    }

    public Exemplaire findById(int id) {
        logger.info("Exemplaire id " + id);
        Exemplaire exemplaire = this.exemplaireRepository.findById(id).get();
        return exemplaire;
    }

    public void save(Exemplaire exemplaire) {
        logger.info("save new exemplaire = " + exemplaire.id);
        exemplaireRepository.save(exemplaire);
    }

    public void delete(int id) {
        logger.info("delete = " + id);
        Exemplaire exemplaire = this.exemplaireRepository.findById(id).get();
        exemplaireRepository.delete(exemplaire);
    }

    public List<Exemplaire> findByBook_id(int id) {
        logger.info("find Exemplaire by Book Id = " + id);
        List<Exemplaire> exemplaires = this.exemplaireRepository.findByBook_id(id);
        return exemplaires;
    }
}

