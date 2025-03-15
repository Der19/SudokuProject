public class SudokuSolver {
    private int[][] grid;

    public SudokuSolver(int[][] grid) {
        this.grid = grid;
    }

    // Fonction principale pour résoudre la grille
    public boolean solve() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (grid[row][col] == 0) { // Case vide
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(row, col, num)) {
                            grid[row][col] = num;
                            if (solve()) return true; // Récursion
                            grid[row][col] = 0; // Backtracking
                        }
                    }
                    return false; // Aucune solution possible
                }
            }
        }
        return true; // Sudoku résolu
    }

    // Vérifie si un nombre peut être placé à une position donnée
    private boolean isValid(int row, int col, int num) {
        // Vérifie la ligne et la colonne
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == num || grid[i][col] == num) return false;
        }

        // Vérifie le sous-bloc 3x3
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[startRow + i][startCol + j] == num) return false;
            }
        }
        return true;
    }
}
