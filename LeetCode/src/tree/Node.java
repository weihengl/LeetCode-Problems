package tree;

import java.util.List;

/*
 * defined for standard Leetcode n-ary tree(every node has no more than n children)
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
