
public class Dreieck {
	private double gegenKathete;
	private double hypotenuse;
	private double ankathete;
	private double hoehe;
	private double umfang;
	private double flaeche;
	
	public Dreieck() {
		super();
	}
	
	public double getGegenKathete() {
		return gegenKathete;
	}
	public void setGegenKathete(double gegenKathete) {
		this.gegenKathete = gegenKathete;
	}
	public double getHypotenuse() {
		return hypotenuse;
	}
	public void setHypotenuse(double hypotenuse) {
		this.hypotenuse = hypotenuse;
	}
	public double getAnkathete() {
		return ankathete;
	}
	public void setAnkathete(double ankathete) {
		this.ankathete = ankathete;
	}
	public double getHoehe() {
		return hoehe;
	}
	public void setHoehe(double hoehe) {
		this.hoehe = hoehe;
	}
	public double getUmfang() {
		return umfang;
	}
	// Dreieck.gegenKathete+Dreieck.hypotenuse+Dreieck.ankathete ;
	public void setUmfang() {
		this.umfang = Dreieck.this.getAnkathete()+Dreieck.this.getGegenKathete()+Dreieck.this.getHypotenuse();
	}
	public double getFlaeche() {
		return flaeche;
	}
	public void setFlaeche() {
		this.flaeche = Dreieck.this.getHoehe() + Dreieck.this.getHypotenuse();
	}
	
}



/*	public void actionPerformed(ActionEvent e) {
		String hypo = String.valueOf(txtDrckHypo);
		String anke = String.valueOf(txtDrckAnke.getText());
		String kathete = String.valueOf(txtDrckKathe.getText());
		if(!hypo.isEmpty() && !anke.isEmpty() && !kathete.isEmpty()) {
			double a = Double.valueOf(hypo);
			double b = Double.valueOf(anke);
			double c = Double.valueOf(kathete);
//			double abc = (a + b + c) ;
			Object Ergbnis = ( a + b + c);
			System.out.println(Ergbnis = "= Umfang");
}*/
