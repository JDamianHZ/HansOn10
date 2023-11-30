import java.util.ArrayList;
import java.util.Random;

public class CrossOver {
    public static ArrayList<String> Padre = Generar.PadreL;
    public static ArrayList<String> Madre = Generar.MadreL;

    static ArrayList<String> Hijo = new ArrayList<>();

    static Random random = new Random();


    public static void hacerCross(){
        Hijo.clear();
        int caracteresTomados = random.nextInt(9)+1;
        int caracteresRestantes = 10 - caracteresTomados;
        System.out.println("Caracteres Tomados: " + caracteresTomados + " | Restantes: " + caracteresRestantes);

        String datoPadre= Padre.get(0);
        String datoMadre= Madre.get(0);

        String primeraParte = datoPadre.substring(0, caracteresTomados);
        String segundaParte = datoMadre.substring(datoMadre.length() - caracteresRestantes);

        String hijo = primeraParte + segundaParte;
        System.out.println("Cromosoma crusado " + hijo);
        Hijo.add(hijo);
        Generar.NuevaGen.add(hijo);

    }


}