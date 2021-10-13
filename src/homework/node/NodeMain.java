package homework.node;

public class NodeMain {
    //Main class to test functions
    public static void main(String[] args) {

        Node<String> node = new Node<>("Sus",new Node("Amongus",new Node("Amongus")));

        node = NodeUtils.addNodeIn(node,3,new Node<>("Poggers"));

        node = NodeUtils.removeNodeIn(node,3);

        System.out.println(node);
    }

}
