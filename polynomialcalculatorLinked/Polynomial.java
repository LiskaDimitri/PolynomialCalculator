package polynomialcalculatorlinked;

/**
 *
 * @author Dim
 */
public class Polynomial{

    private Node head = new Node(0, 0);
    private Node lastNode = head;
    
    public Polynomial() {
    }

    public Polynomial(double coefficient, int exponent) {
        lastNode.next = new Node(coefficient, exponent);
        lastNode = lastNode.next;
    }
    public Polynomial add(Polynomial otherPoly){
        Polynomial mainPoly = this;
        Polynomial addedPoly = new Polynomial();
        Node currentNodeMainPoly = mainPoly.head.next;
        Node currentNodeOtherPoly = otherPoly.head.next;
        
        while(currentNodeMainPoly != null && currentNodeOtherPoly != null) {
            Node nodeToAdd = null;
            if(currentNodeMainPoly == null ){
                
                nodeToAdd = 
                
                nodeToAdd.coefficient = currentNodeOtherPoly.coefficient;
                nodeToAdd.exponent = currentNodeOtherPoly.exponent;
                currentNodeOtherPoly = currentNodeOtherPoly.next;   
            }
            else if(currentNodeOtherPoly == null){
                nodeToAdd.coefficient = currentNodeMainPoly.coefficient;
                nodeToAdd.exponent = currentNodeMainPoly.exponent;
                currentNodeMainPoly = currentNodeMainPoly.next;
            }
//            else if(currentNodeMainPoly.exponent > currentNodeOtherPoly.exponent){
//                
//            }
//            else if(currentNodeMainPoly.exponent < currentNodeOtherPoly.exponent){
//                
//            }
//            else{
//                double coefficientToAdd = currentNodeMainPoly.coefficient 
//                                    + currentNodeOtherPoly.coefficient;
//                int exponentToAdd = 
//            }
            addedPoly.lastNode.next = nodeToAdd;
            addedPoly.lastNode = lastNode.next;
        }
        return null;
    }

    private class Node<Polynomial> {

        double coefficient;
        int exponent;
        Node next;

        public Node(double coefficient, int exponent) {

            this.coefficient = coefficient;
            this.exponent = exponent;
        //    this.next = next;
        }
    }
}
