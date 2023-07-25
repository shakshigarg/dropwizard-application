package com.dropwizard.application.models;

import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class TrieNode {
    Map<String,TrieNode> children;
    String value;
    int count;

    TrieNode(String value){
        this.value=value;
        children=new HashMap<>();
        count=0;
    }

    TrieNode(){
        children=new HashMap<>();
        count=0;
    }


    public void addAsChildren(List<String> childList, int i) {
        if (i == childList.size()) {
            this.count++;
            return;
        }
        if (!children.containsKey(childList.get(i))) {
            children.put(childList.get(i), new TrieNode(childList.get(i)));
        }
        this.count++;
        children.get(childList.get(i)).addAsChildren(childList, i + 1);
    }

    public void removeAsChildren(List<String> tags,int i) {
        if(i>tags.size()){
            return;
        }
        if(i==tags.size()){
            count--;
            return;
        }
        TrieNode node=children.get(tags.get(i));
        if(node!=null){
            node.removeAsChildren(tags,i+1);
            count--;
            if(children.get(tags.get(i)).getCount()==0){
                children.remove(tags.get(i));
            }
        }
    }

    public int getCounts(List<String> tags,int i) {
        if(i==tags.size()){
            return this.count;
        }
        if(children.containsKey(tags.get(i))){
            return children.get(tags.get(i)).getCounts(tags,i+1);
        }
        return 0;
    }

}
