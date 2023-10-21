import java.util.Scanner;
        import java.util.Random;

public class TreasureHunt {
        

    public static void main(String[] args) {
        // Set up the game
        int gridSize = 5; 
        char[][] map = createMap(gridSize);
        int[] treasureLocation = placeTreasure(gridSize);
        boolean gameOver = false;

        // Game loop
        while (!gameOver) {
            printMap(map);

            char move = getUserMove();
            
            gameOver = movePlayer(map, treasureLocation, move);
        }

        System.out.println("Congratulations! You found the treasure!");
    }

    // Create an empty map
    private static char[][] createMap(int size) {
        char[][] map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = '-';
            }
        }
        return map;
    }

    // Place the treasure at a random location
    private static int[] placeTreasure(int size) {
        Random rand = new Random();
        int x = rand.nextInt(size);
        int y = rand.nextInt(size);
        return new int[]{x, y};
    }

    // Print the current state of the map
    private static void printMap(char[][] map) {
        System.out.println("Current Map:");
        for (char[] row : map) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    // Get user input for the next move
    private static char getUserMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your move (W/A/S/D): ");
        return scanner.next().charAt(0);
    }

    // Move the player and check if they found the treasure
    private static boolean movePlayer(char[][] map, int[] treasureLocation, char move) {
        int playerX = 0;
        int playerY = 0;

        // Find the current player location
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'M') {
                    playerX = i;
                    playerY = j;
                    map[i][j] = '-'; // Clear the current player position
                }
            }
        }

        // Move the player based on the user input
        switch (move) {
            case 'W' -> playerX = Math.max(0, playerX - 1);
            case 'A' -> playerY = Math.max(0, playerY - 1);
            case 'S' -> playerX = Math.min(map.length - 1, playerX + 1);
            case 'D' -> playerY = Math.min(map[0].length - 1, playerY + 1);
            default -> System.out.println("Invalid move. Please enter W/A/S/D.");
        }

        // Update the map with the new player position
        map[playerX][playerY] = 'M';

        // Check if the player found the treasure
        if (playerX == treasureLocation[0] && playerY == treasureLocation[1]) {
            printMap(map);
            return true; // Game over, treasure found
        }

        return false; // Game continues
    }
}
