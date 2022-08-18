enum Monnaie {
  Deux(2), Cinque(5), Dix(10);
  private final int valeur;

  private Monnaie(int valeur) {
    this.valeur = valeur;
  }

  public int getValeur() {
    return valeur;
  }
}
