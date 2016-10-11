package klokgui;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.JComboBox;

import klok.Klok;

public class KlokFrame extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel jContentPane = null;
  private JLabel datumTijdLabel = null;
  private JComboBox kiesStadComboBox = null;
  private Klok klok = new Klok(this);
  private static final SimpleDateFormat tijdformaat = new SimpleDateFormat(
      "dd-MM-yy HH:mm:ss");

  /**
   * This is the default constructor
   */
  public KlokFrame() {
    super();
    initialize();
    mijnInit();
  }

  private void mijnInit() {
    for (String naam : klok.geefNamen()) {
      kiesStadComboBox.addItem(naam);
    }
    klok.start();
  }

  public void update() {
    GregorianCalendar tijd = klok.getTijd();
    datumTijdLabel.setText(tijdformaat.format(tijd.getTime()));
  }

  public void kiesStadAction() {
    klok.wijzigStad(kiesStadComboBox.getSelectedIndex());
  }

  /**
   * This method initializes this
   * 
   * @return void
   */
  private void initialize() {
    this.setSize(300, 200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(getJContentPane());
    this.setTitle("JFrame");
    this.addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent e) {
        closeWindow();
      }
    });
  }

  /**
   * This method initializes jContentPane
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJContentPane() {
    if (jContentPane == null) {
      datumTijdLabel = new JLabel();
      datumTijdLabel.setBounds(new Rectangle(14, 10, 265, 52));
      datumTijdLabel.setText("JLabel");
      jContentPane = new JPanel();
      jContentPane.setLayout(null);
      jContentPane.add(datumTijdLabel, null);
      jContentPane.add(getKiesStadComboBox(), null);
    }
    return jContentPane;
  }

  /**
   * This method initializes kiesStadComboBox
   * 
   * @return javax.swing.JComboBox
   */
  private JComboBox getKiesStadComboBox() {
    if (kiesStadComboBox == null) {
      kiesStadComboBox = new JComboBox();
      kiesStadComboBox.setBounds(new Rectangle(13, 89, 262, 37));
      kiesStadComboBox.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          kiesStadAction();
        }
      });
    }
    return kiesStadComboBox;
  }

  private void closeWindow() {
    klok.stopKlok();
    System.exit(0);
  }
}
