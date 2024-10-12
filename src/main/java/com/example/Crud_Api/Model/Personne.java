package com.example.Crud_Api.Model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Personne")
public class Personne {
    @Id
    @SequenceGenerator(
            name = "personne_id",
            sequenceName = "personne_id",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "personne_id"
    )

    private  long id;
    private String nom;
    private String prenom;
    private Integer age;
    private String image;

    //Constrctur
    public Personne(long id, String nom, String prenom, Integer age, String image) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.image = image;
    }

    public Personne() {

    }
    // Get et Set

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
   // Equalse
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return id == personne.id && Objects.equals(nom, personne.nom) && Objects.equals(prenom, personne.prenom) && Objects.equals(age, personne.age) && Objects.equals(image, personne.image);
    }
   // HaseCode
    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, age, image);
    }

    //tostring
    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", image='" + image + '\'' +
                '}';
    }
}
