package com.envy.candies.builder;

public enum Tag {
    NAME("name"),
    PROTEINS("proteins"),
    FATS("fats"),
    CARBOS("carbos"),
    PRODUCTION("production"),
    WATER("water"),
    SUGAR("sugar"),
    FRUCTOSE("fructose"),
    VANILLA("vanilla"),
    FLAVOUR("flavour"),
    FILLING("filling"),
    CHOCOLATEKIND("chocolateKind"),
    CANDIES("candies"),
    CARAMEL("caramel"),
    CHOCOLATE("chocolate"),
    CANDY("candy");



    private String tag;

    Tag(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }
}
