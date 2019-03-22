package objects;

import java.util.Scanner;

import control.LlistaPlaylist;

public class Menu {
	/* Atributs */
	private LlistaPlaylist lp = new LlistaPlaylist();
	
	public void initApp() {
		int o = 0;
		while(o != 7) {
			int secondMenu = 1; 
			pintarMenu();
			o = seleccionaInt();
			switch (o) {
			case 1:
				lp.createPlayList();
				break;
			case 2:
				lp.dropList();
				break;
			case 3:
				PLaylist pl = lp.getPlaylistToAddSong(); 
				while (secondMenu == 1 && pl != null) {
					if(lp.addSongToPlaylist(pl) == 1) {
						this.pintarMenu2();
						secondMenu = seleccionaInt();
					}else {
						secondMenu = 0;
					}
				}
				break;
			case 4:
				lp.findSong();
				break;
			case 5:
				PLaylist plp = lp.getPlaylistToAddSong(); 
				if(plp != null)lp.printList(plp);
				break;
			case 6:
				lp.printListAll();
				break;
			case 7:
				System.out.println("Adeu");
				break;
			default:
				System.out.println("Aquest punt de menu no existeix");
				break;
			}
		}
		
	}
	
	private void pintarMenu() {
		System.out.println(" 1.- Afegir playlist ");
		System.out.println(" 2.- Esborrar plalist ");
		System.out.println(" 3.- Afegir cançó a la playlist ");
		System.out.println(" 4.- Cercar cançó ");
		System.out.println(" 5.- Llistar Playlist ");
		System.out.println(" 6.- Imprimir totes les playlist");
		System.out.println(" 7.- Sortir");
	}
	
	private void pintarMenu2() {
		System.out.println(" 1.- Afegir un altre cançó");
		System.out.println(" 2.- Sortir");
	}
	
	private int seleccionaInt() {
		Scanner sc=new Scanner(System.in);
		int o =  sc.nextInt();
		return o;
	}
	
	
		
}
