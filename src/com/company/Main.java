package com.company;

public class Main {

    public static void main(String[] args) {
        var trie = new Trie();

        trie.insert("care");
        trie.insert("car");

        trie.remove("care");
        System.out.println(trie.contains("care"));
        System.out.println(trie.contains("car"));
    }
}
