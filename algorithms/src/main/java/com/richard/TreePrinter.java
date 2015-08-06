package com.richard;

import com.richard.TreeNode;
import com.richard.Tree;

public class TreePrinter
{

    public static void main(String[] args)
    {
	TreeNode<Integer> node1 = new TreeNode<Integer>(6);

	TreeNode<Integer> node2 = new TreeNode<Integer>(5);
	node1.setLeft(node2);

	TreeNode<Integer> node3 = new TreeNode<Integer>(2);
	node2.setLeft(node3);

	TreeNode<Integer> node4 = new TreeNode<Integer>(5);
	node3.setRight(node4);

	TreeNode<Integer> node5 = new TreeNode<Integer>(7);
	node1.setRight(node5);

	TreeNode<Integer> node6 = new TreeNode<Integer>(8);
	node5.setRight(node6);

	TreePrinter printer = new TreePrinter();
	System.out.println("InOrder Print");
	printer.inOrderPrint(node1);
	System.out.println();

	System.out.println("PreOrder Print");
	printer.preOrderPrint(node1);
	System.out.println();

	System.out.println("PostOrder Print");
	printer.postOrderPrint(node1);
	System.out.println();

	Tree<Integer> tree = new Tree<Integer>(node1);
	System.out.println("6 exists: " + tree.exists(6));
	System.out.println("5 exists: " + tree.exists(5));
	System.out.println("2 exists: " + tree.exists(2));
	System.out.println("5 exists: " + tree.exists(5));
	System.out.println("7 exists: " + tree.exists(7));
	System.out.println("8 exists: " + tree.exists(8));
	System.out.println("9 exists: " + tree.exists(9));
    }

    public void inOrderPrint(TreeNode<?> node)
    {
	if (node == null)
	    return;
	inOrderPrint(node.getLeft());
	printNodeData(node);
	inOrderPrint(node.getRight());
    }

    public void preOrderPrint(TreeNode<?> node)
    {
	if (node == null)
	    return;
	printNodeData(node);
	preOrderPrint(node.getLeft());
	preOrderPrint(node.getRight());	
    }

    public void postOrderPrint(TreeNode<?> node)
    {
	if (node == null)
	    return;
	postOrderPrint(node.getLeft());
	postOrderPrint(node.getRight());
	printNodeData(node);
    }

    public void printNodeData(TreeNode<?> node)
    {
	System.out.print("[" + node.getData() + "], ");
    }
}
