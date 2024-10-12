package com.example.Crud_Api.Controller;

import com.example.Crud_Api.Model.Personne;
import com.example.Crud_Api.Service.Servicepersonne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/personne")
public class PersonneController {

    // -------------------------------------------------Inject Service-----------------------------------------------//

    @Autowired
    private Servicepersonne servicepersonne;

     // ------------------------------------------------GEt All Personnes--------------------------------------------//

    @GetMapping
     public List<Personne>Getinfopersonne(){
         return  servicepersonne.getpersonne();
     }

     // ------------------------------------------------CREATE-------------------------------------------------------//
    @PostMapping("/add")
    public ResponseEntity<Personne>Addpersonne(@RequestBody Personne personne){
         Personne Addpersonne=servicepersonne.savepersonne(personne);
         return  new ResponseEntity<>(Addpersonne , HttpStatus.CREATED);

    }

    //-----------------------------------INSERET Avec MESSAGE Confirmation  ------------------------------------//

//Post avec Message d'erreur
    //@PostMapping("/add")
   // public ResponseEntity<Personne>Addpersonne(@RequestBody Personne personne){
     //   Personne Addpersonne= servicepersonne.savepersonne(personne);
    //   Map<String ,Object> response = new HashMap<>();
    //   response.put("message","La Personne "+ Addpersonne.getNom()+"a ajoute avec Suscce");
    //   response.put("personne",Addpersonne);
     //   return  new ResponseEntity<>( Addpersonne, HttpStatus.CREATED);

   // }

    //-----------------------------------------------DELETE-----------------------------------------------------//

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Personne>deletepersonne(@PathVariable long id){
         Personne Deletepersonne= servicepersonne.deletepersonne(id);
         return  new ResponseEntity<>(Deletepersonne , HttpStatus.OK);
    }

    //-----------------------------------------------Get By ID-------------------------------------------------//
   @GetMapping("/{id}")
    public Personne GetpresonnebyId(@PathVariable long id){
         return servicepersonne.getperssonbyId(id);
   }
   //----------------------------------------------------Update------------------------------------------------//
    @PutMapping("/{id}")
    public Personne Updatepersonne(@PathVariable long id, @RequestBody Personne personne){
         return servicepersonne.updatepersonne(id, personne);
    }




}
