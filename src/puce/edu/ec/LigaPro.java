package puce.edu.ec;

public class LigaPro {
    public static void main(String[] args) {
        /**
         * 0 = LDU
         * 1 = BSC
         * 2 = DQuito
         */

        String[] equipos = {"LDU", "BSC", "DQuito"};
        int totalEquipos = equipos.length;

        // Matriz de resultados (1 si jugaron, 0 si no)
        int[][] partidosJugados = new int[totalEquipos][totalEquipos];

        /* Definimos algunos enfrentamientos y resultados simulados */
        // LDU (0) vs BSC (1): LDU gana
        partidosJugados[0][1] = 3; // Goles o puntos directos de LDU contra BSC
        partidosJugados[1][0] = 0; // BSC contra LDU

        // LDU (0) vs DQuito (2): Empate
        partidosJugados[0][2] = 1;
        partidosJugados[2][0] = 1;

        // BSC (1) vs DQuito (2): BSC gana
        partidosJugados[1][2] = 3;
        partidosJugados[2][1] = 0;

        // Arreglos para la tabla de posiciones: [Puntos, Partidos Jugados, Ganados, Perdidos, Empatados]
        int[] puntos = new int[totalEquipos];
        int[] jugados = new int[totalEquipos];
        int[] ganados = new int[totalEquipos];
        int[] perdidos = new int[totalEquipos];
        int[] empatados = new int[totalEquipos];

        // Procesar la lógica del torneo recorriendo la matriz
        for (int i = 0; i < totalEquipos; i++) {
            for (int j = 0; j < totalEquipos; j++) {
                if (i != j && partidosJugados[i][j] > 0) {
                    jugados[i]++;
                    if (partidosJugados[i][j] == 3) {
                        ganados[i]++;
                        puntos[i] += 3;
                    } else if (partidosJugados[i][j] == 1) {
                        empatados[i]++;
                        puntos[i] += 1;
                    } else {
                        perdidos[i]++;
                    }
                }
            }
        }

        // Mostrar la Tabla de Posiciones
        System.out.println("=========================================");
        System.out.println("          TABLA DE POSICIONES LIGAPRO    ");
        System.out.println("=========================================");
        System.out.println("Equipo\tPJ\tPG\tPE\tPP\tPTS");
        System.out.println("-----------------------------------------");

        for (int i = 0; i < totalEquipos; i++) {
            System.out.println(equipos[i] + "\t" +
                    jugados[i] + "\t" +
                    ganados[i] + "\t" +
                    empatados[i] + "\t" +
                    perdidos[i] + "\t" +
                    puntos[i]);
        }
        System.out.println("=========================================");
    }
}
