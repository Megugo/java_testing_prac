package triangle;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {
    @Test
    @DisplayName("Периметр египетского треугольника")
    @Disabled("Перенесен")
    public void countPerimeterEgyptTriangleSuccessfulTest() {
        Triangle triangle = new Triangle(3, 4, 5);
        int perimeter = triangle.countPerimeter();
        assertEquals(12, perimeter);}

    @Test
    @DisplayName("Периметр тупоугольного треугольника")
    @Disabled("Перенесен")
    public void countPerimeterTriangleWithAngleGreaterThan90SuccessfulTest() {
        Triangle triangle = new Triangle(3, 4, 6);
        int perimeter = triangle.countPerimeter();
        assertEquals(13, perimeter);}

    @Test
    @DisplayName("Периметр правильного треугольника")
    @Disabled("Перенесен")
    public void countPerimeterGreatTriangleSuccessfulTest() {
        Triangle triangle = new Triangle(3, 3, 3);
        int perimeter = triangle.countPerimeter();
        assertEquals(9, perimeter);}

    @Test
    @DisplayName("Невалидный треугольник: не треугольник")
    public void countPerimeterInvalidTriangleTest() {
        Triangle triangle = new Triangle(3, 3, 9);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> triangle.countPerimeter());
        assertEquals("Triangle is invalid: one side greater than sum of another sides", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Невалидный треугольник: нулевая сторона")
    public void countPerimeterInvalidTriangleZeroSideTest() {
        Triangle triangle = new Triangle(3, 3, 0);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> triangle.countPerimeter());
        assertEquals("Triangle is invalid: sides must be positive", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Невалидный треугольник: нулевая сторона")
    public void countPerimeterInvalidTriangleBellowZeroSideTest() {
        Triangle triangle = new Triangle(3, 3, -1);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> triangle.countPerimeter());
        assertEquals("Triangle is invalid: sides must be positive", illegalArgumentException.getMessage());
    }

}
