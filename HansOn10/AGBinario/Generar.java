import java.util.ArrayList;
import java.util.Random;

public class Generar {
    public static ArrayList<String> GenerarN = new ArrayList<>();
    public static ArrayList<String> RuletaA = new ArrayList<>();
    public static ArrayList<Integer> sumasUnos = new ArrayList<>();
    public static ArrayList<Double> divisiones = new ArrayList<>();
    static ArrayList<String> PadreL = new ArrayList<>();
    static ArrayList<String> MadreL = new ArrayList<>();
    static ArrayList<String> NuevaGen = new ArrayList<>();
    static ArrayList<Integer> conteoDeUnosPorFila = new ArrayList<>();


    public static int sumaUnos;
    public static Random random = new Random();

    static int h=0;
    static int generacionActual = 1;

    public static void main(String[] args) {
        generar();
        encontrarMaximo();
        LlenarNG();
        Repite();




    }

    public static void generar() {


        // Iterar 6 veces para generar 6 secuencias de 10 caracteres

        for (int i = 0; i < 6; i++) {
            // Crear una cadena para almacenar la secuencia de caracteres
            StringBuilder secuencia = new StringBuilder();

            // Generar 10 caracteres aleatorios (0 o 1) y añadirlos a la cadena
            for (int j = 0; j < 10; j++) {
                int aleatorio = random.nextInt(2);
                secuencia.append(aleatorio);
            }
            // Añadir la secuencia generada a la ArrayList
            GenerarN.add(secuencia.toString());

            // Contar la cantidad de unos en la fila
            sumaUnos = contarUnosEnFila(secuencia.toString());
            // Añadir la suma de unos a la ArrayList de sumas
            sumasUnos.add(sumaUnos);

            System.out.println("Secuencia " + (i + 1) + ": " + secuencia + " - Suma de unos: " + sumaUnos);


        }

        // Calcular y mostrar el fitness total
        int fitnessTotal = sumarUnos(sumasUnos);
        System.out.println("\nFitness total: " + fitnessTotal);

        // Calcular divisiones y almacenar en la ArrayList divisiones
        calcularDivisiones(fitnessTotal);




    }

    // Método para contar la cantidad de unos en una cadena
    private static int contarUnosEnFila(String fila) {
        int suma = 0;
        for (char caracter : fila.toCharArray()) {
            if (caracter == '1') {
                suma++;
            }
        }
        return suma;
    }

    // Método para sumar todos los valores de una ArrayList de enteros
    public static int sumarUnos(ArrayList<Integer> lista) {
        int suma = 0;
        for (int valor : lista) {
            suma += valor;
        }
        return suma;
    }

    // Método para calcular divisiones y almacenar en la ArrayList divisiones
    private static void calcularDivisiones(double divisor) {
        System.out.println("\nDivisiones:");
        for (int valor : sumasUnos) {
            double resultado = valor/divisor ;
            divisiones.add(resultado);
            System.out.println(resultado);
        }
    }

    private static int encontrarMaximo() {
        double maximo = Double.MIN_VALUE;
        int posicionMaximo = -1;

        for (int i = 0; i < divisiones.size(); i++) {
            if (divisiones.get(i) > maximo) {
                maximo = divisiones.get(i);
                posicionMaximo = i;
            }
        }



        System.out.println("\n Padre:  " + GenerarN.get(posicionMaximo));
        PadreL.add(GenerarN.get(posicionMaximo));

        return posicionMaximo;
    }
    public static int sumarUnosNG(ArrayList<String> lista) {
        int suma = 0;
        for (String secuencia : lista) {
            suma += contarUnosEnFila(secuencia);
        }
        return suma;
    }
    public static void RuletaMadre(){
        String madre = Ruleta();
        while (madre.equals((PadreL))) {
            System.out.println("Son iguales. Buscando otra madre...");
            madre = Ruleta();
        }

        System.out.println("Madre: " + madre);
        MadreL.add(madre);

    }
    public static String Ruleta(){
        int numero = random.nextInt(RuletaA.size());
        return  RuletaA.get(numero);

    }

    public static void Crossover() {
        int ProbabilidadCrosovver = random.nextInt(100);
        if (ProbabilidadCrosovver < 50) {
            System.out.println("Se realizo CrossOver: ");

            CrossOver.hacerCross();

            Mutar();


        } else {
            System.out.println("No se realizo Crossover");

            String PadreNG=PadreL.get(0);
            NuevaGen.add(PadreNG);
            System.out.println("\n el que quedo es: " + PadreNG);
        }
    }


    public static void Mutar(){
        int ProbabilidadMutar = random.nextInt(100);
        if (ProbabilidadMutar<50){
            System.out.println("Se realizo Mutacion: ");
            Mutacion.Mutar();


        }
        else {

            System.out.println("No muto");
        }
    }

    public static void LlenarNG(){
        for (int i=0; NuevaGen.size()<6;i++){
            MadreL.clear();
            Ruleta.ruleta();
            RuletaMadre();
            Crossover();

            generacionActual++;

        }

        Contar1Ng();
        System.out.println("\n nueva generacion: ");
        for (int i = 0; i < NuevaGen.size(); i++) {
            System.out.println(NuevaGen.get(i)+" Fitness: "+conteoDeUnosPorFila.get(i));
        }
    }

    public static void Contar1Ng() {
        // Recorrer cada fila
        for (String fila : NuevaGen) {
            // Contador para almacenar la cantidad de "1" en la fila actual
            int contadorDeUnos = 0;

            // Contar la cantidad de "1" en la fila actual
            for (int i = 0; i < fila.length(); i++) {
                if (fila.charAt(i) == '1') {
                    contadorDeUnos++;
                }
            }

            // Almacenar el conteo en la ArrayList correspondiente
            conteoDeUnosPorFila.add(contadorDeUnos);
        }
    }

    public static void Repite() {
        int numeroBuscar = 9;

        while (true) {
            boolean encontrado = false;

            for (int i = 0; i < conteoDeUnosPorFila.size(); i++) {
                if (conteoDeUnosPorFila.get(i) == numeroBuscar) {
                    System.out.println("Se encontro el numero " + numeroBuscar + " en la fila " + i +
                            " de la generacion " + generacionActual);
                    System.out.println("Cromosoma de 9: " + NuevaGen.get(i));
                    encontrado = true;
                    break;
                }
            }

            if (encontrado) {
                break; // Salir del bucle principal si se encontró el número
            } else {
                // Vaciar ArrayLists y volver a llenar
                NuevaGen.clear();
                conteoDeUnosPorFila.clear();
                LlenarNG();
            }
        }
    }











}
