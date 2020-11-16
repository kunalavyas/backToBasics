package com.practice.traversals;

import java.util.*;

public class BinarySearchTree {
    Node root;
    int treeSize;
    Map<Integer, Boolean> isVisited = new HashMap<>();

    public void insert(int value) {
        Node node = new Node(value);
        treeSize++;
        isVisited.put(node.hashCode(), false);
        if (root == null) {
            this.root = node;
        } else {
            Node current = this.root;
            while (true) {
                if (current.value < value) {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = node;
                        break;
                    }

                } else {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = node;
                        break;
                    }
                }
            }
        }
    }

    public ArrayList<Integer> breadthFirstSearch() {
        Node currentNode = this.root;
        ArrayList<Node> queue = new ArrayList<>();
        ArrayList<Integer> resultArray = new ArrayList<>();

        queue.add(currentNode);
        while (queue.size() > 0) {
            currentNode = queue.remove(0);
            resultArray.add(currentNode.value);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return resultArray;
    }

    public ArrayList<Integer> depthFirstSearchPostOrder() {
        Node currentNode = this.root;
        Stack<Node> stack = new Stack<>();
        ArrayList<Integer> resultArray = new ArrayList<>();
        stack.push(currentNode);
        while (!stack.empty()) {
            currentNode = stack.peek();
            if (currentNode.left != null && !isVisited.get(currentNode.left.hashCode())) {
                stack.push(currentNode.left);
                currentNode = currentNode.left;
                continue;
            }
            if (currentNode.right != null && !isVisited.get(currentNode.right.hashCode())) {
                stack.push(currentNode.right);
                currentNode = currentNode.right;
                continue;
            }

            isVisited.put(currentNode.hashCode(), true);
            resultArray.add(currentNode.value);
            stack.pop();
        }
        return resultArray;
    }

    public List<Integer> depthFirstInorder() {
        List<Integer> returnValue = new ArrayList<>();
        return traverseInorder(this.root, returnValue);
    }

    public List<Integer> traverseInorder(Node currentNode, List<Integer> returnValue) {
        if (currentNode.left != null) {
            traverseInorder(currentNode.left, returnValue);
        }
        returnValue.add(currentNode.value);
        if (currentNode.right != null) {
            traverseInorder(currentNode.right, returnValue);
        }
        return returnValue;
    }

    public void depthFirstPreorder() {

    }

    public void depthFirstPostorder() {

    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(9);
        bst.insert(4);
        bst.insert(6);
        bst.insert(20);
        bst.insert(170);
        bst.insert(15);
        bst.insert(1);

        System.out.println("bfs: " + bst.breadthFirstSearch());
        System.out.println("dfs: " + bst.depthFirstInorder());
    }

}
