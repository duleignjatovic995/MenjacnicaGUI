package menjacnica.gui;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JOptionPane;

import menjacnica.Kurs;
import menjacnica.Menjacnica;

public class GUIKontroler {
	private static MenjacnicaGUI frame;
	private static Menjacnica menjacnica;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menjacnica = new Menjacnica(null);
					frame = new MenjacnicaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void ugasiAplikaciju(){
		int izbor = JOptionPane.showConfirmDialog(frame.getContentPane(), "Da li sigurno zelite da ugasite aplikaciju?",
				"Zatvaranje aplikacije", JOptionPane.YES_NO_CANCEL_OPTION);
		if (izbor == JOptionPane.OK_OPTION) {
			System.exit(0);
		}
	}
	
	public static List<Kurs> vratiKurseve(){
		return menjacnica.vratiSveKurseve();
	}
	
	public static void unesiKurs(String sifraKursa, String skraceniNaziv, String prodajniKurs, String srednjiKurs,
			String kupovniKurs, String nazivKursa) {
		try {
			int sifra = Integer.parseInt(sifraKursa);
			String skraceni = skraceniNaziv;
			double prodajni = Double.parseDouble(prodajniKurs);
			double srednji = Double.parseDouble(srednjiKurs);
			double kupovni = Double.parseDouble(kupovniKurs);
			String naziv = nazivKursa;
			Kurs k = new Kurs(sifra, skraceni, prodajni, srednji, kupovni, naziv);

			menjacnica.dodajKurs(k);
			frame.osveziTabelu();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void ispisiStatus(String sifraKursa, String skraceniNaziv, String prodajniKurs, String srednjiKurs, String kupovniKurs, String nazivKursa){
		String status = "Sifra kursa: " + sifraKursa +"Naziv kursa: " + nazivKursa + "Skraceni naziv: " + skraceniNaziv + "Prodajni kurs: "+ prodajniKurs
				+ "Srednji kurs: " + srednjiKurs + "Kupovni kurs: " + kupovniKurs + "\n";
		frame.ispisiStatus(status);
	}
	
	public static void ispisiStatus(String status){
		frame.ispisiStatus(status);
	}

	public static void obrisiKurs(Kurs k) throws Exception {
		menjacnica.obrisiKurs(k);
		frame.osveziTabelu();
		
	}

}
