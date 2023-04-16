package triangle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Triangle {
    private int a;
    private int b;
    private int c;
    private Colour colour;

    public Triangle(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
        colour = Colour.White;
    }

    private void checkSidesArePositive() {
        if(a <= 0|| b <= 0|| c <= 0) {
            throw new IllegalArgumentException("Triangle is invalid: sides must be positive");
        }
    }

    private void checkValidTriangle() {
        if(a >= b + c || b >= a + c || c >= b + a) {
            throw new IllegalArgumentException("Triangle is invalid: one side greater than sum of another sides");
        }
    }

    public int countPerimeter() {
        checkSidesArePositive();
        checkValidTriangle();
        return a + b + c;
    }

    public double countArea(){
        checkSidesArePositive();
        checkValidTriangle();
        double p = countPerimeter()/2.0;
        return Math.round(Math.sqrt(p*Math.abs(p-a)*Math.abs(p-b)*Math.abs(p-c))*1000.0)/1000.0;
    }

    public void paint(Colour colour) {
        if(this.colour == colour) {
            throw new IllegalArgumentException("New colour must not be equal to old colour");
        }
        this.colour = colour;
    }

    public void paint(String colour) {
        paint(Colour.valueOf(colour));
    }

    public Triangle createSimilarTriangle(int coef) {
        return new Triangle(a * coef, b * coef, c * coef);
    }
}