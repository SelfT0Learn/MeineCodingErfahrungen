import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 */

/**
 * @author cct-o
 *
 */
public class Datenbank {
	private static Connection con;
	private static Statement stmnt;
	private static ResultSet rs;
	private static String url = "jdbc:mysql://";
	private static String user ="";
	private static String pwd = "";
	private static PreparedStatement myPrep;
	
	
	
	public static boolean testDB() {
		boolean ret = false;
		try {
			File f = new File("src\\passwd.txt");
			BufferedReader br = new BufferedReader(new FileReader(f));
			String host = br.readLine();
			String port = br.readLine();
			String db = br.readLine();
			String locUser = br.readLine();
			String locPwd = br.readLine();
			br.close();
			Datenbank.url += host + ":" + port +  "/" + db;
			Datenbank.user = locUser;
			Datenbank.pwd = locPwd;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ret;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ret;
		}
		try {
			con = DriverManager.getConnection(url, user, pwd);
			ret = true;
			con.close();
			con = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	public static String getKennwort(String nutzer) {
		String ret = "";
		try {
			con = DriverManager.getConnection(url, user, pwd);
			stmnt = con.createStatement();
			rs = stmnt.executeQuery("SELECT kennwort FROM nutzer WHERE nutzer='"+ nutzer +"'");
			if (rs.next()) {
				ret = rs.getString(1);
			}
			con.close();
			rs.close();
			rs = null;
			stmnt.close();
			stmnt = null;
			con = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	public static void setKenntwort(Nutzer n) {
		try {
			con = DriverManager.getConnection(url, user, pwd);
			stmnt = con.createStatement();
			stmnt.executeUpdate("UPDATE nutzer SET kennwort='"+ n.getKennwort() +"' WHERE nutzer='"+ n.getNutzer() +"'");
			con.close();
			stmnt = null;
			con = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Nutzer getKennwort(Nutzer tmpNutzer) {
		// TODO Auto-generated method stub
		tmpNutzer.setKennwort("");
		try {
			con = DriverManager.getConnection(url, user, pwd);
			stmnt = con.createStatement();
			rs = stmnt.executeQuery("SELECT kennwort FROM nutzer WHERE nutzer='"+ tmpNutzer.getNutzer() +"'");
			if (rs.next()) {
				tmpNutzer.setKennwort(rs.getString(1));
			}
			con.close();
			rs = null;
			stmnt = null;
			con = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmpNutzer;
	}
	public static Radius testKreis(Radius kreis) {
		// TODO Auto-generated method stub
		//select erid from radius where radius=kreis.getradius();
		// else ergebnisse auf null setzen
		// umfang flaeche in kreis object wiedergeben 
		// methode saveKReis -> ergebnisse einfügen
/*
 * Radius kreis = new Radius();
					kreis.setRadius(Double.parseDouble(txtKrRadius.getText()));
					kreis=Datenbank.testKreis(kreis);
 * 		public double getFlaeche() {
		return flaeche;
		public void setFlaeche() {
		this.flaeche = Math.PI*Math.pow(radius, 2);
	}
	}
 */
		try {
			con = DriverManager.getConnection(url, user, pwd);
			stmnt = con.createStatement();
			rs = stmnt.executeQuery("select erid from radius where radius="+ kreis.getRadius());
			int erid=0;
			if (rs.next()) {
				// rs.next() zum abrufen von daten aus der datenbank, funktioniert nur bei select
				// wenn man nicht weiß ob man überhaupt einen datensatz zurück kriegt so nimmt man eine while schleife (rs.next())
				// kreis.setRadius(rs.getDouble(1));
				/*if(kreis.getRadius() == kreis.getUmfang()) {
					
				}*/
				// denn geht er weiter vergleich getradius from gui to database
				// zum String umwandeln?
				// double wert raus kitzeln und mit dem arbeiten damit das nächste rs stmnt greifen kann
				// kreis.setRadius(Double.parseDouble(txtKrRadius.getText()));
				// double val = Double.parseDouble(str);
				// double val = Double.parseDouble(rs);
				// rs.getDouble(kreis.getRadius());
				// CustomData cd = new CustomData();
				// cd.setString1(rs.getString(1));
				//cd.setInt1(rs.getInt(2));
				erid=rs.getInt(1);
				stmnt.close();
				stmnt=null;
				rs.close();
				rs=null;
				rs=stmnt.executeQuery("SELECT umfang, flaeche FROM ergebnis WHERE erid="+erid);
				rs.next();
				kreis.setUmfang2(rs.getDouble(1));
				kreis.setFlaeche2(rs.getDouble(2));
				
//				String val = rs.toString(stmnt.executeQuery("select erid from radius where radius='"+ kreis.getRadius() + "'"));
//				rs = stmnt.executeQuery("select umfang from ergebnis where umfang='"+ kreis.getUmfang() + "'");
	
			}else {
				// wenn nicht vorhanden saveKreis, myPrep
				rs = null;
				con.close();
				stmnt = null;
				con = null;
			}
			con.close();
			rs = null;
			stmnt = null;
			con = null;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return kreis;
	}
	
/*
 * if(m.getKennwort().equals("admin")) {
					myRS = myStmnt.executeQuery("Select vorname, nachname, recht, bezeichnung from mitarbeiter, abteilung where idAbteilung = abteilung_idAbteilung and "
							+ "nutzername = \""+ m.getNutzername() + "\" and kennwort = \""+ m.getKennwort() +"\"");
				}else {
					myPrepStmnt = myCon.prepareStatement("select vorname, nachname, recht, bezeichnung from mitarbeiter, abteilung where idAbteilung= abteilung_idAbteilung and nutzername=? and kennwort=SHA1(?)");
					myPrepStmnt.setString(1, m.getNutzername());
					myPrepStmnt.setString(2, m.getKennwort());
					myRS = myPrepStmnt.executeQuery();
				}	
 */
	
/*
 * if(m.getRecht() == 1) {
//					myStmnt = myCon.createStatement();
//					myRS = myStmnt.executeQuery("select kennwort");
					myPrepStmnt = myCon.prepareStatement("select idMitarbeiter from mitarbeiter where kennwort=? and recht= ?");
					// für das erste fragezeichen kennwort=?
					myPrepStmnt.setString(1, "admin");
					// für das zweite fragezeichen recht=?
					myPrepStmnt.setInt(2, 1);
					//executy Query ohen parameter da ich den parameter zuvor schon erfasst habe
					myRS = myPrepStmnt.executeQuery();
					// wenn ich ein datensatz zurück bekomme
					// dann muss ich den mitarbeiter mit id 1 löschen
					if(myRS.next()) {
						// solange ich den vom Typ PrepStmnt nicht mehr brauche, kann ich das auch wiederverwenden 
						//da ich ein anderes objekt mit prepare statement einsetzen möchte
						// damit ist der dummy denn weg
						PreparedStatement myPS = myCon.prepareStatement("delete from mitarbeiter where idMitarbeiter= ?");
						myPS.setInt(1, myRS.getInt("idMitarbeiter"));
						//kein result set zurück
						//aufjedenfall gelöscht
						myPS.executeUpdate();
						// Ressource wieder frei geben
						myPS.close();
						myPS = null;
					}
				}
 * 	
 */
	public static Radius saveKreis(Radius save) {
		try {
			con = DriverManager.getConnection(url, user, pwd);
			// stmnt = con.createStatement();
			stmnt = con.createStatement();
			rs = stmnt.executeQuery("select erid from radius where radius='"+ save.getRadius() + "'");
			myPrep = con.prepareStatement("select idMitarbeiter from mitarbeiter where kennwort=? and recht= ?");
			myPrep.setUmfang(1, "admin");
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return save;
	}

	public static Dreieck testDreieck(Dreieck val) {
		try {
			con = DriverManager.getConnection(url, user, pwd);
			stmnt = con.createStatement();
			rs = stmnt.executeQuery("select drid from dreieck where='"+ val.getGegenKathete() +"'");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return val;
	}
}
