import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TravelingSalesman {
    private static int ROW;
    private static int COL;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while(null != (line = br.readLine())) {
            StringTokenizer str = new StringTokenizer(line);
            if(!str.hasMoreElements())
                break;
            int row = Integer.parseInt(str.nextToken());
            int col = Integer.parseInt(str.nextToken());
            ROW = row;
            COL = col;
            int[][] table = new int[row][col];
            int[][] minPath = new int[ROW][COL];
            char[][] cost = new char[ROW][COL];
            if(!str.hasMoreElements()) {
                line = br.readLine();
                str = new StringTokenizer(line);
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    table[i][j] = Integer.parseInt(str.nextToken());
                    minPath[i][j] = 0;
                    cost[i][j] = 0;
                }
                if(!str.hasMoreElements() && i != row - 1){
                    line = br.readLine();
                    str = new StringTokenizer(line);
                }
            }
            int min1 = Integer.MAX_VALUE, min2 = 0, next, counter = 0;
            for (int i = 0; i < row; i++) {
                next = min(i, 0, table, minPath, cost);
                if (counter++ == 0) {
                    min1 = next;
                    min2 = i;
                }
                else if (next < min1) {
                    min1 = next;
                    min2 = i;
                }
            }
            for(int y = 0; y < COL - 1; y++) {
                System.out.print((min2 + 1) + " ");
                min2 = minPath[min2++][y];
            }
            System.out.println(++min2);
            System.out.println(min1);
        }
    }

    private static int min(int row, int col, int[][] table, int[][] minPath, char[][] cost) {
        if(col == COL - 1) return table[row][col];
        if(cost[row][col] != 0) return table[row][col];
        cost[row][col] = 1;

        int t1 = (row - 1 + ROW) % ROW;
        int t2 = (row + 1) % ROW;

        int x = min(t1, col + 1, table, minPath, cost);
        int y = min(row, col + 1, table, minPath, cost);
        int z = min(t2, col + 1, table, minPath, cost);

        int min = t1;
        if(x > y || (x == y && min > row)){
            x = y;
            min = row;
        }
        if(x > z || (x == z && min > t2)){
            x = z;
            min = t2;
        }
        table[row][col] += x;
        minPath[row][col] = min;
        return table[row][col];
    }
}
