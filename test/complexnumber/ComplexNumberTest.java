package complexnumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComplexNumberTest {

    // Casos Normales

    @Test
    public void testCreation() {
        ComplexNumber c = new ComplexNumber(3, 4);
        assertEquals(3, c.getReal());
        assertEquals(4, c.getImaginary());
    }

    @Test
    public void testAddition() {
        ComplexNumber c1 = new ComplexNumber(3, 4);
        ComplexNumber c2 = new ComplexNumber(1, 2);
        ComplexNumber result = c1.add(c2);
        assertEquals(new ComplexNumber(4, 6), result);
    }

    @Test
    public void testMultiplication() {
        ComplexNumber c1 = new ComplexNumber(2, 3);
        ComplexNumber c2 = new ComplexNumber(4, 5);
        ComplexNumber result = c1.multiply(c2);
        assertEquals(new ComplexNumber(-7, 22), result);
    }

    @Test
    public void testEquality() {
        ComplexNumber c1 = new ComplexNumber(5, 6);
        ComplexNumber c2 = new ComplexNumber(5, 6);
        ComplexNumber c3 = new ComplexNumber(6, 5);
        assertEquals(c1, c2);
        assertNotEquals(c1, c3);
    }

    // Casos de Borde

    @Test
    public void testAdditionWithZero() {
        ComplexNumber c1 = new ComplexNumber(0, 0);
        ComplexNumber c2 = new ComplexNumber(3, 4);
        ComplexNumber result = c1.add(c2);
        assertEquals(new ComplexNumber(3, 4), result);
    }

    @Test
    public void testMultiplicationWithZero() {
        ComplexNumber c1 = new ComplexNumber(0, 0);
        ComplexNumber c2 = new ComplexNumber(3, 4);
        ComplexNumber result = c1.multiply(c2);
        assertEquals(new ComplexNumber(0, 0), result);
    }

    @Test
    public void testMultiplicationByOne() {
        ComplexNumber c1 = new ComplexNumber(1, 0);
        ComplexNumber c2 = new ComplexNumber(3, 4);
        ComplexNumber result = c1.multiply(c2);
        assertEquals(new ComplexNumber(3, 4), result);
    }

    @Test
    public void testAdditionWithSelf() {
        ComplexNumber c = new ComplexNumber(3, 4);
        ComplexNumber result = c.add(c);
        assertEquals(new ComplexNumber(6, 8), result);
    }

    @Test
    public void testMultiplicationWithSelf() {
        ComplexNumber c = new ComplexNumber(1, 1);
        ComplexNumber result = c.multiply(c);
        assertEquals(new ComplexNumber(0, 2), result);
    }

    // Casos de Error
    @Test
    public void testAdditionWithUninitializedComplexNumber() {
        ComplexNumber c1 = new ComplexNumber(3, 4);
        ComplexNumber c2 = null;
        try {
            c1.add(c2);
            fail("Expected NullPointerException was not thrown");
        } catch (NullPointerException e) {
            // Excepción esperada, la prueba pasa
        }
    }

    @Test
    public void testMultiplicationWithUninitializedComplexNumber() {
        ComplexNumber c1 = new ComplexNumber(3, 4);
        ComplexNumber c2 = null;
        try {
            c1.multiply(c2);
            fail("Expected NullPointerException was not thrown");
        } catch (NullPointerException e) {
            // Excepción esperada, la prueba pasa
        }
    }

    // Casos de Valores Extremos

    @Test
    public void testCreationWithLargeValues() {
        ComplexNumber c = new ComplexNumber(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, c.getReal());
        assertEquals(Integer.MAX_VALUE, c.getImaginary());
    }

    @Test
    public void testAdditionWithLargeValues() {
        ComplexNumber c1 = new ComplexNumber(Integer.MAX_VALUE, Integer.MAX_VALUE);
        ComplexNumber c2 = new ComplexNumber(1, 1);
        ComplexNumber result = c1.add(c2);
        // Verificamos si se produce desbordamiento
        assertEquals(new ComplexNumber(Integer.MIN_VALUE, Integer.MIN_VALUE), result);
    }

    @Test
    public void testMultiplicationWithLargeValues() {
        ComplexNumber c1 = new ComplexNumber(Integer.MAX_VALUE, 1);
        ComplexNumber c2 = new ComplexNumber(1, Integer.MAX_VALUE);
        ComplexNumber result = c1.multiply(c2);
        // Verificamos si se produce desbordamiento
        int expectedReal = Integer.MAX_VALUE * 1 - 1 * Integer.MAX_VALUE;
        int expectedImaginary = Integer.MAX_VALUE * Integer.MAX_VALUE + 1 * 1;
        // El resultado esperado puede causar desbordamiento en int
        assertEquals(new ComplexNumber(expectedReal, expectedImaginary), result);
    }

    @Test
    public void testCreationWithSmallValues() {
        ComplexNumber c = new ComplexNumber(Integer.MIN_VALUE, Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE, c.getReal());
        assertEquals(Integer.MIN_VALUE, c.getImaginary());
    }

    @Test
    public void testAdditionWithSmallValues() {
        ComplexNumber c1 = new ComplexNumber(Integer.MIN_VALUE, Integer.MIN_VALUE);
        ComplexNumber c2 = new ComplexNumber(-1, -1);
        ComplexNumber result = c1.add(c2);
        // Verificamos si se produce desbordamiento
        assertEquals(new ComplexNumber(Integer.MAX_VALUE, Integer.MAX_VALUE), result);
    }

    @Test
    public void testMultiplicationWithSmallValues() {
        ComplexNumber c1 = new ComplexNumber(Integer.MIN_VALUE, -1);
        ComplexNumber c2 = new ComplexNumber(-1, Integer.MIN_VALUE);
        ComplexNumber result = c1.multiply(c2);
        // Verificamos si se produce desbordamiento
        int expectedReal = Integer.MIN_VALUE * -1 - (-1) * Integer.MIN_VALUE;
        int expectedImaginary = Integer.MIN_VALUE * Integer.MIN_VALUE + (-1) * -1;
        // El resultado esperado puede causar desbordamiento en int
        assertEquals(new ComplexNumber(expectedReal, expectedImaginary), result);
    }
}