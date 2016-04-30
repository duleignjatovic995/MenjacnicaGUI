package menjacnica;

public class Kurs {

	private int sifra;
	private String skraceniNaziv;
	private double prodajniKurs;
	private double srednjiKurs;
	private double kupovniKurs;
	private String naziv;
	
	public Kurs(){
	}
	
	public Kurs(int sifra, String skraceniNaziv, double prodajniKurs, double srednjiKurs, double kupovniKurs,
			String naziv) {
		super();
		this.sifra = sifra;
		this.skraceniNaziv = skraceniNaziv;
		this.prodajniKurs = prodajniKurs;
		this.srednjiKurs = srednjiKurs;
		this.kupovniKurs = kupovniKurs;
		this.naziv = naziv;
	}

	public int getSifra() {
		return sifra;
	}
	public void setSifra(int sifra) {
		this.sifra = sifra;
	}
	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}
	public void setSkraceniNaziv(String skraceniNaziv) {
		this.skraceniNaziv = skraceniNaziv;
	}
	public double getProdajniKurs() {
		return prodajniKurs;
	}
	public void setProdajniKurs(double prodajniKurs) {
		this.prodajniKurs = prodajniKurs;
	}
	public double getSrednjiKurs() {
		return srednjiKurs;
	}
	public void setSrednjiKurs(double srednjiKurs) {
		this.srednjiKurs = srednjiKurs;
	}
	public double getKupovniKurs() {
		return kupovniKurs;
	}
	public void setKupovniKurs(double kupovniKurs) {
		this.kupovniKurs = kupovniKurs;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
	
}
