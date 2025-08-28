class ValidParanthesis 
{
    public String removeOuterParentheses(String s) 
    {
        int start = 0;
        int end = 0; 
        int sum = 0;

        StringBuilder sb = new StringBuilder();

        while (end < s.length()) 
        {
            char ch = s.charAt(end);

            if (ch == '(') {
                sum++;
            } else if (ch == ')') {
                sum--;
            }

            // When sum == 0, we found one primitive part
            if (sum == 0) {
                sb.append(s.substring(start + 1, end)); // remove outer ()
                start = end + 1;
            }
            end++;
        }
        return sb.toString();
    }

    // main method for testing
    public static void main(String[] args) 
    {
        ValidParanthesis sol = new ValidParanthesis();

        String s1 = "(()())(())";
        String s2 = "(()())(())(()(()))";
        String s3 = "()()";

        System.out.println(sol.removeOuterParentheses(s1));  // ()()()
        System.out.println(sol.removeOuterParentheses(s2));  // ()()()()(())
        System.out.println(sol.removeOuterParentheses(s3));  // ""
    }
}
