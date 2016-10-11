package klok;

public class Stad {
  private String naam = null;
  private int tijdverschil = 0;

  public Stad(String naam, int tijdverschil) {
    this.naam = naam;
    this.tijdverschil = tijdverschil;
  }

  public String getNaam() {
    return naam;
  }

  public int getTijdverschil() {
    return tijdverschil;
  }
}
