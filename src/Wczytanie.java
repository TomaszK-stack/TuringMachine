import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Wczytanie {


    String opis;
    String stany;
    int dlugosc;
    String slowo;
    String stan_koncowy;
    String stan_początkowy;
    Hashtable instrukcja;
    public Wczytanie() throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Podaj stany oddzielone przecinkiem: ");
        this.stany = sc.nextLine();
        System.out.println("Podaj źródło do pliku");
        String zrodlo = sc.nextLine();



//        System.out.println("opis: ");
//        this.opis = sc.nextLine();
//
//        System.out.println("Długość słowa: ");
//        this.dlugosc = sc.nextInt();
//        System.out.println("słowo: ");
//        this.slowo = sc.nextLine();
//        System.out.println("stan końcowy: ");
//        this.stan_koncowy = sc.nextLine();
//        System.out.println("stan początkowy: ");
//        this.stan_początkowy = sc.nextLine();


        this.instrukcja = wczytanie_instrukcji(zrodlo);


    }

    private static Hashtable wczytanie_instrukcji(String zrodlo) throws IOException {
        File file = new File(zrodlo);
        Hashtable<String, String> instrukcja = new Hashtable<>();
        Hashtable<String, String> instrukcja_wew = new Hashtable<>();
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String st;
        String stan = null;
        ArrayList<String> pojedyncza_instr = new ArrayList<>();
        String joined;
        while (((st = br.readLine()) != null) || (stan != null)) {
            if (st == null) {
                stan = stan.trim();
                joined = String.join(",", pojedyncza_instr);
                instrukcja.put(stan, joined);
                pojedyncza_instr.removeAll(pojedyncza_instr);


                break;
            } else {
                if (st.contains(":")) {
                    if (stan != null) {
                        stan = stan.trim();
                        for(String x: pojedyncza_instr){

                        }

                        joined = String.join(",", pojedyncza_instr);
                        instrukcja.put(stan, joined);

                        pojedyncza_instr.removeAll(pojedyncza_instr);


                    }
                    stan = st.replace(":", "");


                } else {
                    pojedyncza_instr.add(st);

                }

            }
        }

        return instrukcja;

    }


}
