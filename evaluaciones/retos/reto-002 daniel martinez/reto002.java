import java.util.Scanner;

public class reto002 {

    static String[] archivo = new String[10];
    static int lineaActiva = 1;

    public static void main(String[] args) {

        inicializarArchivo();
        imprimirArchivo();

        Scanner scanner = new Scanner(System.in);
        char opcion;

        do {
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextLine().toUpperCase().charAt(0);

            switch (opcion) {
                case 'L':
                    definirLineaActiva(scanner);
                    break;
                case 'E':
                    editarLineaActiva(scanner);
                    break;
                case 'B':
                    borrarLineaActiva();
                    break;
                case 'I':
                    System.out.println("Intercambiar líneas (pendiente)");
                    break;
                case 'D':
                    System.out.println("Deshacer (pendiente)");
                    break;
                case 'S':
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

            if (opcion != 'S') {
                imprimirArchivo();
            }

        } while (opcion != 'S');

        scanner.close();
    }

    // ---------- MÉTODOS ADAPTADOS ----------

    public static void inicializarArchivo() {
        archivo[0] = "Bienvenidos al editor EDLIN";
        archivo[1] = "Utilice el menu inferior para editar el texto";
        for (int i = 2; i < archivo.length; i++) {
            archivo[i] = "";
        }
    }

    public static void imprimirArchivo() {
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < archivo.length; i++) {
            String marca = (i == lineaActiva) ? "*" : " ";
            System.out.printf("%d:%s| %s%n", i, marca, archivo[i]);
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [D]eshacer | [S]alir");
    }

    public static void definirLineaActiva(Scanner scanner) {
        System.out.print("Número de línea (0-9): ");
        int linea = Integer.parseInt(scanner.nextLine());

        if (linea >= 0 && linea < archivo.length) {
            lineaActiva = linea;
        } else {
            System.out.println("Línea fuera de rango.");
        }
    }

    public static void editarLineaActiva(Scanner scanner) {
        System.out.print("Nuevo contenido: ");
        archivo[lineaActiva] = scanner.nextLine();
    }

    public static void borrarLineaActiva() {
        archivo[lineaActiva] = "";
    }
}
