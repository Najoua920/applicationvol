package Metier;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Magasin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idm;

    private String lieu;
    @ManyToMany
    private List<Produit> produits;


}
