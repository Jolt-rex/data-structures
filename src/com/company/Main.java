package com.company;

public class Main {

    public static void main(String[] args) {
        var trie = new Trie();

        trie.insert("care");
        trie.insert("car");
        trie.insert("cart");
        trie.insert("cartage");
        trie.insert("caramel");
        trie.insert("cad");

        var words = trie.findWords("cart");

        System.out.println(words);
    }
}
