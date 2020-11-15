package com.practice.traversals;

import java.util.ArrayList;

public class BinarySearchTree {
    Node root;

    public void insert(int value){
        Node node=new Node(value);
        if(root==null){
            this.root=node;
        }
        else{
            Node current= this.root;
            while(true){
                if(current.value<value){
                    if(current.right!=null){
                        current=current.right;
                    }
                    else{
                        current.right=node;
                        break;
                    }

                } else{
                    if(current.left!=null){
                        current=current.left;
                    }
                    else{
                        current.left=node;
                        break;
                    }
                }
            }
        }
    }

    public ArrayList<Integer> breadthFirstSearch(){
        Node currentNode=this.root;
        ArrayList<Node> queue= new ArrayList<>();
        ArrayList<Integer> resultArray = new ArrayList<>();

        queue.add(currentNode);
        while(queue.size()>0){
            currentNode=queue.remove(0);
            resultArray.add(currentNode.value);
            if(currentNode.left!=null){
                queue.add(currentNode.left);
            }
            if(currentNode.right!=null){
                queue.add(currentNode.right);
            }
        }
        return resultArray;
    }

    public static void main(String[] args) {
        BinarySearchTree bst= new BinarySearchTree();
        bst.insert(9);
        bst.insert(4);
        bst.insert(6);
        bst.insert(20);
        bst.insert(170);
        bst.insert(15);
        bst.insert(1);

        System.out.println("bfs: " + bst.breadthFirstSearch());
    }

}
