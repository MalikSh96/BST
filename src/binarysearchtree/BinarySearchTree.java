package binarysearchtree;

public class BinarySearchTree {

    Node root;

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.put(10, "A");
        bst.put(15, "B");
        bst.put(5, "C");
        bst.put(20, "D");
        bst.put(1, "E");
        bst.put(11, "M");
        bst.keys(bst.root);
        System.out.println(bst.size(bst.root));
        System.out.println(bst.get(10, bst.root));
    }

    public Node get(int key, Node node) {
        Node getNode = null;
        if (node == null)
        return null;
        if(node.key == key)
            return node;
            if(node.leftC != null)
            getNode = get(key, node.leftC);
            if (getNode == null) {
                getNode = get(key, node.rightC);
            }
            return getNode;
        }
    

//    public boolean containsKey(Node key)
//    {
//        
//    }
    private void put(int key, String name, Node node) {
        if (key == node.key) {
            node.name = name;
            return;
        }

        if (key < node.key) {
            if (node.leftC == null) {
                node.leftC = new Node(key, name);
                return;
            }
            put(key, name, node.leftC);
        }

        //do the opposite
        if (key > node.key) {
            if (node.rightC == null) {
                node.rightC = new Node(key, name);
                return;
            }
            put(key, name, node.rightC);
        }
    }

    public void put(int key, String name) {
        if (root == null) {
            //Make new root
            root = new Node(key, name);
            return;
        }
        put(key, name, root);
    }

    public void keys(Node node) {
        if (node != null) {
            System.out.println(node);
            keys(node.leftC);
            keys(node.rightC);
        }
    }

    public int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return (size(node.leftC) + 1 + size(node.rightC));
        }
    }
}
