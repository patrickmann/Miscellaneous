/**
 * Given a 2-D nxn array of characters where 0 marks water and X marks land,
 * count the number of islands (diagonals do not connect land).
 */
public class Islands {
    public static int countIslands(char[][] map) {
        if (map == null)
            return 0;
        int n = map.length;
        if (n == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (map[i].length != n)
                return -1;
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'X') {
                    count++;
                    if (!markVisited(map, i, j))
                        return -1;
                } else if (map[i][j] != '0' && map[i][j] != 'V')
                    return -1;
            }
        }
        return count;
    }

    static boolean markVisited(char[][] map, int i, int j) {
        int n = map.length;
        if (map[i][j] == 'X')
            map[i][j] = 'V';
        else if (map[i][j] != '0' && map[i][j] != 'V')
            return false;
        if (i < (n - 1) && map[i + 1][j] == 'X')
            markVisited(map, i + 1, j);
        if (i > 0 && map[i - 1][j] == 'X')
            markVisited(map, i - 1, j);
        if (j < (n - 1) && map[i][j + 1] == 'X')
            markVisited(map, i, j + 1);
        if (j > 0 && map[i][j - 1] == 'X')
            markVisited(map, i, j - 1);
        return true;
    }


    static void testCountIslands(char[][] map, int expected) {
        if (countIslands(map) != expected)
            System.out.println("Fail");
        else
            System.out.println("Pass");
    }
}