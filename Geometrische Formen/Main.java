import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
//import javax.swing.JMenuBar;
import java.awt.GridBagConstraints;
//import javax.swing.JMenu;
//import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Insets;
//import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;

public class Main {

	private JFrame frame;
	private CardLayout myCL;
	private String schluessel;
	private CardLayout clMain;
	private Nutzer angemeldeterNutzer;
	private JTextField tfNutzer;
	private JPasswordField passwordField;
	private JTextField txtNutzerAnm;
	private JPasswordField pwdKennwAnm;
	private JTextField txtKrRadius;
	private JTextField txtRchteckLenght;
	private JTextField txtRchtckHigh;
	private JTextField txtDrckAnke;
	private JTextField txtDrckKathe;
	private JTextField txtQuadZahl;
	private JTextField txtDrckFLHoehe;
	private JTextField txtDrckFLHypo;
	private JPasswordField pwdKennBest;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					String url = "jdbc:mysql://localhost/geometrie";
//					String user = "root";
//					String pwd = "1111";
					if(Datenbank.testDB()) {
						Main window = new Main();
						window.frame.setVisible(true);
					}else {
						System.exit(1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
/*
 * public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(Datenbank.testDB()) {
						LCMain window = new LCMain();
						window.frame.setVisible(true);
					}else {
						System.exit(0);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 * 	
 */
	
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(Datenbank.testDB()) {
	//					myCL window = new myCL();
	//					window.frame.setVisible(true);
					}else {
						System.exit(0);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the application.
	 */
	public Main() {
		myCL = new CardLayout();
		initialize();
		myCL.show(frame.getContentPane(), "panelLogin");
		
		JPanel panelDrckFlaeche = new JPanel();
		frame.getContentPane().add(panelDrckFlaeche, "panelDrckFlaeche");
		GridBagLayout gbl_panelDrckFlaeche = new GridBagLayout();
		gbl_panelDrckFlaeche.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelDrckFlaeche.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelDrckFlaeche.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelDrckFlaeche.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelDrckFlaeche.setLayout(gbl_panelDrckFlaeche);
		
		JLabel lblDrckFLHoehe = new JLabel("Hoehe");
		GridBagConstraints gbc_lblDrckFLHoehe = new GridBagConstraints();
		gbc_lblDrckFLHoehe.insets = new Insets(0, 0, 5, 5);
		gbc_lblDrckFLHoehe.gridx = 3;
		gbc_lblDrckFLHoehe.gridy = 2;
		panelDrckFlaeche.add(lblDrckFLHoehe, gbc_lblDrckFLHoehe);
		
		txtDrckFLHoehe = new JTextField();
		GridBagConstraints gbc_txtDrckFLHoehe = new GridBagConstraints();
		gbc_txtDrckFLHoehe.insets = new Insets(0, 0, 5, 5);
		gbc_txtDrckFLHoehe.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDrckFLHoehe.gridx = 6;
		gbc_txtDrckFLHoehe.gridy = 2;
		panelDrckFlaeche.add(txtDrckFLHoehe, gbc_txtDrckFLHoehe);
		txtDrckFLHoehe.setColumns(10);
		
		JLabel lblDrckFLHypo = new JLabel("Grundseite");
		GridBagConstraints gbc_lblDrckFLHypo = new GridBagConstraints();
		gbc_lblDrckFLHypo.insets = new Insets(0, 0, 5, 5);
		gbc_lblDrckFLHypo.gridx = 3;
		gbc_lblDrckFLHypo.gridy = 3;
		panelDrckFlaeche.add(lblDrckFLHypo, gbc_lblDrckFLHypo);
		
		txtDrckFLHypo = new JTextField();
		GridBagConstraints gbc_txtDrckFLHypo = new GridBagConstraints();
		gbc_txtDrckFLHypo.insets = new Insets(0, 0, 5, 5);
		gbc_txtDrckFLHypo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDrckFLHypo.gridx = 6;
		gbc_txtDrckFLHypo.gridy = 3;
		panelDrckFlaeche.add(txtDrckFLHypo, gbc_txtDrckFLHypo);
		txtDrckFLHypo.setColumns(10);
		
		JButton btnDrckFLEingabe = new JButton("Eingabe");
		btnDrckFLEingabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
/*				String high = String.valueOf(txtDrckFLHoehe.getText());
				String hypo = String.valueOf(txtDrckFLHoehe.getText());
				double b = Double.valueOf(high);
				double a = Double.valueOf(hypo);
				double ba = b * a ;
				int i = 2;
				Object Ergb = (ba/2);
				System.out.println(Ergb = "= Flaecheninhalt");
				
*/			}
		});
		GridBagConstraints gbc_btnDrckFLEingabe = new GridBagConstraints();
		gbc_btnDrckFLEingabe.insets = new Insets(0, 0, 5, 5);
		gbc_btnDrckFLEingabe.gridx = 3;
		gbc_btnDrckFLEingabe.gridy = 6;
		panelDrckFlaeche.add(btnDrckFLEingabe, gbc_btnDrckFLEingabe);
		
		JButton btnDrckFLVrgAbbr = new JButton("Vorgang abbrechen");
		btnDrckFLVrgAbbr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCL.show(frame.getContentPane(), "panelAuswahl");
			}
		});
		GridBagConstraints gbc_btnDrckFLVrgAbbr = new GridBagConstraints();
		gbc_btnDrckFLVrgAbbr.insets = new Insets(0, 0, 5, 5);
		gbc_btnDrckFLVrgAbbr.gridx = 6;
		gbc_btnDrckFLVrgAbbr.gridy = 6;
		panelDrckFlaeche.add(btnDrckFLVrgAbbr, gbc_btnDrckFLVrgAbbr);
		
		JPanel panelDrckSelect = new JPanel();
		frame.getContentPane().add(panelDrckSelect, "panelDrckSelect");
		GridBagLayout gbl_panelDrckSelect = new GridBagLayout();
		gbl_panelDrckSelect.columnWidths = new int[]{0, 0, 0, 0, 117, 0, 0, 0, 0, 0};
		gbl_panelDrckSelect.rowHeights = new int[]{0, 0, -5, 0, 0, 0, 0};
		gbl_panelDrckSelect.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelDrckSelect.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panelDrckSelect.setLayout(gbl_panelDrckSelect);
		
		JSplitPane splitPane = new JSplitPane();
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.insets = new Insets(0, 0, 5, 5);
		gbc_splitPane.fill = GridBagConstraints.VERTICAL;
		gbc_splitPane.gridx = 4;
		gbc_splitPane.gridy = 3;
		panelDrckSelect.add(splitPane, gbc_splitPane);
		
		JButton btnDrckSelUmf = new JButton("Umfang");
		btnDrckSelUmf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCL.show(frame.getContentPane(), "panelDrckUmfang");
			}
		});
		splitPane.setLeftComponent(btnDrckSelUmf);
		
		JButton btnDrckSelFlaeche = new JButton("Flaecheninhalt");
		btnDrckSelFlaeche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCL.show(frame.getContentPane(), "panelDrckFlaeche");
			}
		});
		splitPane.setRightComponent(btnDrckSelFlaeche);
		
		JPanel panelAuswahl = new JPanel();
		frame.getContentPane().add(panelAuswahl, "panelAuswahl");
		GridBagLayout gbl_panelAuswahl = new GridBagLayout();
		gbl_panelAuswahl.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelAuswahl.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelAuswahl.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelAuswahl.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panelAuswahl.setLayout(gbl_panelAuswahl);
		
		JButton btnDreieck = new JButton("Dreieck");
		btnDreieck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCL.show(frame.getContentPane(), "panelDrckSelect");
			}
		});
		GridBagConstraints gbc_btnDreieck = new GridBagConstraints();
		gbc_btnDreieck.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDreieck.insets = new Insets(0, 0, 5, 5);
		gbc_btnDreieck.gridx = 3;
		gbc_btnDreieck.gridy = 3;
		panelAuswahl.add(btnDreieck, gbc_btnDreieck);
		
		JButton btnRechteck = new JButton("Rechteck");
		btnRechteck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCL.show(frame.getContentPane(), "panelRechteck");
			}
		});
		GridBagConstraints gbc_btnRechteck = new GridBagConstraints();
		gbc_btnRechteck.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRechteck.insets = new Insets(0, 0, 5, 5);
		gbc_btnRechteck.gridx = 6;
		gbc_btnRechteck.gridy = 3;
		panelAuswahl.add(btnRechteck, gbc_btnRechteck);
		
		JButton btnQuadrat = new JButton("Quadrat");
		btnQuadrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCL.show(frame.getContentPane(), "panelQuadrat");
			}
		});
		GridBagConstraints gbc_btnQuadrat = new GridBagConstraints();
		gbc_btnQuadrat.insets = new Insets(0, 0, 5, 5);
		gbc_btnQuadrat.gridx = 3;
		gbc_btnQuadrat.gridy = 5;
		panelAuswahl.add(btnQuadrat, gbc_btnQuadrat);
		
		JButton btnKreis = new JButton("Kreis");
		btnKreis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCL.show(frame.getContentPane(), "panelKreis");
			}
		});
		GridBagConstraints gbc_btnKreis = new GridBagConstraints();
		gbc_btnKreis.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnKreis.insets = new Insets(0, 0, 5, 5);
		gbc_btnKreis.gridx = 6;
		gbc_btnKreis.gridy = 5;
		panelAuswahl.add(btnKreis, gbc_btnKreis);
		schluessel = "geheim1234567890";
		System.out.println("Eingabe: qwertz");
		System.out.println("Encrypt:"+AES.encrypt("qwertz", schluessel));
		System.out.println("Decrypt:"+AES.decrypt(AES.encrypt("qwertz", schluessel), schluessel));
		angemeldeterNutzer = new Nutzer();
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(myCL);
		
		JPanel panelLogin = new JPanel();
		frame.getContentPane().add(panelLogin, "panelLogin");
		GridBagLayout gbl_panelLogin = new GridBagLayout();
		gbl_panelLogin.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelLogin.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelLogin.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelLogin.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panelLogin.setLayout(gbl_panelLogin);
		
		JLabel lblNutzerAnm = new JLabel("Nutzername");
		GridBagConstraints gbc_lblNutzerAnm = new GridBagConstraints();
		gbc_lblNutzerAnm.insets = new Insets(0, 0, 5, 5);
		gbc_lblNutzerAnm.gridx = 2;
		gbc_lblNutzerAnm.gridy = 3;
		panelLogin.add(lblNutzerAnm, gbc_lblNutzerAnm);
		
		txtNutzerAnm = new JTextField();
		GridBagConstraints gbc_txtNutzerAnm = new GridBagConstraints();
		gbc_txtNutzerAnm.insets = new Insets(0, 0, 5, 5);
		gbc_txtNutzerAnm.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNutzerAnm.gridx = 5;
		gbc_txtNutzerAnm.gridy = 3;
		panelLogin.add(txtNutzerAnm, gbc_txtNutzerAnm);
		txtNutzerAnm.setColumns(10);
		
		JLabel lblKennwAnm = new JLabel("Kennwort");
		GridBagConstraints gbc_lblKennwAnm = new GridBagConstraints();
		gbc_lblKennwAnm.insets = new Insets(0, 0, 5, 5);
		gbc_lblKennwAnm.gridx = 2;
		gbc_lblKennwAnm.gridy = 4;
		panelLogin.add(lblKennwAnm, gbc_lblKennwAnm);
		
		pwdKennwAnm = new JPasswordField();
		GridBagConstraints gbc_pwdKennwAnm = new GridBagConstraints();
		gbc_pwdKennwAnm.insets = new Insets(0, 0, 5, 5);
		gbc_pwdKennwAnm.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdKennwAnm.gridx = 5;
		gbc_pwdKennwAnm.gridy = 4;
		panelLogin.add(pwdKennwAnm, gbc_pwdKennwAnm);
		
		JLabel lblKennwAnmBest = new JLabel("Kennwort best\u00E4tigen");
		GridBagConstraints gbc_lblKennwAnmBest = new GridBagConstraints();
		gbc_lblKennwAnmBest.insets = new Insets(0, 0, 5, 5);
		gbc_lblKennwAnmBest.gridx = 2;
		gbc_lblKennwAnmBest.gridy = 5;
		panelLogin.add(lblKennwAnmBest, gbc_lblKennwAnmBest);
		
		JButton btnAnmBest = new JButton("Anmelden");
		btnAnmBest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String eKennwort = String.valueOf(pwdKennwAnm.getPassword());
				Nutzer tmpNutzer = new Nutzer();
								tmpNutzer.setNutzer(txtNutzerAnm.getText());
								tmpNutzer = Datenbank.getKennwort(tmpNutzer);
				if(tmpNutzer.getKennwort().equals("1111")) {
									angemeldeterNutzer.setInit(true);
									myCL.show(frame.getContentPane(), "panelAuswahl");
				}
				if((tmpNutzer.getNutzer().equals("admin")) && (eKennwort.equals(tmpNutzer.getKennwort())) && (angemeldeterNutzer.isInit())) {
									myCL.show(frame.getContentPane(), "panelAuswahl");
				angemeldeterNutzer.setNutzer(tmpNutzer.getNutzer());
									angemeldeterNutzer.setKennwort(eKennwort);
								}else {
				tmpNutzer.setKennwort(Datenbank.getKennwort(tmpNutzer).getKennwort());
				System.out.println("tmpNutzer: "+tmpNutzer.getKennwort());
									System.out.println("Encrypt: "+AES.encrypt(eKennwort, schluessel));
									System.out.println(tmpNutzer.getKennwort());
									System.out.println(eKennwort);
									if(tmpNutzer.getKennwort().equals(AES.encrypt(eKennwort, schluessel))) {
										JOptionPane.showMessageDialog(panelLogin, "Herzlich willkommen", "ANMELDUNG", JOptionPane.INFORMATION_MESSAGE);
										myCL.show(frame.getContentPane(), "panelAuswahl");
									}else {
										JOptionPane.showMessageDialog(panelLogin, "Anmeldung war NICHT erfolgreich", "ANMELDUNG", JOptionPane.ERROR_MESSAGE);
									}
								}
							}
						});
		
		pwdKennBest = new JPasswordField();
		GridBagConstraints gbc_pwdKennBest = new GridBagConstraints();
		gbc_pwdKennBest.insets = new Insets(0, 0, 5, 5);
		gbc_pwdKennBest.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdKennBest.gridx = 5;
		gbc_pwdKennBest.gridy = 5;
		panelLogin.add(pwdKennBest, gbc_pwdKennBest);
		GridBagConstraints gbc_btnAnmBest = new GridBagConstraints();
		gbc_btnAnmBest.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnmBest.gridx = 2;
		gbc_btnAnmBest.gridy = 7;
		panelLogin.add(btnAnmBest, gbc_btnAnmBest);
		
		JButton btnAnmAbbr = new JButton("Vorgang abbrechen");
		btnAnmAbbr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		GridBagConstraints gbc_btnAnmAbbr = new GridBagConstraints();
		gbc_btnAnmAbbr.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnmAbbr.gridx = 5;
		gbc_btnAnmAbbr.gridy = 7;
		panelLogin.add(btnAnmAbbr, gbc_btnAnmAbbr);
		
		JPanel panelKreis = new JPanel();
		frame.getContentPane().add(panelKreis, "panelKreis");
		GridBagLayout gbl_panelKreis = new GridBagLayout();
		gbl_panelKreis.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelKreis.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelKreis.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelKreis.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelKreis.setLayout(gbl_panelKreis);
		
		JLabel lblKrRadius = new JLabel("Radius");
		GridBagConstraints gbc_lblKrRadius = new GridBagConstraints();
		gbc_lblKrRadius.insets = new Insets(0, 0, 5, 5);
		gbc_lblKrRadius.gridx = 2;
		gbc_lblKrRadius.gridy = 3;
		panelKreis.add(lblKrRadius, gbc_lblKrRadius);
		
		txtKrRadius = new JTextField();
		GridBagConstraints gbc_txtKrRadius = new GridBagConstraints();
		gbc_txtKrRadius.insets = new Insets(0, 0, 5, 5);
		gbc_txtKrRadius.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtKrRadius.gridx = 5;
		gbc_txtKrRadius.gridy = 3;
		panelKreis.add(txtKrRadius, gbc_txtKrRadius);
		txtKrRadius.setColumns(10);
		
		JButton btnKrEingabe = new JButton("Eingabe");
		btnKrEingabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtKrRadius.getText().isEmpty()) {
					Radius kreis = new Radius();
					kreis.setRadius(Double.parseDouble(txtKrRadius.getText()));
					kreis=Datenbank.testKreis(kreis);
					
				}
			}
		});
		
		JButton btnKrUmf = new JButton("Umfang");
		btnKrUmf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtKrRadius.getText().isEmpty()) {
				//	txtKrRadius.getText()
				}
			}
		});
		GridBagConstraints gbc_btnKrUmf = new GridBagConstraints();
		gbc_btnKrUmf.insets = new Insets(0, 0, 5, 5);
		gbc_btnKrUmf.gridx = 2;
		gbc_btnKrUmf.gridy = 5;
		panelKreis.add(btnKrUmf, gbc_btnKrUmf);
		
		
		GridBagConstraints gbc_btnKrEingabe = new GridBagConstraints();
		gbc_btnKrEingabe.insets = new Insets(0, 0, 5, 5);
		gbc_btnKrEingabe.gridx = 2;
		gbc_btnKrEingabe.gridy = 7;
		panelKreis.add(btnKrEingabe, gbc_btnKrEingabe);
		
		JButton btnKrVrgAbbr = new JButton("Vorgang abbrechen");
		btnKrVrgAbbr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCL.show(frame.getContentPane(), "panelAuswahl");
			}
		});
		GridBagConstraints gbc_btnKrVrgAbbr = new GridBagConstraints();
		gbc_btnKrVrgAbbr.insets = new Insets(0, 0, 5, 5);
		gbc_btnKrVrgAbbr.gridx = 5;
		gbc_btnKrVrgAbbr.gridy = 7;
		panelKreis.add(btnKrVrgAbbr, gbc_btnKrVrgAbbr);
		
		JPanel panelRechteck = new JPanel();
		frame.getContentPane().add(panelRechteck, "panelRechteck");
		GridBagLayout gbl_panelRechteck = new GridBagLayout();
		gbl_panelRechteck.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelRechteck.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelRechteck.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelRechteck.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelRechteck.setLayout(gbl_panelRechteck);
		
		JLabel lblRchtckLaenge = new JLabel("L\u00E4nge/Breite");
		GridBagConstraints gbc_lblRchtckLaenge = new GridBagConstraints();
		gbc_lblRchtckLaenge.insets = new Insets(0, 0, 5, 5);
		gbc_lblRchtckLaenge.gridx = 2;
		gbc_lblRchtckLaenge.gridy = 2;
		panelRechteck.add(lblRchtckLaenge, gbc_lblRchtckLaenge);
		
		txtRchteckLenght = new JTextField();
		GridBagConstraints gbc_txtRchteckLenght = new GridBagConstraints();
		gbc_txtRchteckLenght.insets = new Insets(0, 0, 5, 5);
		gbc_txtRchteckLenght.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRchteckLenght.gridx = 5;
		gbc_txtRchteckLenght.gridy = 2;
		panelRechteck.add(txtRchteckLenght, gbc_txtRchteckLenght);
		txtRchteckLenght.setColumns(10);
		
		JLabel lblRchtckHoehe = new JLabel("H\u00F6he");
		GridBagConstraints gbc_lblRchtckHoehe = new GridBagConstraints();
		gbc_lblRchtckHoehe.insets = new Insets(0, 0, 5, 5);
		gbc_lblRchtckHoehe.gridx = 2;
		gbc_lblRchtckHoehe.gridy = 3;
		panelRechteck.add(lblRchtckHoehe, gbc_lblRchtckHoehe);
		
		txtRchtckHigh = new JTextField();
		GridBagConstraints gbc_txtRchtckHigh = new GridBagConstraints();
		gbc_txtRchtckHigh.insets = new Insets(0, 0, 5, 5);
		gbc_txtRchtckHigh.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRchtckHigh.gridx = 5;
		gbc_txtRchtckHigh.gridy = 3;
		panelRechteck.add(txtRchtckHigh, gbc_txtRchtckHigh);
		txtRchtckHigh.setColumns(10);
		
		JButton btnRchtecktEingabe = new JButton("Eingabe");
		btnRchtecktEingabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtRchteckLenght.getText().isEmpty() && !txtRchtckHigh.getText().isEmpty()) {
					/* leng = Rechteck.this.getLengh(txtRchteckLenght.getText());
					Rechteck right = new Rechteck();
					right.setUmfang();
					*/
				//	if(Rechteck.this.getLengh())
				}
			}
		});
