package menjacnica;

import java.awt.Component;
import java.util.LinkedList;
import java.util.List;

public class Menjacnica {

	private List<Kurs> kursevi;
	
	/*public Menjacnica(){		
	}*/
	
	public Menjacnica(List<Kurs> kursevi){
		if (kursevi == null) {
			this.kursevi = new LinkedList<>();
		} else {
			this.kursevi = kursevi;
		}
	}
	
	public void dodajKurs(Kurs kurs) throws Exception{
		if (kurs == null || kursevi.contains(kurs)) {
			throw new Exception("Kurs ne sme biti null");
		} else {
			kursevi.add(kurs);
		}
	}
	
	public void obrisiKurs(Kurs kurs) throws Exception{
		if (kurs == null || !kursevi.contains(kurs)) {
			throw new Exception("Kurs nije u listi");
		} else {
			kursevi.remove(kurs);
		}
		
	}
	
	public List<Kurs> vratiSveKurseve(){
		return kursevi;
	}

}
