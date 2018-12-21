class Node {    
    int value;
    Node prevNode;
    Node leftChild,  rightChild;

    Node(int val) {
        value = val;
    }
}

class BinaryTree {
    Node root;

    BinaryTree() {
        root = new Node(-1);
    }

    private void _addNode(Node currentNode, int valueToInsert) {
        if (valueToInsert < currentNode.value) {
            if (currentNode.leftChild == null) {
                Node childNode = new Node(valueToInsert);
                childNode.prevNode = currentNode;
                currentNode.leftChild = childNode;
            }
            else {
                currentNode = currentNode.leftChild;
                _addNode(currentNode, valueToInsert);
            }
        }
        else {
            if (currentNode.rightChild == null) {
                Node childNode = new Node(valueToInsert);
                childNode.prevNode = currentNode;
                currentNode.rightChild = childNode;
            }
            else {
                currentNode = currentNode.rightChild;
                _addNode(currentNode, valueToInsert);
            }
        }
    }

    private Node _getNode(Node currentNode, int valueToGet) {
        if (currentNode.value == valueToGet) return currentNode;

        if (valueToGet < currentNode.value) {
            if (currentNode.leftChild == null) return null;
            else {
                currentNode = currentNode.leftChild;
                return _getNode(currentNode, valueToGet);
            }
        }
        else {
            if (currentNode.rightChild == null) return null;
            else {
                currentNode = currentNode.rightChild;
                return _getNode(currentNode, valueToGet);
            }
        }
    }

    private void _deleteNode(Node currentNode, int valueToDelete) {
        if (currentNode.value == valueToDelete) {
            System.out.println("---" + currentNode.leftChild + " " + currentNode.rightChild + " " + currentNode.prevNode);
            if (currentNode.leftChild == null || currentNode.rightChild == null) {
                if (currentNode.prevNode.leftChild == currentNode) {
                    currentNode.prevNode.leftChild = 
                        (currentNode.leftChild == null) ? currentNode.rightChild : currentNode.leftChild;

                    if (currentNode.prevNode.leftChild != null) {
                        currentNode.prevNode.leftChild.prevNode = currentNode.prevNode;
                    }
                }
                else {
                    currentNode.prevNode.rightChild = 
                        (currentNode.leftChild == null) ? currentNode.rightChild : currentNode.leftChild;
                    if (currentNode.prevNode.rightChild != null) {
                        currentNode.prevNode.leftChild.prevNode = currentNode.prevNode;
                    }
                    //currentNode.prevNode.leftChild.prevNode = currentNode.prevNode;
                }
            }
            else {
                Node updaterNode = currentNode.leftChild;

                while (updaterNode.rightChild != null)
                    updaterNode = updaterNode.rightChild;

                currentNode.value = updaterNode.value;

                // Потому что у левого потомка может не быть правого потомка
                if (updaterNode.prevNode.leftChild == updaterNode) {
                    updaterNode.prevNode.leftChild = updaterNode.leftChild;
                }
                else {
                    updaterNode.prevNode.rightChild = updaterNode.leftChild;
                }
            }

            return;
        }

        if (valueToDelete < currentNode.value) {
            if (currentNode.leftChild == null) {
                System.out.println("Warning: element wasn't found");
                return;
            }
            else {
                _deleteNode(currentNode.leftChild, valueToDelete);
            }
        }
        else {
            if (currentNode.rightChild == null) {
                System.out.println("Warning: element wasn't found");
                return;
            }
            else {
                _deleteNode(currentNode.rightChild, valueToDelete);
            }
        }
    }

    Node getNode(int value) {
        return _getNode(root, value);
    }

    void deleteNode(int value) {
        _deleteNode(root, value);
    }

    void addNode(int value) {
        _addNode(root, value);
    }
}

class Demonstration {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        int[] values = {60, 35, 76, 17, 42, 68, 11, 24, 63, 69, 23};

        for (int value: values) {
            binaryTree.addNode(value);
        }

        int node = 24;
        Node targetNode;


        targetNode = binaryTree.getNode(node);
        if (targetNode != null) {
            System.out.println(targetNode.value);
        }
        else {
            System.out.println("Wasn't found");
        }
        binaryTree.deleteNode(node);
        targetNode = binaryTree.getNode(node);
        if (targetNode != null) {
            System.out.println(targetNode.value);
        }
        else {
            System.out.println("Wasn't found");
        }

        targetNode = binaryTree.getNode(23);
        if (targetNode != null) {
            System.out.println(targetNode.value);
        }
        else {
            System.out.println("Wasn't found");
        }
        binaryTree.deleteNode(23);
        targetNode = binaryTree.getNode(23);
        if (targetNode != null) {
            System.out.println(targetNode.value);
        }
        else {
            System.out.println("Wasn't found");
        }

        targetNode = binaryTree.getNode(11);
        if (targetNode != null) {
            System.out.println(targetNode.value);
        }
        else {
            System.out.println("Wasn't found");
        }
    }
}