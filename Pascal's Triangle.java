class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle =new ArrayList<>();
        for (int row=0;row<numRows;row++) {
            List<Integer> currentRow=new ArrayList<>();
            currentRow.add(1);  
            for (int j=1;j<row;j++) {
                int val=triangle.get(row-1).get(j-1)+triangle.get(row-1).get(j);
                currentRow.add(val);
            }
            if (row>0)currentRow.add(1);  
            triangle.add(currentRow);
        }
        return triangle;
    }
}

    