/*		btnRchtecktEingabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String RchtckLengh = String.valueOf(txtRchteckLenght.getText());
				String RchtckHigh = String.valueOf(txtRchtckHigh.getText());
				int i = 2;
				if(!RchtckLengh.isEmpty() && !RchtckHigh.isEmpty()) {
					double b = Double.valueOf(RchtckLengh);
					double a = Double.valueOf(RchtckHigh);
					double bb = b + b ;
					double aa = a + a ;
 wrong			double Ergb = aa * bb ;
					Object ErgebnisUM = (i*(a+b));
					Object ErgebnisFL = (a*b);
					System.out.println(ErgebnisUM = "= Umfang");
					System.out.println(ErgebnisFL = "Flaecheninhalt");
					System.out.println(Ergb);				// .toString?
					
					/*					Object ErgB = b + b ;
					Object ErgA = a + a ;
					Object Ergebnis = ErgB.toString()  ;
					
				}
			}
		});*/
		GridBagConstraints gbc_btnRchtecktEingabe = new GridBagConstraints();
		gbc_btnRchtecktEingabe.insets = new Insets(0, 0, 5, 5);
		gbc_btnRchtecktEingabe.gridx = 2;
		gbc_btnRchtecktEingabe.gridy = 7;
		panelRechteck.add(btnRchtecktEingabe, gbc_btnRchtecktEingabe);
		
		JButton btnRchtckVrgAbbr = new JButton("Vorgang abbrechen");
		btnRchtckVrgAbbr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCL.show(frame.getContentPane(), "panelAuswahl");
			}
		});
		GridBagConstraints gbc_btnRchtckVrgAbbr = new GridBagConstraints();
		gbc_btnRchtckVrgAbbr.insets = new Insets(0, 0, 5, 5);
		gbc_btnRchtckVrgAbbr.gridx = 5;
		gbc_btnRchtckVrgAbbr.gridy = 7;
		panelRechteck.add(btnRchtckVrgAbbr, gbc_btnRchtckVrgAbbr);
		
		JPanel panelDrckUmfang = new JPanel();
		frame.getContentPane().add(panelDrckUmfang, "panelDrckUmfang");
		GridBagLayout gbl_panelDrckUmfang = new GridBagLayout();
		gbl_panelDrckUmfang.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelDrckUmfang.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelDrckUmfang.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelDrckUmfang.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelDrckUmfang.setLayout(gbl_panelDrckUmfang);
		
		JLabel lblDrckHypotenuse = new JLabel("Hypotenuse");
		GridBagConstraints gbc_lblDrckHypotenuse = new GridBagConstraints();
		gbc_lblDrckHypotenuse.insets = new Insets(0, 0, 5, 5);
		gbc_lblDrckHypotenuse.gridx = 2;
		gbc_lblDrckHypotenuse.gridy = 2;
		panelDrckUmfang.add(lblDrckHypotenuse, gbc_lblDrckHypotenuse);
		
		JTextField txtDrckHypo = new JTextField();
		GridBagConstraints gbc_txtDrckHypo = new GridBagConstraints();
		gbc_txtDrckHypo.insets = new Insets(0, 0, 5, 5);
		gbc_txtDrckHypo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDrckHypo.gridx = 5;
		gbc_txtDrckHypo.gridy = 2;
		panelDrckUmfang.add(txtDrckHypo, gbc_txtDrckHypo);
		txtDrckHypo.setColumns(10);
		
		JLabel lblDrckAnkathete = new JLabel("Ankathete");
		GridBagConstraints gbc_lblDrckAnkathete = new GridBagConstraints();
		gbc_lblDrckAnkathete.insets = new Insets(0, 0, 5, 5);
		gbc_lblDrckAnkathete.gridx = 2;
		gbc_lblDrckAnkathete.gridy = 3;
		panelDrckUmfang.add(lblDrckAnkathete, gbc_lblDrckAnkathete);
		
		txtDrckAnke = new JTextField();
		GridBagConstraints gbc_txtDrckAnke = new GridBagConstraints();
		gbc_txtDrckAnke.insets = new Insets(0, 0, 5, 5);
		gbc_txtDrckAnke.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDrckAnke.gridx = 5;
		gbc_txtDrckAnke.gridy = 3;
		panelDrckUmfang.add(txtDrckAnke, gbc_txtDrckAnke);
		txtDrckAnke.setColumns(10);
		
		JLabel lblDrckGgenKathete = new JLabel("Gegenkathete");
		GridBagConstraints gbc_lblDrckGgenKathete = new GridBagConstraints();
		gbc_lblDrckGgenKathete.insets = new Insets(0, 0, 5, 5);
		gbc_lblDrckGgenKathete.gridx = 2;
		gbc_lblDrckGgenKathete.gridy = 4;
		panelDrckUmfang.add(lblDrckGgenKathete, gbc_lblDrckGgenKathete);
		
		txtDrckKathe = new JTextField();
		GridBagConstraints gbc_txtDrckKathe = new GridBagConstraints();
		gbc_txtDrckKathe.insets = new Insets(0, 0, 5, 5);
		gbc_txtDrckKathe.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDrckKathe.gridx = 5;
		gbc_txtDrckKathe.gridy = 4;
		panelDrckUmfang.add(txtDrckKathe, gbc_txtDrckKathe);
		txtDrckKathe.setColumns(10);
		
		JButton btnDrckEingabe = new JButton("Eingabe");
		btnDrckEingabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtDrckHypo.getText().isEmpty() && !txtDrckAnke.getText().isEmpty() && !txtDrckKathe.getText().isEmpty()) {
					Dreieck val = new Dreieck();
					val.setUmfang((Double.parseDouble(txtDrckHypo.getText())) && (Double.parseDouble(txtDrckAnke.getText())) && (Double.parseDouble(txtDrckKathe.getText())));
					val=Datenbank.testDreieck(val);
					
				}
			}
		});
