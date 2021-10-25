package businessLogic;

public class Calculadora {
    
    public static float add(float a, float b)
    {
        return a+b;
    }
    
    public static float substract(float a, float b)
    {
        return a-b;
    }
    
    public static float multiply(float a, float b)
    {
        return a*b;
    }
    
    public static float div(float a, float b)
    {
        return a/b;
    }

    public static float mod(float a, float b)
    {
        return a%b;
    }

    public static float sqrt(float a)
    {
        return (float)Math.sqrt(a);
    }
    public static float signo(float a)
    {
        return -a;
    }
    public static float nfactorial(float a)
    {
        float factorial = 1;
        for(int i = 1; i <= a; i++)
        {
            factorial *= i;
        }
        return factorial;
    }

    public static float log(float a)
    {
        return (float)Math.log(a);
    }

    public static float tenPow(float a)
    {
        return (float)10 * a;
    }
}
