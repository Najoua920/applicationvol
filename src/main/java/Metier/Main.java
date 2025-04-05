package Metier;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Créer une instance d'EntityManagerFactory à partir du fichier persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();

        // Démarrer une transaction
        em.getTransaction().begin();

        // 1️⃣ Création d'un catalogue de produits
        CatalogueProduit catalogue = new CatalogueProduit();
        catalogue.setCategorie("Épicerie");
        em.persist(catalogue);

        // 2️⃣ Création de produits
        ProduitFrais produitFrais = new ProduitFrais();
        produitFrais.setDestination("Yaourt");
        produitFrais.setPrix(3.5);
        produitFrais.setQuantite(50);
        produitFrais.setDatePeremption(new Date());
        produitFrais.setCategorie(catalogue);

        ProduitStandard produitStandard = new ProduitStandard();
        produitStandard.setDestination("Riz");
        produitStandard.setPrix(2.0);
        produitStandard.setQuantite(100);
        produitStandard.setCategorie(catalogue);

        // Ajouter les produits au catalogue
        catalogue.ajouterProduit(produitFrais);
        catalogue.ajouterProduit(produitStandard);

        // Persister les produits
        em.persist(produitFrais);
        em.persist(produitStandard);

        //  Création de magasins
        Magasin magasin1 = new Magasin();
        magasin1.setLieu("Casablanca");

        Magasin magasin2 = new Magasin();
        magasin2.setLieu("Rabat");

        //  Associer des produits aux magasins
        magasin1.setProduits(Arrays.asList(produitFrais, produitStandard));
        magasin2.setProduits(Arrays.asList(produitStandard));

        // Persister les magasins
        em.persist(magasin1);
        em.persist(magasin2);

        // Valider la transaction
        em.getTransaction().commit();

        // Fermer l'EntityManager
        em.close();
        emf.close();

        System.out.println(" Données insérées avec succès !");
    }
}
