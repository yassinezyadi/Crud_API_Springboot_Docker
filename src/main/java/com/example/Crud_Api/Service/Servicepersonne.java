package com.example.Crud_Api.Service;

import com.example.Crud_Api.Model.Personne;
import com.example.Crud_Api.Repository.Repopersonne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Servicepersonne {

    // ------------------------------------------------Inject Repository---------------------------------------------//
    @Autowired
    private Repopersonne repopersonne;

    //--------------------------------------------------Get All-----------------------------------------------------//

    public List<Personne> getpersonne(){
        return  repopersonne.findAll();
    }
    //------------------------------------------------- CRETAE------------------------------------------------------//

    public Personne savepersonne(Personne personne){
        return  repopersonne.save(personne);
    }
    //--------------------------------------------------DELETE-----------------------------------------------------//

    public  Personne deletepersonne(long Id){
        Personne Supprimerper= repopersonne.findById(Id).orElseThrow(()->new RuntimeException("Personne fund"));
        repopersonne.delete(Supprimerper);
        return Supprimerper;
    }

    //------------------------------------- -----------Get By Id -------------------------------------------------//
    public Personne getperssonbyId(long Id){
        return repopersonne.findById(Id).orElseThrow(()->new RuntimeException("Personne funnd"));
    }
    //-------------------------------------------------UPDATE----------------------------------------------------//
    public Personne updatepersonne(long id , Personne infopresone){
        Personne personne= repopersonne.findById(id).orElseThrow();
        personne.setNom(infopresone.getNom());
        personne.setPrenom(infopresone.getPrenom());
        personne.setAge(infopresone.getAge());
        personne.setImage(infopresone.getImage());
        return repopersonne.save(personne);
    }





}
