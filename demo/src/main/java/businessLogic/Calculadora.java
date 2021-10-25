package businessLogic;

public class Calculadora {

    public static float add(float a, float b) {
        return a + b;
    }

    public static float substract(float a, float b) {
        return a - b;
    }

    public static float multiply(float a, float b) {
        return a * b;
    }

    public static float div(float a, float b) {
        return a / b;
    }

    public static float mod(float a, float b) {
        return a % b;
    }

    public static float sqrt(float a) {
        return (float) Math.sqrt(a);
    }

    public static float signo(String a) {
        return Calculadora.multiply(-1, Float.parseFloat(a));
    }

    public static float nFact(float a) {
        if (String.valueOf(a).contains("."))
            return 0;
        float factorial = 1;
        for (int i = 1; i <= a; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static float log(float a) {
        return (float) Math.log(a);
    }

    public static float tenPow(float a) {
        return (float) 10 * a;
    }

    public static float coma(String value) {
        return Float.valueOf(value);
    }

    public static String back(String text) {
        String net=text.substring(0, text.length()-1);
        if (net.endsWith("."))
            net+="0";
        return net;
    }
}
