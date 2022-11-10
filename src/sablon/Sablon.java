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

			sc.close(); //scanner lezarasa | ez a sor elhanyagolhato nem kotelezo leirni 
			//Fontos ha le van zarva a scanner utanna nem lehet vele sorokat beolvasni!!

			//adatok helyes beolvasasanak ellenorzese kiiratassal
			for (int i = 0; i < hazak.length; i++) {
				hazak[i].kiir();
			}

			//2.feladat
			System.out.println("2.feladat");

			//ingatlanok megszamolasa
			//itt mivel tudjuk hogy csak ingatlanokat tarolunk a tombbe ezert arra kivancsi a feladat hogy hany adatsor talalhato a tombbe
			//erre van egy beepitett fuggveny a tombokhoz
			System.out.println("Ingatlanok szama: " + hazak.length); //a tomb.length mondja meg hany elem talalhato az adott tombbe

			//3.feldadat
			System.out.println("3.feladat");

			//itt arra kivancsi a feladat hogy egy valamibol hany darab van
			//ez a megszamlalas tetel (ha neten ra kene keresni)
			//itt ilyenkor vegig kell menni a tomb osszes elemen es egyesevel megvizsgalni az elemeket hogy megfelelnek e egy adott feltetelnek
			int darab = 0; //itt tarolom el a vizsgalat eredmenyet
			for (int i = 0; i < hazak.length; i++) { //hazak.length-ig kell menni mivel minden egyes elemet meg akarunk vizsgalni
				//if-el adjuk meg a feltetelt ami alapjan vizsgaljuk az adatot
				//itt most az akarom megszamolni hogy hany darab ingatlanhoz tartozik garazs
				if(hazak[i].garazs != 0){ //!= nem egyenlot jelenti
					//ebbe a reszbe irom hogy mi tortenik akkor ha teljesul a feltetel
					darab = darab + 1; //a darab valtozohoz hozza adok egyet
				}
			}

			//vizsgalat vegen kiirom az eredmenyt
			System.out.println(darab + " ingatlan van amihez tartozik garazs");


			//4.feladat
			System.out.println("4.feladat");

			//rendezes elott a tomb (csak szemleltetesnek amugy nem szukseges)
			for (int i = 0; i < hazak.length; i++) {
				hazak[i].kiir();
			}

			//adatok sorba rendezese
			//amit itt valtoztatni kell az a csere valtozo tipusa
			//a tomb neve amit rendezunk (hazak)
			//es az if-ben hogy mi alapjan rendezunk sorba pl nem a garazs alapjan hanem alapterulet
			//pl if(hazak[i].alapterulet > hazak[j].alapterulet)
			Hazak csere;
			for (int i = 0; i < hazak.length-1; i++) {
				for (int j = 0; j < hazak.length; j++) {
					if(hazak[i].garazs > hazak[j].garazs){
						csere = hazak[i];
						hazak[i] = hazak[j];
						hazak[j] = csere;
					}
				}
			}

			System.out.println("\nrendezes utan");
			//rendezes utan a tomb (csak szemleltetesnek amugy nem szukseges)
			for (int i = 0; i < hazak.length; i++) {
				hazak[i].kiir();
			}
			
			//5.feladat
			System.out.println("5.feladat");
			//maximum kivalasztas
			//tombben a legnagyobb ertek megkeresese
			//vegig kell menni az osszes elemen a tombbe
			int max = -1000;//ebbe fogjuk eltarolni a legnagyobb erteket | ide olyan erteket kell irni kezdesnek ami biztos kisebb ertek mint a tombbe a lehetseges legnagyobb elem
			int max_i = -1; //ebbe fogjuk eltarolni hanyadik helyen volt a tombbe a legnagyobb elem

			for (int i = 0; i < hazak.length; i++) {
				if(max<hazak[i].alapter){//megnezzuk hogy a max valtozo erteke kisebb mint az aktualis elem ha igaz akkor a maxba eltaroljuk a nagyobb erteket
					max = hazak[i].alapter;
					max_i = i; //eltaroljuk a max ertek helyet
				}
			}

			System.out.println("Max: " + max + " helye: " + max_i);


			//6.feladat
			System.out.println("6.feladat");
			//minimum kivalasztas
			//tombben a legkisebb ertek megkeresese
			//vegig kell menni az osszes elemen a tombbe
			int min = 1000;//ebbe fogjuk eltarolni a legnagyobb erteket | ide olyan erteket kell irni kezdesnek ami biztos nagyobb ertek mint a tombbe a lehetseges legkisebb elem
			int min_i = -1; //ebbe fogjuk eltarolni hanyadik helyen volt a tombbe a legnagyobb elem

			for (int i = 0; i < hazak.length; i++) {
				if(min>hazak[i].alapter){//megnezzuk hogy a max valtozo erteke kisebb mint az aktualis elem ha igaz akkor a maxba eltaroljuk a nagyobb erteket
					min = hazak[i].alapter;
					min_i = i; //eltaroljuk a max ertek helyet
				}
			}

			System.out.println("Min: " + min + " helye: " + min_i);


			//7.feladat
			System.out.println("7.feladat");
			//osszeszamlalas
			//egy valtozoba ossze adunk ertekeket egy feltetel alapjan
			int sum = 0; //valtozo amibe eltaroljuk az adatok osszeget
			int sum2 = 0;
			//vegig megyunk a tombbon
			for (int i = 0; i < hazak.length; i++) {
				sum = sum + hazak[i].alapter; //alapteruletek osszege

				//felteteles osszeszamolas
				//minden masodik haz alapteruletet adjuk ossze
				if(i % 2 == 0){
					sum2 = sum2 + hazak[i].alapter;
				}
			}

			System.out.println("Ossz alapter: " + sum);
			System.out.println("minden masodik haz alaptere: " + sum2);
		} catch (Exception e) {
			System.out.println("Hiba tortent");
		}
	}
}
