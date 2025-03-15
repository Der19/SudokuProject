public class Main {
    public static void main(String[] args) {
        // Vérifie si un fichier est fourni en argument
        if (args.length < 1) {
            System.out.println("Usage: java Main <nom_du_fichier>");
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
            } else {
                System.out.println("Impossible de résoudre cette grille !");
            }
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}
