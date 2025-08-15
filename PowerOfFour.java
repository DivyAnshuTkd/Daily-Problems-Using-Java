class PowerOfFour
{
    public boolean isPowerOfFour(int n)
    {
        if(n>0 && (n & (n-1)) == 0 && (n & 0x55555555) != 0)
        {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        PowerOfFour pf = new PowerOfFour();
        int[] testCases = {1, 4, 16, 5, 8, 64, 0, -4};
        for(int n : testCases) {
            System.out.println(n + " is power of four: " + pf.isPowerOfFour(n));
        }
    }
}