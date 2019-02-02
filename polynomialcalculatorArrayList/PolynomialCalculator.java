package polynomialcalculator;

import java.util.ArrayList;
import javafx.collections.transformation.SortedList;

/**
 *
 * @author Dim
 */
public class PolynomialCalculator {
       static ArrayList<Polynomial> mainPolynomialFonction;
       
       static ArrayList<Polynomial> otherPolynomialFonction;

       static ArrayList<Polynomial> addedPolynomialFonction;
       
       static ArrayList<Polynomial> differentiatePolynomial;
       
       static ArrayList<Polynomial> integratePolynomial;
       
       static ArrayList<Polynomial> testPolynomialFonction;
       
       
    public static void main(String[] args) {
        
        mainPolynomialFonction = new ArrayList<>();
        //x^2 - 4x + 7
        Polynomial polyOne = new Polynomial(1.2, 2);
        Polynomial polyTwo = new Polynomial(-4.0, 1);
        Polynomial polyThree = new Polynomial(7.0, 0);
        
        mainPolynomialFonction.add(polyOne);
        mainPolynomialFonction.add(polyTwo);
        mainPolynomialFonction.add(polyThree);
        
        otherPolynomialFonction = new ArrayList<>();
        //6.8x^3 - 2x^2 + 5.2x - 9
        Polynomial poly1 = new Polynomial(6.8, 3);
        Polynomial poly2 = new Polynomial(-2.0, 2);
        Polynomial poly3 = new Polynomial(5.0, 1);
    //  Polynomial poly3 = new Polynomial(5.2, 1);  
        Polynomial poly4 = new Polynomial(-9.0, 0);
        
        otherPolynomialFonction.add(poly1);
        otherPolynomialFonction.add(poly2);
        otherPolynomialFonction.add(poly3);
        otherPolynomialFonction.add(poly4);
        
        testPolynomialFonction = new ArrayList<>();
        testPolynomialFonction.add(poly3);
        
        addedPolynomialFonction = new ArrayList<>();
        Polynomial polyTest = new Polynomial(0,0);
        
        addedPolynomialFonction = polyTest.add(mainPolynomialFonction, otherPolynomialFonction);
        
        System.out.print("Results for adding two Polynomial:");
        for ( Polynomial i : addedPolynomialFonction )
            {
                System.out.print( i );
            }
        System.out.print("\nDifferentiate Polynomial");
        
        differentiatePolynomial = polyTest.differentiate(addedPolynomialFonction);
        //differentiatePolynomial = polyTest.differentiate(testPolynomialFonction);
        
        for ( Polynomial i : differentiatePolynomial )
            {
                System.out.print( i );
            }
        
        System.out.print("\nIntegrate Polynomial");
        integratePolynomial = polyTest.integrate(addedPolynomialFonction);
    //    integratePolynomial = polyTest.integrate(testPolynomialFonction);
        
        for ( Polynomial i : integratePolynomial )
            {
                System.out.print( i );
            }
        System.out.println("");
        
        System.out.println("Are these polynomials the same?" + poly1.equals(poly1));
        System.out.println("Are these polynomials the same?" + poly2.equals(poly1));
        
        
        
        
        
//        for (int i = 0; i < mainPolynomialFonction.getLength(); i++) {
//            System.out.println(mainPolynomialFonction.getEntry(i));
//        }
//        while (mainPolynomialFonction.getEntry(0).next != null){
//
//            System.out.println("poly:" + polyOne.coefficient);
//            //.......
//        }     
//       System.out.println(polyOne);
//        for(int i = 0; i < ArrayList)
//        System.out.println();
//       
//        for ( Polynomial i : mainPolynomialFonction )
//            {
//                System.out.println( i );
//            }
//        
//        for ( Polynomial i : otherPolynomialFonction )
//            {
//                System.out.println( i );
//            }
    }
}
