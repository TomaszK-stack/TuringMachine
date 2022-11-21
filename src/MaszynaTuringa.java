import java.io.IOException;
import java.util.Hashtable;

public class MaszynaTuringa {
    public Wczytanie dane;


    public MaszynaTuringa() throws IOException {
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

        for(String x: tablica_stanow){
            System.out.println(instrukcja.get(x));
        }


//
//        String[] tablica_znakow = slowo.split("");
//        String stan_obecny = stan_poczatkowy;
//        int pozycja = 0;





}}
