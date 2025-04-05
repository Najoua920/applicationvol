package DAO;

import Metier.Produit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ImplProduit implements Iproduit{
    private EntityManager em;
    private EntityManagerFactory emf;
    public ImplProduit() {
        emf = Persistence.createEntityManagerFactory("TpJpa");
        em = emf.createEntityManager();
    }


    @Override
    public void ajouterProduit(Produit p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

    @Override
    public void modifierProduit(Long referance, Produit np) {
        em.getTransaction().begin();
        Produit p = getProduit(referance);
        if (p != null) {
            p.setDestination(np.getDestination());
            p.setPrix(np.getPrix());
            p.setQuantite(np.getQuantite());
        }
        em.getTransaction().commit();
    }

    @Override
    public Produit getProduit(Long ref) {
        return em.find(Produit.class, ref);
    }

    @Override
    public void SupprimerProduit(Long ref) {
        em.getTransaction().begin();
        Produit p = getProduit(ref);
        if (p != null) {
            em.remove(p);
        }
        em.getTransaction().commit();
    }

    @Override
    public List<Produit> ConsulterProduits() {
        return em.createQuery("SELECT p FROM Produit p", Produit.class).getResultList();
    }
}

