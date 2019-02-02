package polynomialcalculator;

import java.util.Comparator;

/**
 *
 * @author Dim
 */
public class ExponentComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer exponent1, Integer exponent2) {
        int exponentDifference = exponent1 - exponent2;
        
        if ( exponentDifference != 0 )
        {
            return exponentDifference;
        }
        else
        {
            return exponent1.compareTo(exponent2);
        }
    }
}
