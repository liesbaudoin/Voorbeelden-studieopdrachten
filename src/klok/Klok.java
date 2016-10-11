package klok;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import klokgui.KlokFrame;

public class Klok extends Thread {

  private GregorianCalendar tijd = new GregorianCalendar();
  private boolean stoppen = false;
  private ArrayList<Stad> steden = new ArrayList<Stad>();
  private Stad stad = null;
  private KlokFrame gui = null;

  public Klok(KlokFrame gui) {
    voegStedenToe();
    stad = steden.get(0);
    tijd.add(Calendar.MINUTE, stad.getTijdverschil());
    this.gui = gui;
  }

  public GregorianCalendar getTijd() {
    return tijd;
  }

  /*
   * wijzigt de stad @param index: de index van de stad in de lijst
   */
  public void wijzigStad(int index) {
    stad = steden.get(index);
  }

  /*
   * geeft een lijst met stadsnamen
   */
  public ArrayList<String> geefNamen() {
    ArrayList<String> stadsNamen = new ArrayList<String>();
    for (Stad stad : steden) {
      stadsNamen.add(stad.getNaam());
    }
    return stadsNamen;
  }

  /*
   * verzet elke seconde de klok, tot deze moet stoppen de tijd wordt elke
   * seconde opnieuw opgevraagd
   */
  public void run() {
    while (!stoppen) {
      tijd = new GregorianCalendar();
      tijd.add(Calendar.MINUTE, stad.getTijdverschil());
      gui.update();
      try {
        Thread.sleep(1000);
      }
      catch (InterruptedException e) {
      }
    }
  }

  // public void startKlok(){
  // Thread thread = new Thread(this);
  // thread.start();
  // }

  public void stopKlok() {
    stoppen = true;
  }

  private void voegStedenToe() {
    steden.add(new Stad("Amsterdam", 0));
    steden.add(new Stad("London", -60));
    steden.add(new Stad("New York", -360));
    steden.add(new Stad("Pretoria", 60));
    steden.add(new Stad("Moskou", 120));
    steden.add(new Stad("New Delhi", 270));
    steden.add(new Stad("Beijing", 360));
    steden.add(new Stad("Melbourne", 540));
    steden.add(new Stad("Wellington", 660));
  }

}
