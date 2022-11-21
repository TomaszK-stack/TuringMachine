





import java.util.Hashtable;

public class Instrukcja {
    String instrukcja;
    Hashtable<String, String> mapa_instrukcji = new Hashtable<>();

    public Instrukcja(String instrukcja) {

        String[] temp_table = instrukcja.split("%");

        for(String x: temp_table){

            mapa_instrukcji.put(String.valueOf(x.charAt(0)), x.substring(1, x.length()));

        }


    }
}
