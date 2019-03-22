package control;

import java.util.ArrayList;
import java.util.Scanner;

import objects.PLaylist;
import objects.Song;

public class LlistaPlaylist {
	/* Atributs */
	private ArrayList<PLaylist> lista = new ArrayList<PLaylist>();
	
	
	/* Constuctor */
	public LlistaPlaylist() {
		
	}
	
	/* Mètodes */
	public ArrayList<PLaylist> getLista() {
		return lista;
	}
	
	public void setLista(ArrayList<PLaylist> lista) {
		this.lista = lista;
	}
	
	public void createPlayList(){
		String nombre = "";
		String description = "";
		Scanner sc=new Scanner(System.in);
		System.out.println("Introdueix un nom identificatiu:");
		nombre = sc.nextLine();
		System.out.println("Introdueix una descripció:");
		description = sc.nextLine();
		PLaylist p =  new PLaylist(nombre.toUpperCase(), description);
		if(findPlayList(nombre) == null) {
			this.lista.add(p);	
		}else {
			System.out.println("Aquesta PLaylist ja existeix:");
		}
	}

	public void dropList() {
		String nom = "";
		Scanner sc=new Scanner(System.in);
		System.out.println("Quina Playlist vols borrar:");
		nom = sc.nextLine();
		PLaylist p = findPlayList(nom);
		if(p != null) {
			System.out.println("S'ha borrat la Playlist "+p.getNom().toLowerCase());
			this.lista.remove(p);
		}else{  
			System.out.println("La Playlist "+nom+" no existeix.");
		}		
	}

	public PLaylist getPlaylistToAddSong() {
		PLaylist p = findPlayList();
		if(p == null) {
			System.out.println("La Playlist no existeix.");
			return null;
		}
		return p;
	}
	
	public int addSongToPlaylist(PLaylist p) {
		Song c =createSong();
		Song cExist = findSong(p, c.getTitol());
		if(cExist != null) {
			System.out.println("La canço ja existeix a la Plailist "+p.getNom());
			return 1;
		}else {
			p.addSong(c);
			return 2;
		}		
	}
	
	public void findSong() {
		String nom = "";
		Scanner sc=new Scanner(System.in);
		System.out.println("Quina canço vols cercar:");
		nom = sc.nextLine();
		for (PLaylist p : this.lista) {
			for (Song c : p.getSongs()) {
				if(nom.toUpperCase().equals(c.getTitol())) {
					System.out.println(p.getNom()+"  "+p.getDescription());
					System.out.println(" -- "+c.getTitol()+"  "+c.getDescripcio()+"  "+c.getDurada()+"  "+c.getAny());
				}
			}
		}
				
	}
	
	public void printList(PLaylist p) {
		System.out.println(p.toString());
		for (Song c : p.getSongs()) {
			System.out.println(" -- "+c.getTitol()+"  "+c.getDescripcio()+"  "+c.getDurada()+"  "+c.getAny());
		}		
	}
	
	public void printListAll() {
		if(this.lista.size() == 0) System.out.println("La llista està buida.");
		for (PLaylist p : this.lista) {
			System.out.println(p.toString());
			for (Song c : p.getSongs()) {
				System.out.println(" -- "+c.toString());
			}
		}		
	}
	
	private Song findSong(PLaylist p, String nom) {
		for (Song c : p.getSongs()) {
			if(c.getTitol().equals(nom.toUpperCase()))return c;
		}
		return null;
	}
	
	private Song createSong(){
		String nom = "";
		String titol = "";
		String descripcio = "";
		int any = 0;
		String durada = "";
		Scanner sc=new Scanner(System.in);
		System.out.println("Introdueix un nom identificatiu de la cançó:");
		nom = sc.nextLine();
		System.out.println("Introdueix el titol:");
		titol = sc.nextLine();
		System.out.println("Introdueix una descripció:");
		descripcio = sc.nextLine();
		System.out.println("Introdueix l'any de creació:");
		any = sc.nextInt() ;
		System.out.println("Introdueix la durada amb el format 00:00:");
		durada = sc.next();
		Song c = new Song(nom, titol.toUpperCase(), descripcio, any, durada);
		
		return c;
	}
	
	private PLaylist findPlayList(){
		String nom = "";
		Scanner sc=new Scanner(System.in);
		System.out.println("Quina Playlist vols:");
		nom = sc.nextLine();
		
		for (PLaylist p : this.lista) {
			if(p.getNom().equals(nom.toUpperCase())) return p;
		}
		return null;
	}
	
	private PLaylist findPlayList(String nom){
		for (PLaylist p : this.lista) {
			if(p.getNom().equals(nom.toUpperCase())) return p;
		}
		return null;
	}
		
	
}
