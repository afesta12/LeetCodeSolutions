import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    /**
     * Given an integer numRows, return the first numRows of Pascal's triangle.
     *
     * In Pascal's triangle, each number is the sum of the two numbers directly above it.
     *
     * @param numRows the number of rows
     * @return the triangle
     */
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        // Iterate over numRows
        for(int i = 0; i < numRows; i++) {

            // Initialize new List
            List<Integer> row = new ArrayList<>();

            for(int j = 0; j <= i; j++) {

                /*
                Check for sides of triangle, only add numbers above if current index is not on the edge of
                the triangle
                 */
                if(j >= 1 && j < i) {

                    int temp = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                    row.add(temp);

                } else row.add(1);

            }

            result.add(row);
        }

        return result;
    }
}
