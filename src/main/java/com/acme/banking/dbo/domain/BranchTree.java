package com.acme.banking.dbo.domain;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;


public class BranchTree implements BranchInterface{

    Collection<BranchInterface> childrens = new ArrayList<>();
    private String name;

    public BranchTree(String name) {
        this.name = name;

    }

    public String getName() {
        return this.name;
    }

    @Override
    public ArrayList<Account> getAccounts() {
        return null;
    }

    public ArrayList<BranchInterface> getChildrens() {
        return  new ArrayList<>(childrens);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BranchTree that = (BranchTree) o;
        return Objects.equals(childrens, that.childrens) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(childrens, name);
    }

    public void add(BranchInterface childrenNode) {
        childrens.add(childrenNode);
    }
}
