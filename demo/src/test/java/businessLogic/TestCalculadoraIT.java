package businessLogic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import businessLogic.Calculadora;

import static org.junit.Assert.*;

public class TestCalculadoraIT {

    public TestCalculadoraIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class Calculadora.
     */
    @Test
    public void testAdd() {
        // System.out.println("add");
        float a = 3F;
        float b = 5F;
        float expResult = 8F;
        float result = Calculadora.add(a, b);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of substract method, of class Calculadora.
     */
    @Test
    public void testSubstract() {
        // System.out.println("substract");
        float a = 10F;
        float b = 5F;
        float expResult = 5F;
        float result = Calculadora.substract(a, b);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of multiply method, of class Calculadora.
     */
    @Test
    public void testMultiply() {
        // System.out.println("multiply");
        float a = 7F;
        float b = 2F;
        float expResult = 14F;
        float result = Calculadora.multiply(a, b);
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of div method, of class Calculadora.
     */
    @Test
    public void testDiv() {
        // System.out.println("div");
        float a = 20F;
        float b = 5F;
        float expResult = 4F;
        float result = Calculadora.div(a, b);
        assertEquals(expResult, result, 0.0);
    }

    // Test mínimo - 1
    @Test
    public void testMin() {
        float a = (float) -9223372036854775808.0;
        float b = 1;
        float c = Calculadora.substract(a, b);
        assertEquals(c, (float) -9223372036854775809.0, 0);
    }

    // Test maximo + 1
    @Test
    public void testMax() {
        float a = (float) 9223372036854775807.0;
        float b = 1;
        float c = Calculadora.add(a, b);
        assertEquals(c, (float) 9223372036854775808.0, 0);
    }

    // Test doble de un numero
    @Test
    public void testDoble() {
        float a = (float) 9223372036854775807.0;
        float b = 2;
        float c = Calculadora.substract(Calculadora.multiply(a, b), a);
        assertEquals(c, a, 0);
    }

    // Test maximo - minimo
    @Test
    public void testMaxMMin() {
        float a = (float) 9223372036854775807.0;
        float b = (float) -9223372036854775808.0;
        float c = Calculadora.substract(a, b);
        float d = (float) 18446744073709551615.0;
        assertEquals(c, d, 0);
    }

    // Test ley de signos
    @Test
    public void testSignos() {
        float a = -3;
        float b = -2;
        float c = Calculadora.add(a, b);
        assertEquals(c, -5, 0);
    }

    // Test valor-valor
    @Test
    public void testCero() {
        float a = 2;
        float b = 2;
        float c = Calculadora.substract(a, b);
        assertEquals(c, 0, 0);
    }

    // Test valor+1
    @Test
    public void testWhile() {
        float a = 0;
        float b = 1;
        while (a < 1000)
            a = Calculadora.add(a, b);
        assertEquals(a, 1000, 0);
    }

    // Test valor+(-valor)
    @Test
    public void testSumaInversos() {
        float a = 1;
        float b = Calculadora.signo(String.valueOf(a));
        float c = Calculadora.add(a, b);
        assertEquals(c, 0, 0);
    }

    // Test división entre cero
    @Test
    public void testDivCero() {
        float a = 1;
        float b = 0;
        float c = Calculadora.div(a, b);
        assertTrue(Double.isInfinite(c));
    }

    // Test coma
    @Test
    public void testComa() {
        float a = (float) 1.0;
        int b = 1;
        float c = Calculadora.coma(String.valueOf(a));
        assertEquals(c, b, 0);
    }

    // Test coma a un valor con coma
    @Test
    public void testComaComa() {
        float a = (float) 1.83;
        float b = (float) 1.83;
        float c = Calculadora.coma(String.valueOf(a));
        assertEquals(c, b, 0);
    }

    // Test back
    @Test
    public void testBack() {
        int a = 111;
        String c = Calculadora.back(String.valueOf(a));
        assertEquals(c, "11");
    }

    // Test back decimal
    @Test
    public void testBackDec() {
        float a = (float) 11.02;
        String c = Calculadora.back(String.valueOf(a));
        assertEquals(c, "11.0");
    }

    // Test back con suma
    @Test
    public void testBackSuma() {
        float a = (float) 11.2;
        float c = Calculadora.add(Float.parseFloat(Calculadora.back(String.valueOf(a))), (float) 0.2);
        assertEquals(c, 11.2, 0.2);
    }

    // Test factorial de decimal
    @Test
    public void testFactoDecimal() {
        float a = (float) 11.2;
        float c = Calculadora.nFact(a);
        assertEquals(c, 0, 0);
    }

    // Test signo basico
    @Test
    public void testSign() {
        float a = (float) 11;
        float c = Calculadora.signo(String.valueOf(a));
        assertEquals(c, Calculadora.multiply(-1, a), 0);
    }

    // Test signo numero par de veces
    @Test
    public void testSigno() {
        float a = (float) 11;
        float c = a;
        for (int i = 0; i < 100; i++)
            c = Calculadora.signo(String.valueOf(c));
        assertEquals(c, a, 0);
    }

    // Test signo numero impar de veces
    @Test
    public void testSigno2() {
        float a = (float) 11;
        float c = a;
        for (int i = 1; i < 100; i++)
            c = Calculadora.signo(String.valueOf(c));
        assertEquals(c, Calculadora.multiply(-1, a), 0);
    }

    // Test mod de numeros signo inverso
    @Test
    public void testModSigno() {
        float a = (float) 11;
        assertEquals(0, Calculadora.mod(Calculadora.signo(String.valueOf(a)), a), 0);
    }

    // Test mod de numeros signo inverso
    @Test
    public void testIntegridad() {
        int a = 11;
        float b = (float) 1.0;
        assertEquals(a, Calculadora.multiply(a, b), 0);
    }

    // Test log de 1
    @Test
    public void testLog1() {
        int a = 1;
        assertEquals(Calculadora.substract(a, a), Calculadora.log(a), 0);
    }

    // Test log de 1
    @Test
    public void testSignoConDiv() {
        int a = 10;
        int b = -1;
        assertEquals(a, Calculadora.signo(String.valueOf(Calculadora.div(a, b))), 0);
    }

    // Test facto de 0=facto 1
    @Test
    public void testFacto0y1() {
        int a = 0;
        int b = 1;
        assertEquals(Calculadora.nFact(a), Calculadora.nFact(b), 0);
    }

    // Test mod normal vs inverso
    @Test
    public void testModNVSI() {
        int a = 10;
        int b = 2;
        assertEquals(Calculadora.mod(a,b), Calculadora.mod(Calculadora.signo(String.valueOf(a)), b), 0);
    }

    // Test 1x10

    @Test
    public void testTenPow() {
        float a = 1;
        float expResult = 10;
        float result = Calculadora.tenPow(a);
        assertEquals(expResult, result, 0);
    }

    // Test -1x10
    @Test
    public void testMinusTenPow() {
        float a = -1;
        float expResult = -10;
        float result = Calculadora.tenPow(a);
        assertEquals(expResult, result, 0);
    }

    // Test mod
    @Test
    public void testMod() {
        float a = (float) 10.0;
        float b = (float) 3.0;
        float expResult = (float) 1.0;
        float result = Calculadora.mod(a, b);
        assertEquals(expResult, result, 0);
    }

    // Test mod even
    // Test mod
    @Test
    public void testModEven() {
        float a = (float) 10.0;
        float b = (float) 2.0;
        float expResult = (float) 0.0;
        float result = Calculadora.mod(a, b);
        assertEquals(expResult, result, 0);
    }

    // Test mod odd
    @Test
    public void testModOdd() {
        float a = (float) 11.0;
        float b = (float) 2.0;
        float expResult = (float) 1.0;
        float result = Calculadora.mod(a, b);
        assertEquals(expResult, result, 0);
    }

    // Test sqrt
    @Test
    public void testSqrt() {
        float a = (float) 4.0;
        float expResult = (float) 2.0;
        float result = Calculadora.sqrt(a);
        assertEquals(expResult, result, 0);
    }

    // Test sqrt big number
    @Test
    public void testSqrtBigNumber() {
        float a = (float) 6561;
        float expResult = (float) 81.0;
        float result = Calculadora.sqrt(a);
        assertEquals(expResult, result, 0);
    }

    // Test sqrt negative number
    @Test
    public void testSqrtNegativeNumber() {
        float a = (float) -4.0;
        float result = Calculadora.sqrt(a);
        assertTrue(Float.isNaN(result));
    }

}
