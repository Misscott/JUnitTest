package shopping;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void testCreation() {
        Product product = new Product("001", "Phone", "Smartphone", 599.99);
        assertEquals("001", product.getCode());
        assertEquals("Phone", product.getTitle());
        assertEquals("Smartphone", product.getDescription());
        assertEquals(599.99, product.getPrice());
    }

    @Test
    public void testZeroPrice() {
        Product product = new Product("003", "Book", "Novel", 0);
        assertEquals(0, product.getPrice());
    }

    @Test
    void testNegativePrice() {
        Product product = new Product("001", "Product","Test Product", -10.0);
        assertTrue(product.getPrice() > -1, "El precio nunca puede ser negativo");
    }

    @Test
    void testNullAttributes() {
        Product product = new Product(null, null, null, 10.0);
        assertNull(product.getCode(), "El código no debe ser nulo");
        assertNull(product.getTitle(), "El titulo no debe ser nulo");
        assertNull(product.getDescription(), "La descripción no debe ser nula");
    }

    @Test
    public void testBoundaryValues() {
        Product minValueProduct = new Product("008", "Cheap Item", "Very cheap item", Double.MIN_VALUE);
        Product maxValueProduct = new Product("009", "Expensive Item", "Very expensive item", Double.MAX_VALUE);

        assertEquals(Double.MIN_VALUE, minValueProduct.getPrice());
        assertEquals(Double.MAX_VALUE, maxValueProduct.getPrice());
    }
}
