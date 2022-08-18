import java.math.BigInteger;

public class Main {
  public static void main(String[] args) {
    System.out.println("Bienvenue sur le jeu merveilleux du CHANGE !");
    BigInteger test = new BigInteger("7");
    Change change = Change.optimalChange(test);
  }
}
