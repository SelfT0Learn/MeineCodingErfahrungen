
public class Radius {
	private double radius;
	private double umfang;
	private double flaeche;
	
	public Radius() {
		super();
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	/**
	 * @return the umfang
	 */
	public double getUmfang() {
		
		return umfang;
	}

	/**
	 * @param umfang the umfang to set
	 */
	public void setUmfang() {
		this.umfang = 2*Math.PI*radius;
	}
	public void setUmfang2(double d) {
		this.umfang = d;
	}

	/**
	 * @return the flaeche
	 */
	public double getFlaeche() {
		return flaeche;
	}

	/**
	 * @param flaeche the flaeche to set
	 */
	public void setFlaeche() {
		this.flaeche = Math.PI*Math.pow(radius, 2);
	}
	public void setFlaeche2(double d) {
		this.flaeche = d;
	}
	
}
/*
String Radius = String.valueOf(txtKrRadius.getText());
				double i = 3.14;
				int a = 2;
				if(!Radius.isEmpty()) {
					double b = Double.valueOf(Radius);
					Object Erg = b * (i * a);
					// Umfang
					// System.out.println(Erg.toString() = " = Umfang");	Object zu String ausgabe?
					System.out.println(Erg = " = Umfang");
					Object Ergebnis = i * b;
					// Flaeche
					System.out.println(Ergebnis = "= Flaecheninhalt");
					// Ergebnis in Datenbank speichern
					
				}
*/