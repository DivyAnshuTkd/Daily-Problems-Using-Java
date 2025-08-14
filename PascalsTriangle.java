import java.util.ArrayList;
import java.util.List;
class PascalsTriangle
{
    public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i< numRows; i++)
        {
            List<Integer> singleList = new ArrayList<>();

            for(int j = 0; j<=i; j++)
            {
                if(j == 0 || j == i)
                {
                    singleList.add(1);
                }

                else
                {
                    int val = ans.get(i-1).get(j-1) + ans.get(i-1).get(j);
                    singleList.add(val);
                }
            }
            ans.add(singleList);
        }

        return ans;
    }
    public static void main(String[] args) {
        PascalsTriangle obj = new PascalsTriangle();
        int numRows = 5;
        List<List<Integer>> result = obj.generate(numRows);
        
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}
