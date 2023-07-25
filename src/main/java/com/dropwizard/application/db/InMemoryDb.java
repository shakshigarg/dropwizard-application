package com.dropwizard.application.db;

import com.dropwizard.application.models.Entity;
import com.dropwizard.application.models.Trie;
import com.dropwizard.application.models.TrieNode;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDb {
    Map<Integer, Entity> entityMap;
    Trie trie;
    private static final InMemoryDb INSTANCE = new InMemoryDb();

    private InMemoryDb() {
        entityMap = new HashMap<>();
        trie = new Trie();
    }

    public static InMemoryDb getInstance() {
        return INSTANCE;
    }

    public Map<Integer, Entity> getEntityMap() {
        return entityMap;
    }

    public Trie getTrie() {
        return trie;
    }
}
