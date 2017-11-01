package com.awexa.awexa;


import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kath on 10/16/2017.
 */

public class Family {
    private Map<String, Boolean> children;
    private Map<String, Boolean> parents;
    private String familyPass;
    private Map<String, String> child_names;

    public Family() {
        this(new HashMap<String, Boolean>(), new HashMap<String, Boolean>(), "", new HashMap<String, String>());
    }

    public Family(Map<String, Boolean> children, Map<String, Boolean> parents, String familyPass, Map<String, String> child_names) {
        this.children = children;
        this.parents = parents;
        this.familyPass = familyPass;
        this.child_names = child_names;
    }

    public Map<String, Boolean> getChildren() {
        return children;
    }

    public void setChildren(Map<String, Boolean> children) {
        this.children = children;
    }

    public Map<String, Boolean> getParents() {
        return parents;
    }

    public void setParents(Map<String, Boolean> parents) {
        this.parents = parents;
    }

    public String getFamilyPass() {
        return familyPass;
    }

    public void setFamilyPass(String familyPass) {
        this.familyPass = familyPass;
    }

    public Map<String, String> getChild_names() {
        return child_names;
    }

    public void setChild_names(Map<String, String> child_names) {
        this.child_names = child_names;
    }
}
