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
					menjacnica = new Menjacnica();
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

}
