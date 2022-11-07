package sablon;

public class Hazak {
    //itt megadjuk az adatokat amiket az osztalyon belul fogunk tarolni
    //ezeket szinten megfogja mondani a feladat
    //a valtozok ele mindig legyen oda irva hogy public
    /*
     * a valtzok tipusat neked kell kitalalni de
     * szoveget String valtozoba tarolunk
     * egesz szamot int valtozoba tarolunk
     * tizedes szamot double valtozoba tarolunk
     */

    public String utcanev; //erteket nem adunk csak lezarjuk pontosvesszovel
    public int hazszam;
    public int alapter;
    public int garazs;

    //kontruktor
    //ezt hivjuk meg amikor beolvassuk az adatokat a fajlbol, hogy lementse az adatokat a fent levo valtozokba
    //a konstruktor neve mindig meg egyszik az osztalyeval pl: osztalynev Hazak konstruktor neve Hazak, osztalynev Ingatlan konstruktornev Ingatlan
    //ez ele is mindig oda kell irni a public szot
    //a zaroljelbe megkell adni a valtozok nevet amibe az adatok jonnek at
    //ebbol ugyan annyi van mint ahany valtozo lett irva fent az osztalyban
    public Hazak(String utcanev, int hazszam, int alapter, int garazs){
        this.utcanev = utcanev;
        this.hazszam = hazszam;
        this.alapter = alapter;
        this.garazs = garazs;
    }

    //nekem teszteles
    public void kiir(){
        System.out.println("utcanev: " + utcanev + " hazszam: " + hazszam + " alapter: " + alapter + " garazs: " + garazs);
    }
    
}
