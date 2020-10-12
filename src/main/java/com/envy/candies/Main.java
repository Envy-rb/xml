package com.envy.candies;

import com.envy.candies.builder.AbstractBuilder;
import com.envy.candies.builder.DomBuilder;
import com.envy.candies.builder.SaxBuilder;
import com.envy.candies.builder.StaxBuilder;
import com.envy.candies.entity.Candy;
import com.envy.candies.exception.ProjectException;

import java.util.Set;

public class Main {
    public static void main(String[] args) throws ProjectException {
        AbstractBuilder builderSax = new SaxBuilder();
        AbstractBuilder builderStax = new StaxBuilder();
        AbstractBuilder builderDom = new DomBuilder();
        builderSax.setCandiesFromFile("data/cand.xml");
        Set<Candy> candiesSax = builderSax.getCandies();
        Set<Candy> candiesStax = builderStax.getCandies();
        Set<Candy> candiesDom = builderDom.getCandies();
        for(Candy candy : candiesDom){
            System.out.println(candy.toString());
        }
        for(Candy candy : candiesStax){
            System.out.println(candy.toString());
        }
        for(Candy candy : candiesSax){
            System.out.println(candy.toString());
        }
    }
}
