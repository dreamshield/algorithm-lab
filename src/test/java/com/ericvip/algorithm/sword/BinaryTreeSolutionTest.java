package com.ericvip.algorithm.sword;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author EricZhang
 * @date 2020/12/11
 * @time 8:16 AM
 */
public class BinaryTreeSolutionTest {

    @Test
    public void testBuildTree() {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        BinaryTreeSolution.TreeNode root = BinaryTreeSolution.buildTreeWithArrayCopy(preorder, inorder);
        Assert.assertNotNull(root);
    }
}