package triangle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleParametrizeTest {
    public static Stream<Arguments> triangles() {
        return Stream.of(Arguments.of(new Triangle(3, 4, 5), 12),
                Arguments.of(new Triangle(3, 4, 6), 13),
                Arguments.of(new Triangle(3, 3, 3), 9));
    }

    public static Stream<Arguments> invalidTriangles() {
        return Stream.of(Arguments.of(new Triangle(3, 4, 0), "Triangle is invalid: sides must be positive"),
                Arguments.of(new Triangle(3, 0, 3), "Triangle is invalid: sides must be positive"),
                Arguments.of(new Triangle(0, 4, 3), "Triangle is invalid: sides must be positive"),
                Arguments.of(new Triangle(3, 4, -3), "Triangle is invalid: sides must be positive"),
                Arguments.of(new Triangle(3, -4, 3), "Triangle is invalid: sides must be positive"),
                Arguments.of(new Triangle(-3, 4, 3), "Triangle is invalid: sides must be positive"),
                Arguments.of(new Triangle(3, 4, 9), "Triangle is invalid: one side greater than sum of another sides"),
                Arguments.of(new Triangle(3, 9, 3), "Triangle is invalid: one side greater than sum of another sides"),
                Arguments.of(new Triangle(9, 4, 3), "Triangle is invalid: one side greater than sum of another sides"));
    }

    @ParameterizedTest(name = "Периметр треугольника {0} должен быть равен {1}")
    @MethodSource("triangles")
    @DisplayName("Периметр египетского треугольника")
    public void countPerimeterEgyptTriangleSuccessfulTest(Triangle triangle, int expectedPerimeter) {
        int perimeter = triangle.countPerimeter();
        assertEquals(expectedPerimeter, perimeter);}

    @ParameterizedTest(name = "Периметр треугольника {0} должен быть равен {1}")
    @MethodSource("invalidTriangles")
    @DisplayName("Невалидный треугольник: не треугольник")
    public void countPerimeterInvalidTriangleTest(Triangle triangle, String expectedError) {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> triangle.countPerimeter());
        assertEquals(expectedError, illegalArgumentException.getMessage());
    }


}
