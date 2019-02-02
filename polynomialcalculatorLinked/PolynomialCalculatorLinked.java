package polynomialcalculatorlinked;

/**
 *
 * @author Dim
 */
public class PolynomialCalculatorLinked {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial(4, 3);
        Polynomial p2 = new Polynomial(3, 2);
        Polynomial p3 = new Polynomial(1, 2);
        Polynomial p4 = new Polynomial(2, 1);
        Polynomial p = p1.add(p2).add(p3).add(p4);
        System.out.println(p);
    }
    
}
