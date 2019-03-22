package objects;

public class Song {
	/* Atributs  */
	private String nom = "";
	private String titol = "";
	private String descripcio = "";
	private int any = 1900;
	private String durada = "00:00";
	
	/* Constructors  */
	public Song() {
	}
	
	public Song(String nom, String titol, String descripcio, int any, String durada) {
		this.nom = nom;
		this.titol = titol;
		this.descripcio = descripcio;
		this.any = any;
		this.durada = durada;
	}
	
	public Song(Song s) {
		this.nom = s.getNom();
		this.titol = s.getTitol();
		this.descripcio = s.getDescripcio();
		this.any = s.getAny();
		this.durada = s.getDurada();
	}
	
	
	/* Mètodes */
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	public int getAny() {
		return any;
	}

	public void setAny(int any) {
		this.any = any;
	}

	public String getDurada() {
		return durada;
	}

	public void setDurada(String durada) {
		this.durada = durada;
	}

	@Override
	public String toString() {
		return this.titol+"  "+this.descripcio+" "+this.any+"  "+this.durada;
	}
	
}
