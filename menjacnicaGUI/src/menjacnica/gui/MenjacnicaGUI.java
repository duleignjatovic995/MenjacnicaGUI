package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.border.TitledBorder;

import menjacnica.Kurs;
import menjacnica.gui.model.TableModelMenjacnica;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.LinkedList;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;

public class MenjacnicaGUI extends JFrame {

	private JPanel contentPane;
	private JPanel jpnlButton;
	private JPanel jpnlStatus;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnDodajkurs;
	private JButton btnIzbrisiKurs;
	private JButton btnIzvrsiIzmenu;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnHelp;
	private JMenuItem mntmAbout;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JScrollPane scrollPane_1;
	private JPanel panel;
	private JScrollPane scrollPane_2;
	private JTextArea txtStatus;

	

	/**
	 * Create the frame.
	 */
	public MenjacnicaGUI() {
		setTitle("Menjacnca");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 800, 368);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getJpnlButton(), BorderLayout.EAST);
		contentPane.add(getJpnlStatus(), BorderLayout.SOUTH);
		contentPane.add(getScrollPane_1(), BorderLayout.NORTH);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GUIKontroler.ugasiAplikaciju();
			}
		});
		
	}
	
	

	private JPanel getJpnlButton() {
		if (jpnlButton == null) {
			jpnlButton = new JPanel();
			jpnlButton.setPreferredSize(new Dimension(130, 10));
			jpnlButton.setLayout(null);
			jpnlButton.add(getBtnDodajkurs());
			jpnlButton.add(getBtnIzbrisiKurs());
			jpnlButton.add(getBtnIzvrsiIzmenu());
		}
		return jpnlButton;
	}
	private JPanel getJpnlStatus() {
		if (jpnlStatus == null) {
			jpnlStatus = new JPanel();
			jpnlStatus.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "STATUS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			jpnlStatus.setPreferredSize(new Dimension(10, 60));
			jpnlStatus.setLayout(new BorderLayout(0, 0));
			jpnlStatus.add(getPanel(), BorderLayout.CENTER);
		}
		return jpnlStatus;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			TableModelMenjacnica model = new TableModelMenjacnica(null);
			table.setModel(model);
		}
		return table;
	}
	private JButton getBtnDodajkurs() {
		if (btnDodajkurs == null) {
			btnDodajkurs = new JButton("Dodaj kurs");
			btnDodajkurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DodajKursGUI dodaj = new DodajKursGUI();
					dodaj.setVisible(true);
				}
			});
			btnDodajkurs.setBounds(10, 11, 110, 23);
		}
		return btnDodajkurs;
	}
	private JButton getBtnIzbrisiKurs() {
		if (btnIzbrisiKurs == null) {
			btnIzbrisiKurs = new JButton("Izbrisi kurs");
			btnIzbrisiKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int red = table.getSelectedRow();
					if (red == -1) {
						JOptionPane.showMessageDialog(null, "Morate izabrati kurs za brisanje.", "Greska", JOptionPane.WARNING_MESSAGE);
					} else {
						int rValue = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da obrisete kurs?", "Brisanje kursa", JOptionPane.YES_NO_OPTION);
						if (rValue == JOptionPane.OK_OPTION) {
							TableModelMenjacnica model = (TableModelMenjacnica) table.getModel();
							Kurs k = model.vratiKurs(rValue);
							try {
								GUIKontroler.obrisiKurs(k);
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(null, "Greska pri brisanju.", "Kurs nije obrisan", JOptionPane.WARNING_MESSAGE);
								return;
							}
							GUIKontroler.ispisiStatus(k.getSifra()+"", k.getSkraceniNaziv(), k.getProdajniKurs()+"", k.getSrednjiKurs()+"", k.getKupovniKurs()+"", k.getNaziv());
							JOptionPane.showMessageDialog(null, "Kurs uspesno obrisan", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			});
			btnIzbrisiKurs.setBounds(10, 45, 110, 23);
		}
		return btnIzbrisiKurs;
	}
	private JButton getBtnIzvrsiIzmenu() {
		if (btnIzvrsiIzmenu == null) {
			btnIzvrsiIzmenu = new JButton("Izvrsi izmenu");
			btnIzvrsiIzmenu.setBounds(10, 79, 110, 23);
		}
		return btnIzvrsiIzmenu;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmOpen());
			mnFile.add(getMntmSave());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JDialog jdg = new JDialog();
					jdg.setTitle("About");
					jdg.getContentPane().add(new JLabel("Dusan Ignjatovic"));
					jdg.setBounds(0, 0, 120, 120);
					jdg.setVisible(true);
				}
			});
		}
		return mntmAbout;
	}
	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser jfc = new JFileChooser();
					int rValue = jfc.showOpenDialog(getContentPane());
					if (rValue == JFileChooser.APPROVE_OPTION) {
						File file = jfc.getSelectedFile();
						String imeFajla = file.getName();
						String path = file.getAbsolutePath();
						txtStatus.append("Ucitan fajl: " + imeFajla + "\nGde: " + path + "\n");
					}
				}
			});
			mntmOpen.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
			mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		}
		return mntmOpen;
	}
	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
			mntmSave.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
			mntmSave.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JFileChooser jfc = new JFileChooser();
					int rValue = jfc.showOpenDialog(getContentPane());
					if (rValue == JFileChooser.APPROVE_OPTION) {
						File file = jfc.getSelectedFile();
						String imeFajla = file.getName();
						String path = file.getAbsolutePath();
						txtStatus.append("Sacuvan fajl fajl: " + imeFajla + "\nGde: " + path + "\n");
					}
					
				}
			});
		}
		return mntmSave;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
			mntmExit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.ugasiAplikaciju();
				}
			});
		}
		return mntmExit;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
		}
		return scrollPane_1;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			panel.add(getScrollPane_2());
		}
		return panel;
	}
	private JScrollPane getScrollPane_2() {
		if (scrollPane_2 == null) {
			scrollPane_2 = new JScrollPane();
			scrollPane_2.setViewportView(getTxtStatus());
		}
		return scrollPane_2;
	}
	private JTextArea getTxtStatus() {
		if (txtStatus == null) {
			txtStatus = new JTextArea();
		}
		return txtStatus;
	}
	
	public void osveziTabelu(){
		TableModelMenjacnica model = (TableModelMenjacnica) table.getModel();
		model.ucitajKurseve(GUIKontroler.vratiKurseve());
	}
	
	public void ispisiStatus(String status){
		txtStatus.append(status);
	}
}
