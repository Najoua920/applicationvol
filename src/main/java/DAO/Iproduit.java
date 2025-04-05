package DAO;

import Metier.Produit;

import java.util.List;

public interface Iproduit {
    void ajouterProduit(Produit p);
    void modifierProduit(Long referance,Produit p);
    Produit getProduit(Long ref);
    void SupprimerProduit(Long ref);
    List<Produit> ConsulterProduits();



}
