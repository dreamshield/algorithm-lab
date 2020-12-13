package com.ericvip.algorithm.sword;

import java.util.Arrays;

/**
 * 二叉树相关面试题
 *
 * @author EricZhang
 * @date 2020/12/10
 * @time 8:35 AM
 */
public class BinaryTreeSolution {

    /**
     * 面试题7：重建二叉树
     * 描述：输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * <p>
     * 例如，给出
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     *
     * @param preorder
     * @param inorder
     * @return 根节点
     */
    public static TreeNode buildTreeWithArrayCopy(int[] preorder, int[] inorder) {
        // 判断数据有效性
        if (preorder == null || inorder == null || preorder.length <= 0 || preorder.length != inorder.length) {
            throw new NumberFormatException("二叉树数据格式错误");
        }
        TreeNode root = new TreeNode(preorder[0]);
        // 叶子节点直接返回
        if (preorder.length == 1) {
            if (preorder[0] == inorder[0]) {
                return root;
            } else {
                throw new NumberFormatException("二叉树数据格式错误");
            }
        }
        // 查找当前根节点对应的左右子树的长度
        int leftSubTreeLength = 0;
        int i = 0;
        while (i < inorder.length) {
            if (inorder[i] != root.val) {
                leftSubTreeLength++;
            } else {
                break;
            }
            i++;
        }
        // 中序遍历序列中不存在前序遍历的根节点
        if (i == inorder.length) {
            throw new NumberFormatException("二叉树数据格式错误");
        }
        // 递归处理左子树
        if (leftSubTreeLength > 0) {
            root.left = buildTreeWithArrayCopy(
                    Arrays.copyOfRange(preorder, 1, leftSubTreeLength + 1),
                    Arrays.copyOfRange(inorder, 0, leftSubTreeLength)
            );
        }
        // 递归处理右子树
        if (leftSubTreeLength < preorder.length) {
            root.right = buildTreeWithArrayCopy(
                    Arrays.copyOfRange(preorder, leftSubTreeLength + 1, preorder.length),
                    Arrays.copyOfRange(inorder, leftSubTreeLength + 1, inorder.length)
            );
        }
        return root;
    }

    public static class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
