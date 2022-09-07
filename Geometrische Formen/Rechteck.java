
public class Rechteck {
	private double lengh;
	private double high;
	private double umfang;
	private double flaeche;
	
	public Rechteck() {
		super();
	}
	
	public double getLengh() {
		return lengh;
	}
	public void setLengh(double lengh) {
		this.lengh = lengh;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getFlaeche() {
		return flaeche;
	}
	public void setFlaeche() {
		this.flaeche = Math.pow(Rechteck.this.getLengh(), Rechteck.this.getLengh());
	}
	public double getUmfang() {
		return umfang;
	}
	public void setUmfang() {
		this.umfang = ( Rechteck.this.getLengh() + Rechteck.this.getLengh()) * ( Rechteck.this.getHigh() + Rechteck.this.getHigh() );
	}
}
