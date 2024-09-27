public class gcd {
    
    static int gcd(int a, int b, Object newParam)
    {
        // Everything divides 0
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // Base case
        if (a == b)
            return a;

        return gcd(b,a % b, newParam);
    }

    
    public static void main(String[] args)
    {
        int a = 60, b = 98;
        System.out.println("GCD of " + a + " and " + b + " is " + gcd(a, b, null));
        
        System.out.println(b % a);
    }
}
