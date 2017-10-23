package com.awexa.awexa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kath on 10/16/2017.
 */

public class Family {
    private List<Child> children;
    private List<Parent> parents;
    private String familyPass;
    private List<String> child_names;

    public Family() {
        children = new ArrayList<>();
        parents = new ArrayList<>();
        child_names = new ArrayList<>();
        familyPass = "";
    }

    public Family(List<Parent> parents) {
        this.parents = parents;
        children = new ArrayList<>();
        child_names = new ArrayList<>();
        familyPass = "";
    }

    public Family(List<Parent> parents, String familyPass) {
        this.parents = parents;
        children = new ArrayList<>();
        child_names = new ArrayList<>();
        this.familyPass = familyPass;
    }

    public Family(List<Parent> parents, List<Child> children, List<String> child_names) {
        this.parents = parents;
        this.children = children;
        this.child_names = child_names;
        familyPass = "";
    }

    public Family(List<Parent> parents, List<Child> children, List<String> child_names, String familyPass) {
        this.parents = parents;
        this.children = children;
        this.child_names = child_names;
        this.familyPass = familyPass;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public String getFamilyPass() {
        return familyPass;
    }

    public void setFamilyPass(String familyPass) {
        this.familyPass = familyPass;
    }

    public List<String> getChildNames() {
        return child_names;
    }

    public void setChildNames(List<String> child_names) {
        this.child_names = child_names;
    }
}
