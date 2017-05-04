package com.dataStructures.Trie;

import java.util.LinkedList;

class TrieNode implements Comparable<TrieNode>
{

    char content;
    boolean isEnd;
    int count;
    LinkedList<TrieNode> childList;

    /* Constructor */
    public TrieNode(char c)
    {

        childList = new LinkedList<TrieNode>();
        isEnd = false;
        content = c;
        count = 0;

    }

    public TrieNode subNode(char c)
    {

        if (childList != null)
            for (TrieNode eachChild : childList)
                if (eachChild.content == c)
                    return eachChild;
        return null;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrieNode)) return false;

        TrieNode trieNode = (TrieNode) o;

        if (content != trieNode.content) return false;
        if (isEnd != trieNode.isEnd) return false;
        if (count != trieNode.count) return false;
        return childList != null ? childList.equals(trieNode.childList) : trieNode.childList == null;
    }

    @Override
    public int hashCode() {
        int result = (int) content;
        result = 31 * result + (isEnd ? 1 : 0);
        result = 31 * result + count;
        result = 31 * result + (childList != null ? childList.hashCode() : 0);
        return result;
    }

    public int compareTo(TrieNode o) {

        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;

        if (this == o) return EQUAL;

        if (this.content < o.content) return BEFORE;
        if (this.content > o.content) return AFTER;

        assert this.equals(o) : "compareTo inconsistent with equals.";
        return EQUAL;

    }
}