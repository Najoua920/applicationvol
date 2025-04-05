package Metier;
import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Entity;
import lombok.Data;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@DiscriminatorValue("STANDARD")
public class ProduitStandard extends Produit {
}
