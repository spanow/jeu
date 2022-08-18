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
    return "[Pièce de 2€ ="+piece2+"; Billets de 5€ ="+billet5+"; Billets de 10€ ="+billet10+"]";
  }
  public static Change optimalChange(BigInteger s){
    if(s.longValue() < 3) {
      return null;
    }

    Change change = new Change();
    long rest;
    change.billet10 = s.longValue() / Monnaie.Dix.getValeur();
    rest = s.longValue() % Monnaie.Dix.getValeur();

    if(rest < Monnaie.Cinque.getValeur() && rest %Monnaie.Deux.getValeur() != 0){
      if(change.billet10>0){
        change.billet10=change.billet10-1;
        rest = rest + Monnaie.Dix.getValeur();
      }
    }
    change.billet5 = rest / Monnaie.Cinque.getValeur();
    rest = rest % Monnaie.Cinque.getValeur();

    if(rest != 0 && rest % Monnaie.Deux.getValeur() != 0){
      if(change.billet5 > 0 ){
        change.billet5--;
        rest = rest + Monnaie.Cinque.getValeur();
      }
    }
    if(rest % Monnaie.Deux.getValeur() == 0){
      change.piece2 = rest / Monnaie.Deux.getValeur() ;
    }
    System.out.println(change.toString() + " => Somme de départ: "+ s);
    return change;
  }

  private long sum(){
    return Monnaie.Deux.getValeur()*piece2 + Monnaie.Cinque.getValeur()*billet5 + Monnaie.Dix.getValeur()*billet10;
  }


}
