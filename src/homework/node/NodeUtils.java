package homework.node;

import java.util.Scanner;

public class NodeUtils {

    private static Scanner s =  new Scanner(System.in);

    public static Node<String> getNodeListFromUser() {
        s.useDelimiter("\n");
        Node<String> firstNode = new Node<>(null);
        Node<String> lastNode = firstNode;
        while (true) {
            System.out.println("1 - Add value to node 0 - Leave the node creation");
            System.out.println("Enter Function:");

            try {
                int function = s.nextInt();
                if (function == 0) {
                    break;
                }

                if (function == 1) {
                    System.out.println("Enter Value:");
                    String value = s.next();
                    System.out.println(value);
                    Node node = new Node(value);
                    lastNode.setNextNode(node);
                    lastNode = node;
                }
            } catch (Exception ignored){}


        }


        return firstNode;
    }

    public static<T> Node hasValue(Node<T> node,T value) {
        Node currentNode = node;
        while(currentNode != null) {
            if (currentNode.getValue().equals(value)) return currentNode;
            currentNode = currentNode.getNextNode();
        }
        return null;
    }

    public static<T> int valueAmountInNode(Node<T> node,T value) {
        Node currentNode = node;
        int counter = 0;
        while(currentNode != null) {
            if (currentNode.getValue().equals(value)) counter++;
            currentNode = currentNode.getNextNode();
        }
        return counter;
    }
    //Returns the head of the nodes
    public static<T> Node<T> addNodeIn(Node<T> headNode,int index, Node<T> node) {
        if (index < 0) throw new RuntimeException("Index Cannot Be Negative!");
        Node<T> nodeToMove = getNodeIn(headNode,index);
        node.setNextNode(nodeToMove);

        if (index == 0) {
            return node;
        } else {
            Node<T> nodeBefore = getNodeIn(headNode,index - 1);
            nodeBefore.setNextNode(node);
            return headNode;
        }

    }
    //Returns the head of the nodes
    public static<T> Node<T> removeNodeIn(Node<T> headNode,int index) {
        if (index < 0) throw new RuntimeException("Index Cannot Be Negative!");

        if (index == 0) {
            return getNodeIn(headNode,1);
        } else {
            Node<T> nodeBefore = getNodeIn(headNode,index - 1);
            Node<T> nodeAfter = getNodeIn(headNode,index + 1);
            nodeBefore.setNextNode(nodeAfter);
            return headNode;
        }

    }


    private static<T> Node<T> getNodeIn(Node<T> headNode, int index) {
        Node currentNode = headNode;
        for (int i = 0; i < index; i++) {
            if (currentNode != null) {
                currentNode = currentNode.getNextNode();
            } else {
                throw new IndexOutOfBoundsException("Node Index: " + index + " is out of bounds!");
            }

        }
        return currentNode;
    }

}
