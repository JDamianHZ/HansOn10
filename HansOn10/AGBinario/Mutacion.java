import java.util.Random;

public class Mutacion {
    static Random random = new Random();

    public static void Mutar() {
        // Obtener el cromosoma resultante del crossover
        String cromosomaResultante = CrossOver.Hijo.get(0);

        // Seleccionar un carácter aleatorio para mutar
        int caracterCambia = random.nextInt(10);
        char seleccionado = cromosomaResultante.charAt(caracterCambia);

        // Cambiar el carácter seleccionado
        char nuevoCaracter = (seleccionado == '0') ? '1' : '0';

        // Crear una copia del cromosoma para modificar
        StringBuilder cromosomaMutado = new StringBuilder(cromosomaResultante);

        // Cambiar el carácter en la posición caracterCambia por nuevoCaracter
        cromosomaMutado.setCharAt(caracterCambia, nuevoCaracter);

        // Imprimir el cromosoma modificado
        System.out.println("El que cambiara es: " + (caracterCambia + 1));
        System.out.println("Cromosoma Modificado: " + cromosomaMutado.toString());
        System.out.println("\n el que queda es: "+ cromosomaMutado);
        Generar.NuevaGen.clear();
        Generar.NuevaGen.add(cromosomaMutado.toString());



    }
}
