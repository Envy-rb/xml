package com.envy.candies.builder;

import com.envy.candies.entity.Candy;
import com.envy.candies.exception.ProjectException;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractBuilder {
    protected Set<Candy> candies;

    public AbstractBuilder() {
        candies = new HashSet<Candy>();
    }

    public Set<Candy> getCandies() {
        return candies;
    }

    public abstract void setCandiesFromFile(String filename) throws ProjectException;

}
