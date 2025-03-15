public class Main {
    public static void main(String[] args) {
        // Vérifie si un fichier est fourni en argument
        if (args.length < 1) {
            System.out.println("Usage: java Main <grille.txt>");
            return;
        }

        try {
            // Charger la grille de Sudoku
            SudokuGrid sudoku = new SudokuGrid(args[0]);
            
            // Afficher la grille initiale
            System.out.println("Grille de départ:");
            sudoku.displayGrid();

            // Résoudre le Sudoku
            SudokuSolver solver = new SudokuSolver(sudoku.getGrid());
            if (solver.solve()) {
                System.out.println("\nGrille résolue :");
                sudoku.displayGrid();

                // 🎉 AFFICHAGE SPÉCIAL APRÈS RÉSOLUTION 🎉
                System.out.println("\n🔥🔥🔥 ISMAEL THE GOAT 🔥🔥🔥");
                System.out.println("################################");
                System.out.println("#                              #");
                System.out.println("#   🎯   ISMAEL THE GOAT   🎯   #");
                System.out.println("#                              #");
                System.out.println("################################\n");

                 // Affichage de la grille avec "ISMAEL THE GOAT" et une tête souriante
                 String[] smiley = {
                    "       *****        ",
                    "     *       *      ",
                    "    *  O   O  *     ",
                    "    *    ^    *     ",
                    "     *  ---  *      ",
                    "       *****        "
                };

                int smileyRow = 0;
                for (int i = 0; i < 9; i++) {
                    if (i % 3 == 0) System.out.println("+-------+-------+-------+");
                    for (int j = 0; j < 9; j++) {
                        if (j % 3 == 0) System.out.print("| ");
                        System.out.print(sudoku.getGrid()[i][j] + " ");
                    }
                    System.out.print("|   ");
                    if (smileyRow < smiley.length) {
                        System.out.println(smiley[smileyRow]);
                        smileyRow++;
                    } else {
                        System.out.println("   ISMAEL THE GOAT");
                    }
                }
            } else {
                System.out.println("Impossible de résoudre cette grille !");
            }
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}
