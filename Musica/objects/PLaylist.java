package objects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PLaylist {

	private String nom = "";
	private String description = "";
	private Date date;
	private ArrayList<Song> songs = new ArrayList<Song>();
	
	public PLaylist() {
	}
	
	public PLaylist(String nom,String description ) {
		this.nom = nom;
		this.description = description;
		this.date = new Date();
	}
	
	public PLaylist(PLaylist p) {
		this.nom = p.getNom();
		this.description = p.getDescription();
		this.date = p.getDate();
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public ArrayList<Song> getSongs() {
		return songs;
	}
	
	public void setSongs(ArrayList<Song> songs) {
		this.songs = songs;
	}
	
	public void addSong(Song c) {
		this.songs.add(c);
	}

}
