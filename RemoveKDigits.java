import java.util.Stack;

class RemoveKDigits
{
    public String removeKdigits(String num, int k)
    {
        Stack<Character> stack = new Stack<>();
        for(int i =0; i< num.length(); i++)
        {
            char ch = num.charAt(i);
            //remove from the left
            while(!stack.isEmpty() && k>0 && stack.peek() > ch)
            {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }    

            // convert stack to StringBuilder
            StringBuilder sb = new StringBuilder();

            while(!stack.isEmpty())   
            {
                if(k>0)              // for cases like 123456   , k =3
                {
                    stack.pop();
                    k--;
                }
                else
                {
                    sb.insert(0, stack.pop());   // printing stack in reverse
                }
            }

                // Removing the leading zeros
                while(sb.length()>0 && sb.charAt(0) == '0')
                {
                    sb.deleteCharAt(0);
                }

                if(sb.length() == 0)
                {
                    return "0";
                }

                return sb.toString();
    }

    public static void main(String[] args)
    {
        RemoveKDigits obj = new RemoveKDigits();
        String num = "1432219";
        int k = 3;
        String result = obj.removeKdigits(num, k);
        System.out.println("Result after removing " + k + " digits: " + result); // Output: "1219"
    }
}