/*		btnDrckEingabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hypo = String.valueOf(txtDrckHypo);
				String anke = String.valueOf(txtDrckAnke.getText());
				String kathete = String.valueOf(txtDrckKathe.getText());
				if(!hypo.isEmpty() && !anke.isEmpty() && !kathete.isEmpty()) {
					double a = Double.valueOf(hypo);
					double b = Double.valueOf(anke);
					double c = Double.valueOf(kathete);
//					double abc = (a + b + c) ;
					Object Ergbnis = ( a + b + c);
					System.out.println(Ergbnis = "= Umfang");
					
				}
			}
		});*/
		GridBagConstraints gbc_btnDrckEingabe = new GridBagConstraints();
		gbc_btnDrckEingabe.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDrckEingabe.insets = new Insets(0, 0, 5, 5);
		gbc_btnDrckEingabe.gridx = 2;
		gbc_btnDrckEingabe.gridy = 7;
		panelDrckUmfang.add(btnDrckEingabe, gbc_btnDrckEingabe);
		
		JButton btnDrckVrgAbbr = new JButton("Vorgang abbrechen");
		btnDrckVrgAbbr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCL.show(frame.getContentPane(), "panelAuswahl");
			}
		});
		GridBagConstraints gbc_btnDrckVrgAbbr = new GridBagConstraints();
		gbc_btnDrckVrgAbbr.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDrckVrgAbbr.insets = new Insets(0, 0, 5, 5);
		gbc_btnDrckVrgAbbr.gridx = 5;
		gbc_btnDrckVrgAbbr.gridy = 7;
		panelDrckUmfang.add(btnDrckVrgAbbr, gbc_btnDrckVrgAbbr);
		
		JPanel panelQuadrat = new JPanel();
		frame.getContentPane().add(panelQuadrat, "panelQuadrat");
		GridBagLayout gbl_panelQuadrat = new GridBagLayout();
		gbl_panelQuadrat.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelQuadrat.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelQuadrat.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelQuadrat.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelQuadrat.setLayout(gbl_panelQuadrat);
		
		JLabel lblQuadzahl = new JLabel("Zahl");
		GridBagConstraints gbc_lblQuadzahl = new GridBagConstraints();
		gbc_lblQuadzahl.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuadzahl.gridx = 3;
		gbc_lblQuadzahl.gridy = 3;
		panelQuadrat.add(lblQuadzahl, gbc_lblQuadzahl);
		
		txtQuadZahl = new JTextField();
		GridBagConstraints gbc_txtQuadZahl = new GridBagConstraints();
		gbc_txtQuadZahl.insets = new Insets(0, 0, 5, 5);
		gbc_txtQuadZahl.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtQuadZahl.gridx = 6;
		gbc_txtQuadZahl.gridy = 3;
		panelQuadrat.add(txtQuadZahl, gbc_txtQuadZahl);
		txtQuadZahl.setColumns(10);
		
		JButton btnQuadEingabe = new JButton("Eingabe");
/*		btnQuadEingabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String quad = String.valueOf(txtQuadZahl.getText());
				if(!quad.isEmpty()) {
					double b = Double.valueOf(quad);
				}
			}
		});*/
		GridBagConstraints gbc_btnQuadEingabe = new GridBagConstraints();
		gbc_btnQuadEingabe.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQuadEingabe.insets = new Insets(0, 0, 5, 5);
		gbc_btnQuadEingabe.gridx = 3;
		gbc_btnQuadEingabe.gridy = 6;
		panelQuadrat.add(btnQuadEingabe, gbc_btnQuadEingabe);
		
		JButton btnQuadBruch = new JButton("Abbrechen");
		btnQuadBruch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCL.show(frame.getContentPane(), "panelAuswahl");
			}
		});
		GridBagConstraints gbc_btnQuadBruch = new GridBagConstraints();
		gbc_btnQuadBruch.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQuadBruch.insets = new Insets(0, 0, 5, 5);
		gbc_btnQuadBruch.gridx = 6;
		gbc_btnQuadBruch.gridy = 6;
		panelQuadrat.add(btnQuadBruch, gbc_btnQuadBruch);
	
	}

}
