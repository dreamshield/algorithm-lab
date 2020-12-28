package com.ericvip.algorithm.sword;

import apple.laf.JRSUIUtils;
import com.ericvip.algorithm.structure.BinaryTree;

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

    /**
     * 面试题8：二叉树的下一个节点
     * 给定一棵二叉树和其中的一个节点，如何找出中序遍历序列中该节点对应的下一个节点？
     * 树中节点除了有两个分别指向左、右子节点的指针，还有一个指向父节点的指针。
     * 场景1：节点存在右节点
     * 场景2：节点不存在右节点且是其父节点的左节点
     * 场景3：节点不存在右节点且是其父节点的右节点
     * - 未找到(遍历到根节点)
     * - 找到(某个存在左节点的父节点)
     *
     * @param node 指定的节点
     * @return 指定节点的下一个节点
     */
    public static TreeNode getInorderNextNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode nextNode = null;
        // 存在右节点
        if (node.right != null) {
            nextNode = node.right;
            // 找到右子树的最左节点停止遍历，该最左节点就是目标节点
            while (nextNode.left != null) {
                nextNode = nextNode.left;
            }
        } else if (node.parent != null) {
            TreeNode current = node;
            TreeNode parent = current.parent;
            // 不存在右节点-①其父节点右节点；②其父节点左节点。
            // 找到当前节点是其父节点的左节点停止遍历，且其父节点就是目标节点
            while (parent != null && parent.right == current) {
                current = current.parent;
                parent = current.parent;
            }
            nextNode = parent;
        }
        return nextNode;
    }

    public static class TreeNode {
        int val;
        private TreeNode left;
        private TreeNode right;
        private TreeNode parent;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
