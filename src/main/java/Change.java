import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Data
@Getter
@Setter
@NoArgsConstructor
public class Change {

  private long piece2 = 0;
  private long billet5 = 0;
  private long billet10 = 0;



  @Override
  public String toString(){
    return "\nPièce de 2€ ="+piece2+"\nBillets de 5€ ="+billet5+";\nBillets de 10€ ="+billet10+"";
  }
  public static Change optimalChange(BigInteger s){
    if(s.longValue() < 3) {
      return null;
    }

    Change change = new Change();
    long reste;
    change.billet10 = s.longValue() / Monnaie.Dix.getValeur();
    reste = s.longValue() % Monnaie.Dix.getValeur();

    if(reste < Monnaie.Cinque.getValeur() && reste %Monnaie.Deux.getValeur() != 0){
      if(change.billet10>0){
        change.billet10=change.billet10-1;
        reste = reste + Monnaie.Dix.getValeur();
      }
    }
    change.billet5 = reste / Monnaie.Cinque.getValeur();
    reste = reste % Monnaie.Cinque.getValeur();

    if(reste != 0 && reste % Monnaie.Deux.getValeur() != 0){
      if(change.billet5 > 0 ){
        change.billet5--;
        reste = reste + Monnaie.Cinque.getValeur();
      }
    }
    if(reste % Monnaie.Deux.getValeur() == 0)
      change.piece2 = reste / Monnaie.Deux.getValeur() ;

    System.out.println("Somme de départ: "+ s+
      change.toString());
    return change;
  }




}
