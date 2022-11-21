import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class MaszynaTuringa {
    public Wczytanie dane;
    public Hashtable<String, Integer> mapa_ruchu_tasma = new Hashtable<>();
    public Hashtable<String, String> prawo_lewo_zostan = new Hashtable<>();



    public MaszynaTuringa() throws IOException {
        this.mapa_ruchu_tasma.put("r", 1);
        this.mapa_ruchu_tasma.put("l", -1);
        this.mapa_ruchu_tasma.put("s", 0);
        this.mapa_ruchu_tasma.put("r", 1);
        this.mapa_ruchu_tasma.put("l", -1);
        this.mapa_ruchu_tasma.put("s", 0);



        this.dane = new Wczytanie();

    }

    public static void main(String[] args) throws IOException {

    }

    public void program_glowny() {
        String slowo = this.dane.slowo;
        String stany = this.dane.stany;
        String stan_poczatkowy = this.dane.stan_początkowy;
        String stan_koncowy = this.dane.stan_koncowy;
        Hashtable instrukcja = this.dane.instrukcja;



        String[] tablica_stanow = stany.split(",");


        String stan = stan_poczatkowy;
        String[] tablica_znakow = slowo.split("");
        String stan_obecny = stan_poczatkowy;
        int pozycja = 0;
        Scanner sc = new Scanner(System.in);
        Instrukcja instrukcja_wew;
        String obecny_znak;
        String[] tablica_polecen;
        String polecenia;
        String akceptuj;
        while(!stan.equals(stan_koncowy)){
            obecny_znak = tablica_znakow[pozycja];//Tutaj jest głowica


            instrukcja_wew = (Instrukcja) instrukcja.get(stan); //instrukcje dla obecnego stanu
            System.out.println(obecny_znak);
            polecenia = instrukcja_wew.mapa_instrukcji.get(obecny_znak);//szczegółowe instrukcje dla danego kroku
            polecenia =  polecenia.replace(";", "");
            tablica_polecen = polecenia.split(",");
            System.out.println(polecenia.toString());

            System.out.println("Jesteśmy w stanie " + stan + " zamieniamy obecny znak: " + obecny_znak + " na "  + tablica_polecen[1] + " i przechodzimy w " + pozycja);
            akceptuj = sc.nextLine();
            stan = tablica_polecen[0];

            tablica_znakow[pozycja] = tablica_polecen[1];

            pozycja = pozycja + this.mapa_ruchu_tasma.get(tablica_polecen[2]);
        }

        for(String x:tablica_znakow){
            System.out.println(x);
        }

}}
