package com.dropwizard.application.models;


import java.util.List;

public class Trie {
    TrieNode trieNode = new TrieNode();

    public void addToTrie(List<String> tags) {
        trieNode.addAsChildren(tags, 0);

    }

    public void removeFromTrie(List<String> tags) {
        trieNode.removeAsChildren(tags, 0);
    }

    public int getCount(List<String> tags) {
        return trieNode.getCounts(tags, 0);
    }
}
