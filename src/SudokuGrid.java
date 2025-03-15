import java.io.*;

public class SudokuGrid {
    private int[][] grid;

    // Constructeur pour charger une grille depuis un fichier
    public SudokuGrid(String filename) throws IOException {
        grid = new int[9][9];
        loadGridFromFile(filename);
    }

    // Lecture du fichier et remplissage de la grille
    private void loadGridFromFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        for (int i = 0; i < 9; i++) {
            String[] line = br.readLine().trim().split(" ");
            if (line.length != 9) throw new IOException("Format de fichier incorrect.");
            for (int j = 0; j < 9; j++) {
                grid[i][j] = Integer.parseInt(line[j]);
            }
        }
        br.close();
    }

    // Affichage de la grille en console
    public void displayGrid() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) System.out.println("+-------+-------+-------+");
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0) System.out.print("| ");
                System.out.print(grid[i][j] == 0 ? ". " : grid[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("+-------+-------+-------+");
    }

    public int[][] getGrid() {
        return grid;
    }
}
