package menjacnica.gui.model;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import menjacnica.Kurs;

public class TableModelMenjacnica extends AbstractTableModel{
	private List<Kurs> kursevi;
	
	private static final long serialVersionUID = 1L;
	private final String[] kolone = {"Sifra", "Skraceni naziv", "Prodajni", "Srednji", "Kupovni", "Naziv"};
	
	public TableModelMenjacnica() {
	}
	
	public TableModelMenjacnica(List<Kurs> kursevi) {
		if (kursevi==null) {
			this.kursevi = new LinkedList<>();
		} else {
			this.kursevi = kursevi;
		}
	}	
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return kolone[column];
	}

	@Override
	public int getRowCount() {
		return kursevi.size();
	}

	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Kurs kurs = kursevi.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return kurs.getSifra();
		case 1:
			return kurs.getSkraceniNaziv();
		case 2:
			return kurs.getProdajniKurs();
		case 3:
			return kurs.getSrednjiKurs();
		case 4:
			return kurs.getKupovniKurs();
		case 5:
			return kurs.getNaziv();

		default:
			return "N/A";
		}
	}
	
	public void ucitajKurseve(List<Kurs> kursevi){
		this.kursevi = kursevi;
		fireTableDataChanged();
	}

}
