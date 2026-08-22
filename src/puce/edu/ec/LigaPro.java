package puce.edu.ec;

public class LigaPro {
    public static void main(String[] args) {
        /**
         * 0 = LDU
         * 1 = BSC
         * 2 = DQuito
         */

        // Matriz para registrar los enfrentamientos (4 equipos máximo)
        int[][] partidosJugados = new int[3][3];

        /* LDU (0) VS BSC (1) */
        partidosJugados[0][1] = 1;
        partidosJugados[1][0] = 1;

        /* LDU (0) VS DQuito (2) */
        partidosJugados[2][0] = 1;
        partidosJugados[0][2] = 1;

        /* BSC (1) VS DQuito (2) */
        partidosJugados[1][2] = 1;
        partidosJugados[2][1] = 1;

        // Arreglo con los nombres exactos de los 3 equipos
        String[] equipos = {"LDU", "BSC", "DQuito"};

        // Imprimir cabecera de equipos
        System.out.println("=== EQUIPOS REGISTRADOS ===");
        for (int i = 0; i < equipos.length; i++) {
            System.out.print(equipos[i] + "\t");
        }
        System.out.println("\n");

        // Opcional: Mostrar la matriz de enfrentamientos de forma visual
        System.       out.println("=== MATRIZ DE PARTIDOS ===" );
        System.out.println("\tLDU\tBSC\tDQuito");
        for (int i = 0; i < partidosJugados.length; i++) {
            System.out.print(equipos[i] + "\t");
            for (int j = 0; j < partidosJugados[i].length; j++) {
                System.out.print(partidosJugados[i][j] + "\t");
            }
            System.out.println();
        }
    }
}


