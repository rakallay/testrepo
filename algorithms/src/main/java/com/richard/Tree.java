package com.richard;

public class Tree<T extends Comparable<T>>
{
    
    private TreeNode<T> root;

    public Tree()
    {
	root = null;
    }

    public Tree(TreeNode<T> root)
    {
	this.root = root;
    }

    public boolean exists(T data)
    {
	return iterativeSearch(data) != null;
    }
    
    private T search(TreeNode<T> root, T data)
    {
	if (root == null)
	    return null;
	if (root.getData().compareTo(data) == 0)
	    return root.getData();
	if (root.getData().compareTo(data) < 0)
	    return search(root.getRight(), data);
	return search(root.getLeft(), data);
    }

    private T iterativeSearch(T data)
    {
	TreeNode<T> temp = root;
	while (temp != null)
	{
	    if (temp.getData().compareTo(data) == 0)
		return temp.getData();
	    if (temp.getData().compareTo(data) > 0)
		temp = temp.getLeft();
	    else
		temp = temp.getRight();
	}
	return null;
    }

}
