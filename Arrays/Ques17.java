package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Ques17 {

}

class Solution {

    public List spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int colbeg = 0;
        int colend = matrix[0].length - 1;
        int rowbeg = 0;
        int rowend = matrix.length - 1;

        while (rowbeg <= rowend && colbeg <= colend) {
            for (int i = colbeg; i <= colend; i++) {
                list.add(matrix[rowbeg][i]);
            }
            rowbeg++;
            for (int i = rowbeg; i <= rowend; i++) {
                list.add(matrix[i][colend]);
            }
            colend--;

            if (rowbeg <= rowend) {
                for (int i = colend; i >= colbeg; i--) {
                    list.add(matrix[rowend][i]);
                }
                rowend--;
                if (colbeg <= colend) {
                    for (int i = rowend; i >= rowbeg; i--) {
                        list.add(matrix[i][colbeg]);
                    }
                    colbeg++;
                }
            }
        }
        return list;
    }
}
