/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomialcalculator;

import polynomialcalculator.ListInterface;

/**
 *
 * @author Dimitri
 */
public class LinkedList<T> implements ListInterface<T> {
    
    private Node<T> head;
    private int numberOfEntries;
    
    public LinkedList()
    {
        head = new Node(null, null, null);
        head.previous = head;
        head.next = head;
        
        numberOfEntries = 0;
    }
    
    @Override
    public void add(T newEntry) {
        add(numberOfEntries, newEntry);
    }

    @Override
    public void add(int newPosition, T newEntry) {
        // might be nice to return false if given an invalid position
        if ( isValidPosition(newPosition))
        {
            Node<T> current = walkToNode( newPosition );
            
            Node<T> newNode = new Node(current.previous, newEntry, current);
            newNode.previous.next = newNode;
            newNode.next.previous = newNode;   
            numberOfEntries++;
        }
    }

    @Override
    public T remove(int givenPosition) {
        if ( isValidPosition( givenPosition ) )
        {
            Node<T> current = walkToNode(givenPosition);
            T item = current.data;
            
            current.previous.next = current.next;
            current.next.previous = current.previous;
            numberOfEntries--;
            return item;            
        }
        return null;
    }

    @Override
    public void clear() {
        head = new Node(null, null, null);
        numberOfEntries = 0;
    }

    @Override
    public T replace(int givenPosition, T newEntry) {
        if ( isValidPosition( givenPosition ) )
        {
            Node<T> current = walkToNode(givenPosition);
            T item = current.data;
            current.data = newEntry;
            
            return item;
        }
        return null;
    }

    @Override
    public T getEntry(int givenPosition) {
        if ( isValidPosition( givenPosition ) )
        {
            Node<T> current = walkToNode(givenPosition);
            return current.data;
        }
        return null;
    }

    @Override
    public boolean contains(T anEntry) {
        Node current = head.next;
        while ( current != head )
        {
            if ( current.data.equals( anEntry ) )
            {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int getLength() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }
    
    private class Node<T>
    {
        T data;
        Node previous;
        Node next;
        
        public Node(Node previous, T data, Node next)
        {
            this.previous = previous;
            this.data = data;
            this.next = next;
        }
    }
    
    private boolean isValidPosition( int givenPosition )
    {
        // would be better to throw exception here if the position is invalid
        return givenPosition >= 0 && givenPosition <= numberOfEntries;
    }
    
    private Node<T> walkToNode( int givenPosition )
    {
        if ( isValidPosition( givenPosition ) )
        {
            Node current;
            // closer to the first
            if ( givenPosition < numberOfEntries / 2 )
            {
                current = head.next;
                int currentPosition = 0;
                while ( currentPosition < givenPosition )
                {
                    current = current.next;
                    currentPosition++;
                }
            }
            // closer to the last
            else
            {
                current = head;
                int currentPosition = numberOfEntries;
                while ( givenPosition < currentPosition )
                {
                    current = current.previous;
                    currentPosition--;
                }
            }

            return current;
        }
        return null;
    }
    
}
