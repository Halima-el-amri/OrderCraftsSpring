package com.joseph.entity;


import javax.persistence.*;

@Entity
@Table(name="Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name="libelle")
    private String libelle;
    @Column(name="categorie")
    private String categorie;
    @Column(name="prix")
    private String prix;
    @Column(name="quantity")
    private String quantity;

    public Item() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", categorie='" + categorie + '\'' +
                ", prix='" + prix + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
