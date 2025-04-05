package Metier;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import jakarta.persistence.Entity;
import lombok.Data;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@DiscriminatorValue("FRAIS")

public class ProduitFrais extends Produit {
    public Date datePeremption;

}
