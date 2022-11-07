package sablon;

import java.io.FileReader;
import java.util.Scanner;

public class Sablon {

	public static void main(String[] args) {
		//1.feladat
		System.out.println("1.feladat");
		
		try {
			//fajl beolvasasa
			//felulre importalni kell a ket elemet
			//import java.io.FileReader;
			//import java.util.Scanner; ez a ket sor megy a class folotti sorba

			FileReader fr = new FileReader("adatok.txt"); //kerek zarojelbe megy a fajl neve es a kiterjesztes (pl adat.txt vagy adat.csv)
			Scanner sc = new Scanner(fr);

			//most letre kell hozni egy uj osztalyt az adatok tarolasahoz
			//az osztalynak olyan nevet kell leadni mint a feladat temaja
			//ha hazak akkor pl Hazak legyen a neve ha ingatlanok akkor Ingatlanok
			//az osztaly neve mindig nagy betuvel kezdodjon!!

			//mivel tobb adatok fogunk tarolni ezert tomb legyen
			Hazak[] hazak = new Hazak[5]; //a feladat altalaban megmondja mekkora maximum hany adatot tartalmaz a fajl, azt a szamot kell ide irni
			int index = 0; //seged valtozo a tombbhoz

			//a ciklus addig fut amig a fajlba vannak sorok amiket be kell olvasni a programnak
			while(sc.hasNextLine()){
				String sor = sc.nextLine(); //beolvassuk a fajl kovetkezo sorat
				//az osszetartozo adatok altalban egy sorban talalhatoak es az adatok ;-vel vagy ,-vel vannak elvalasztva
				String[] sp = sor.split(","); //feldaraboljuk az egy sorban levo adatokat kulonallo adatokra es eltaroljuk ideiglenesen ebben a tombben
				//az idezojelek koze irjuk milyen karakter megtalalasakor darabolja az adatokat
				hazak[index++] = new Hazak(sp[0], Integer.parseInt(sp[1]), Integer.parseInt(sp[2]), Integer.parseInt(sp[3])); //atadjuk a megfelelo sorrendben az adatokat, ahol szoveget adunk at ott nem tortenik semmi, 
				//ahol szamot kell atadni ott az Integer.parseInt()-el at kell alakitani a szoveeget szamma a zarojelbe megy az adat amit at akarunk alakitani pl(sp[0]) vagy ("1")
			}

			//adatok helyes beolvasasanak ellenorzese kiiratassal
			for (int i = 0; i < hazak.length; i++) {
				hazak[i].kiir();
			}



		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("Hiba tortent");
		}


	}

}
