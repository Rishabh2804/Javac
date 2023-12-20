package min_cost_path;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int[][] take2DInput() throws IOException {
        String[] strRowsCols = br.readLine().trim().split("\\s");
        int mRows = Integer.parseInt(strRowsCols[0]);
        int nCols = Integer.parseInt(strRowsCols[1]);

        if (mRows == 0) {
            return new int[0][0];
        }


        int[][] mat = new int[mRows][nCols];

        for (int row = 0; row < mRows; row++) {
            String[] strNums; 
            strNums = br.readLine().trim().split("\\s");
            
            for (int col = 0; col < nCols; col++) {
                mat[row][col] = Integer.parseInt(strNums[col]);
            }
        }

        return mat;
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        int[][] mat = take2DInput();
        System.out.println(Solution.minCostPath(mat));
    }
}