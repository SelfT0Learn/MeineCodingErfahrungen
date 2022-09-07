/**
 * 
 */

/**
 * @author cct-o
 *
 */
public class Nutzer {
	private String nutzer;
	private String kennwort;
	private boolean init;
	
	
	
	public String getNutzer() {
		return nutzer;
	}

	public void setNutzer(String nutzer) {
		this.nutzer = nutzer;
	}

	public String getKennwort() {
		return kennwort;
	}

	public void setKennwort(String kennwort) {
		this.kennwort = kennwort;
	}

	public boolean isInit() {
		return init;
	}

	public void setInit(boolean init) {
		this.init = init;
	}

	public Nutzer() {
		super();
		init = false;
	}
}
