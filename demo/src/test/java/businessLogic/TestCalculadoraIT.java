package businessLogic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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

    //Prueba coma
    @Test
    public void testComa() {
        float a = 1;
        int b = 1;
        float c = Calculadora.coma(String.valueOf(a));
        assertEquals(c, b, 0);
    }

    //Prueba pow10
    @Test
    public void testTenpow(){
        float a=1;
        float expResult = 10;
        float result = Calculadora.tenPow(a);
        assertEquals(expResult,result,0);
    }

}
