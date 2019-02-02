package polynomialcalculator;

import java.util.ArrayList;
import javafx.collections.transformation.SortedList;

/**
 *
 * @author Dim
 */
public class Polynomial {

    double coefficient;
    int exponent;

    public Polynomial(double coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public ArrayList<Polynomial> add(ArrayList<Polynomial> mainPoly, ArrayList<Polynomial> otherPoly) {
        ArrayList<Polynomial> addedPolynomials = new ArrayList<>();

        ArrayList<Polynomial> tempMainPoly = sortingArray(copyArray(mainPoly));

        ArrayList<Polynomial> tempOtherPoly = sortingArray(copyArray(otherPoly));

        double newPolynomialCoefficient;
        int newPolynomialExponent;

        for (int i = 0; i < tempMainPoly.size(); i++) {
            for (int y = 0; y < tempOtherPoly.size(); y++) {
                if (tempMainPoly.get(i).exponent == tempOtherPoly.get(y).exponent
                        && tempMainPoly.get(i).exponent != -1 && tempOtherPoly.get(y).exponent != -1) {
                    newPolynomialCoefficient = tempMainPoly.get(i).coefficient + tempOtherPoly.get(y).coefficient;
                    newPolynomialExponent = tempMainPoly.get(i).exponent;

                    addedPolynomials.add(new Polynomial(newPolynomialCoefficient, newPolynomialExponent));

                    tempMainPoly.get(i).setExponent(-1);
                    tempOtherPoly.get(y).setExponent(-1);
                }
            }
        }

        for (int y = 0; y < tempOtherPoly.size(); y++) {
            if (tempOtherPoly.get(y).exponent != -1) {
                newPolynomialCoefficient = tempOtherPoly.get(y).coefficient;
                newPolynomialExponent = tempOtherPoly.get(y).exponent;

                addedPolynomials.add(new Polynomial(newPolynomialCoefficient, newPolynomialExponent));
                tempOtherPoly.get(y).setExponent(-1);
            }
        }
        //tempAddedPolynomials.get(exponent).exponent .sort(Polynomial, new ExponentComparator());

        return sortingArray(addedPolynomials);
    }

    public ArrayList<Polynomial> differentiate(ArrayList<Polynomial> mainPoly) {
        ArrayList<Polynomial> differentiatedPolynomial = new ArrayList<>();
        ArrayList<Polynomial> tempPolynomial = sortingArray(copyArray(mainPoly));
        
        double newCoefficient = 0;
        int newExponent = 0;

        int counter = tempPolynomial.size();
        while (counter != 0) {
            for (int i = 0; i < tempPolynomial.size(); i++) {
                newCoefficient = ((tempPolynomial.get(i).coefficient) * (tempPolynomial.get(i).exponent));
                if (tempPolynomial.get(i).exponent > 0) {
                    newExponent = tempPolynomial.get(i).exponent - 1;
                } else {
                    newExponent = 0;
                }
                differentiatedPolynomial.add(new Polynomial(newCoefficient, newExponent));
                tempPolynomial.remove(i);
            }
            counter--;
        }
        return sortingArray(differentiatedPolynomial);
    }

    public ArrayList<Polynomial> integrate(ArrayList<Polynomial> mainPoly) {
        ArrayList<Polynomial> integratedPolynomial = new ArrayList<>();

        ArrayList<Polynomial> tempPolynomial = sortingArray(copyArray(mainPoly));
        double newCoefficient = 0;
        int newExponent = 0;

        int counter = tempPolynomial.size();
        while (counter != 0) {
            for (int i = 0; i < tempPolynomial.size(); i++) {
                newExponent = (tempPolynomial.get(i).exponent) + 1;
                if (tempPolynomial.get(i).coefficient > 0) {
                    newCoefficient = ((tempPolynomial.get(i).coefficient) / (newExponent));
                } else {
                    newCoefficient = 0;
                }
                integratedPolynomial.add(new Polynomial(newCoefficient, newExponent));
                tempPolynomial.remove(i);
            }
            counter--;
        }
        return sortingArray(integratedPolynomial);
    }

    public boolean equals(Polynomial other) {
        return this.toString().equals(other.toString());
    }

    private void setExponent(int exponent) {
        this.exponent = exponent;
    }

    private ArrayList<Polynomial> copyArray(ArrayList<Polynomial> arrayToCopy) {
        ArrayList<Polynomial> ArrayToPaste = new ArrayList<>();

        for (int i = 0; i < arrayToCopy.size(); i++) {
            ArrayToPaste.add(new Polynomial(arrayToCopy.get(i).coefficient, arrayToCopy.get(i).exponent));
        }
        return ArrayToPaste;
    }

    private ArrayList<Polynomial> sortingArray(ArrayList<Polynomial> arrayToSort) {
        ArrayList<Polynomial> ArraySorted = new ArrayList<>();

        int counter = arrayToSort.size();

        while (counter != 0) {
            int exponentMax = 0;
            int indexOfexponentMax = 0;
            for (int i = 0; i < arrayToSort.size(); i++) {
                if (arrayToSort.get(i).exponent >= exponentMax) {
                    exponentMax = arrayToSort.get(i).exponent;
                    indexOfexponentMax = i;
                }
            }
            ArraySorted.add(new Polynomial(arrayToSort.get(indexOfexponentMax).coefficient,
                    arrayToSort.get(indexOfexponentMax).exponent));
            arrayToSort.remove(indexOfexponentMax);
            counter--;
        }

        return ArraySorted;
    }

    @Override
    public String toString() {
        String s = "";
        if (exponent > 0) {
            if (coefficient > 0) {
                s = s + " + " + coefficient + "x^" + exponent;
            } else if (coefficient < 0) {
                s = s + " - " + (-coefficient) + "x^" + exponent;
            }
        } else {
            if (coefficient > 0) {
                s = s + " + " + coefficient;
            } else if (coefficient < 0) {
                s = s + " - " + (-coefficient);
            }
        }
        return s;
    }
}
