public class AVLTree {
    private class AVLNode {
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(int value) { this.value = value; }

        @Override
        public String toString() { return "Node=" + value; }
    }

    private AVLNode root;

    public void insert(int value) {
        AVLNode newNode = new AVLNode(value);

        if(root == null) {
            root = newNode;
            return;
        }


    }


}
