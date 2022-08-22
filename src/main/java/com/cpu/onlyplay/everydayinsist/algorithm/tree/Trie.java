package com.cpu.onlyplay.everydayinsist.algorithm.tree;

import org.springframework.util.Assert;

/**
 * @program: everydayinsist
 * @description: 前缀树
 * @author: cpuRick
 * @create: 2022-08-21 09:35
 **/
class Trie {


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        boolean result = trie.search("apple");
        trie.search("app");
        Assert.isTrue(result);
    }

    public static class TreeNode {
        private final TreeNode[] sons;

        private boolean isEnd;


        public TreeNode[] getSons() {
            return this.sons;
        }

        public TreeNode() {
            sons = new TreeNode[24];
            this.isEnd = false;
        }


    }

    private final TreeNode root;


    public Trie() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode current = this.root;
        for (int index = 0; index < word.length(); index++) {
            Character character = word.charAt(index);
            int charIndex = character - 'a';
            TreeNode sonNode = current.sons[charIndex];
            if (sonNode == null) {
                current.sons[charIndex] = new TreeNode();
            }
            current = current.sons[charIndex];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        TreeNode current = this.root;
        for (int index = 0; index < word.length(); index++) {
            int wordIndex = word.charAt(index) - 'a';
            if (current.sons[wordIndex] == null) {
                return false;
            }
            current = current.sons[wordIndex];
        }
        return current.isEnd == true;
    }

    public boolean startsWith(String prefix) {
        TreeNode current = this.root;
        for (int index = 0; index < prefix.length(); index++) {
            int wordIndex = prefix.charAt(index) - 'a';
            if (current.sons[wordIndex] == null) {
                return false;
            }
            current = current.sons[wordIndex];
        }
        return true;
    }
}
