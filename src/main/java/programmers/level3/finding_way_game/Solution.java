package programmers.level3.finding_way_game;

import java.util.*;

public class Solution {
    /*
        풀이
        이진트리를 만들고 순회를 한다.

        nodeinfo를 정렬해놓으면 좋을 것 같다.
        정렬 기준은 y값이 큰놈이 우선,
        y값이 같으면 x값이 작은놈이 우선

        정렬을 하고 맨 앞노드를 root(head)로 설정하고,
        그 다음 노드들을 계속 root node 를 기준으로 추가하며 이진트리를 만든다.

        이진트리를 만든 후에는 루트노드로부터 preorder, postorder 순회를 하여 값을 구한다.
    */
    private int idx = 0;

    public int[][] solution(int[][] nodeinfo) {
        List<TreeNode> info = new ArrayList<>();

        for (int i = 0; i < nodeinfo.length; i++) {
            info.add(new TreeNode(i + 1, nodeinfo[i]));
        }
        sortingYDescXAsc(info);

        Tree tree = new Tree();
        for (TreeNode node : info) {
            tree.addNode(node);
        }

        return new int[][]{preorder(tree, nodeinfo.length), postorder(tree, nodeinfo.length)};
    }

    private int[] preorder(Tree tree, int length) {
        int[] ans = new int[length];
        idx = 0;
        dfsPre(tree.head, ans);
        return ans;
    }

    private void dfsPre(TreeNode node, int[] ans) {
        if (node == null) return;

        ans[idx++] = node.val;
        if (node.hasLeft()) {
            dfsPre(node.left, ans);
        }
        if (node.hasRight()) {
            dfsPre(node.right, ans);
        }
    }

    private int[] postorder(Tree tree, int length) {
        int[] ans = new int[length];
        idx = 0;
        dfsPost(tree.head, ans);
        return ans;
    }

    private void dfsPost(TreeNode node, int[] ans) {
        if (node == null) return;

        if (node.hasLeft()) {
            dfsPost(node.left, ans);
        }
        if (node.hasRight()) {
            dfsPost(node.right, ans);
        }
        ans[idx++] = node.val;
    }

    private void sortingYDescXAsc(List<TreeNode> info) {
        Collections.sort(info, (o1, o2) -> {
            if (o1.y > o2.y) return -1;
            else if (o1.y == o2.y && o1.x < o2.x) return -1;
            else return 1;
        });
    }

    class Tree {
        private TreeNode head;

        private void addNode(TreeNode node) {
            if (head == null) {
                head = node;
                return;
            }

            TreeNode current = head;
            while (true) {
                if (isLeftSideNode(current, node)) {
                    if (current.left == null) {
                        current.left = node;
                        break;
                    }else {
                        current = current.left;
                    }
                }else if (isRightSideNode(current, node)) {
                    if (current.right == null) {
                        current.right = node;
                        break;
                    }else {
                        current = current.right;
                    }
                }
            }
        }

        private boolean isLeftSideNode(TreeNode current, TreeNode node) {
            return node.x < current.x;
        }

        private boolean isRightSideNode(TreeNode current, TreeNode node) {
            return current.x < node.x;
        }
    }

    class TreeNode {
        private int val;
        private int x, y;
        private TreeNode left;
        private TreeNode right;

        private TreeNode(int val, int[] node) {
            this.val = val;
            this.x = node[0];
            this.y = node[1];
        }

        private boolean hasLeft() {
            return left != null;
        }

        private boolean hasRight() {
            return right != null;
        }
    }
}