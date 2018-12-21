class Node {    
    int value;
    Node leftChild,  rightChild;
    Node leftThread, rightThread;

    Node(int val) {
        value = val;
    }
}

class OrderedTree {
    Node root;

    OrderedTree() {
        root = new Node(-1);
    }

    private void _addNode(Node currentNode, int valueToInsert) {

        if (valueToInsert < currentNode.value) {
            if (currentNode.leftChild == null) {
                Node childNode = new Node(valueToInsert);
                childNode.leftThread = currentNode.leftThread;
                childNode.rightThread = currentNode;
                currentNode.leftChild = childNode;
                currentNode.leftThread = null;
            }
            else {
                _addNode(currentNode.leftChild, valueToInsert);
            }
        }
        else {
            if (currentNode.rightChild == null) {
                Node childNode = new Node(valueToInsert);
                childNode.leftThread = currentNode;
                childNode.rightThread = currentNode.rightThread;
                currentNode.rightChild = childNode;
                currentNode.rightThread = null;
            }
            else {
                _addNode(currentNode.rightChild, valueToInsert);
            }
        }
    }

    private void _traverseInorder(Node currentNode) {
        if (currentNode.leftChild != null) {
            _traverseInorder(currentNode.leftChild);
        }

        if (currentNode.value != -1) {
            System.out.print(currentNode.value + " ");
        }

        if (currentNode.rightChild != null) {
            _traverseInorder(currentNode.rightChild);
        }
    }

    private void _traverseBackorder(Node currentNode) {
        if (currentNode.rightChild != null) {
            _traverseBackorder(currentNode.rightChild);
        }

        if (currentNode.value != -1) {
            System.out.print(currentNode.value + " ");
        }

        if (currentNode.leftChild != null) {
            _traverseBackorder(currentNode.leftChild);
        }

    }

    void inorderWithTreads() {
        Node currentNode = root;
        boolean via_branch = true;

        while (currentNode != null) {
            if (via_branch) {
                while (currentNode.leftChild != null) {
                    currentNode = currentNode.leftChild;
                }
            }

            if (currentNode.value != -1) {
                System.out.print(currentNode.value + " ");
            }

            if (currentNode.rightChild != null) {
                via_branch = true;
                currentNode = currentNode.rightChild;
            }
            else {
                via_branch = false;
                currentNode = currentNode.rightThread;
            }
        }
    }

    void backorderWithTreads() {
        Node currentNode = root;
        boolean via_branch = true;

        while (currentNode != null) {
            if (via_branch) {
                while (currentNode.rightChild != null) {
                    currentNode = currentNode.rightChild;
                }
            }

            if (currentNode.value != -1) {
                System.out.print(currentNode.value + " ");
            }

            if (currentNode.leftChild != null) {
                via_branch = true;
                currentNode = currentNode.leftChild;
            }
            else {
                via_branch = false;
                currentNode = currentNode.leftThread;
            }
        }
    }

    void traverseInorder() {
        _traverseInorder(root);
    }

    void addNode(int value) {
        _addNode(root, value);
    }

    void traverseBackorder() {
        _traverseBackorder(root);
    }
}

class Demonstration {
    public static void main(String[] args) {
        OrderedTree orderedTree = new OrderedTree();

        orderedTree.addNode(5);
        orderedTree.addNode(2);
        orderedTree.addNode(6);
        orderedTree.addNode(4);
        orderedTree.addNode(1);
        orderedTree.addNode(9);
        orderedTree.addNode(7);

        orderedTree.traverseInorder();
        System.out.println();

        orderedTree.traverseBackorder();
        System.out.println();

        orderedTree.inorderWithTreads();
        System.out.println();

        orderedTree.backorderWithTreads();
        System.out.println();

    }
}