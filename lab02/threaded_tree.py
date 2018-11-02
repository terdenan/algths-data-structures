class Node:
    def __init__(self, value):
        self.value = value
        self.left_child = None
        self.right_child = None
        self.left_thread = None
        self.right_thread = None


class ThreadedTree:
    def __init__(self):
        self.root = Node(-1)

    def _add_node(self, current_node, new_node):
        if new_node.value < current_node.value:
            if current_node.left_child is not None:
                current_node = current_node.left_child
                self._add_node(current_node, new_node)
            else:
                new_node.left_thread = current_node.left_thread
                new_node.right_thread = current_node
                current_node.left_child = new_node
                current_node.left_thread = None
        else:
            if current_node.right_child is not None:
                current_node = current_node.right_child
                self._add_node(current_node, new_node)
            else:
                new_node.left_thread = current_node
                new_node.right_thread = current_node.right_thread
                current_node.right_child = new_node
                current_node.rightThread = None

    def inorder_with_threads(self):
        current_node = self.root
        via_branch = True

        lst = []

        while current_node is not None:
            if via_branch:
                while current_node.left_child is not None:
                    current_node = current_node.left_child

            if current_node.value != -1: lst.append(current_node.value)

            if current_node.right_child is not None:
                via_branch = True
                current_node = current_node.right_child
            else:
                via_branch = False
                current_node = current_node.right_thread                

        return lst

    def backorder_with_threads(self):
        current_node = self.root
        via_branch = True

        lst = []

        while current_node is not None:
            if via_branch:
                while current_node.right_child is not None:
                    current_node = current_node.right_child

            if current_node.value != -1: lst.append(current_node.value)

            if current_node.left_child is not None:
                via_branch = True
                current_node = current_node.left_child
            else:
                via_branch = False
                current_node = current_node.left_thread                

        return lst

    def add_node(self, value):
        new_node = Node(value)
        self._add_node(self.root, new_node)



if __name__ == '__main__':
    lst = list(map(int, input().split()))
    threaded_tree = ThreadedTree()

    for item in lst:
        threaded_tree.add_node(item)

    print(threaded_tree.inorder_with_threads());
    print(threaded_tree.backorder_with_threads());