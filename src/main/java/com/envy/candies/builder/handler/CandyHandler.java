package com.envy.candies.builder.handler;

import com.envy.candies.builder.Tag;
import com.envy.candies.entity.Candy;
import com.envy.candies.entity.Caramel;
import com.envy.candies.entity.Chocolate;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class CandyHandler extends DefaultHandler {
    private Set<Candy> candies;
    private Candy parsingCandy;
    private EnumSet<Tag> tags;
    private Tag curTag;

    public CandyHandler() {
        candies = new HashSet<Candy>();
        tags = EnumSet.range(Tag.NAME, Tag.CHOCOLATEKIND);
    }

    public Set<Candy> getCandies() {
        return candies;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (localName.equals(Tag.CHOCOLATE.getTag())) {
            parsingCandy = new Chocolate();
        } else if(localName.equals(Tag.CARAMEL.getTag())) {
            parsingCandy = new Caramel();
        } else {
            Tag tag = Tag.valueOf(localName.toUpperCase());
            curTag = tags.contains(tag)? tag : null;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equals(Tag.CHOCOLATE.getTag()) || localName.equals(Tag.CARAMEL.getTag())) {
            candies.add(parsingCandy);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length).trim();
        if (curTag != null) {
            switch (curTag) {
                case NAME:
                    parsingCandy.setName(data);
                    break;
                case PROTEINS:
                    parsingCandy.setProteins(Double.parseDouble(data));
                    break;
                case FATS:
                    parsingCandy.setFats(Double.parseDouble(data));
                    break;
                case CARBOS:
                    parsingCandy.setCarbos(Double.parseDouble(data));
                    break;
                case PRODUCTION:
                    parsingCandy.setProduction(data);
                    break;
                case WATER:
                    parsingCandy.setWater(Double.parseDouble(data));
                    break;
                case SUGAR:
                    parsingCandy.setSugar(Double.parseDouble(data));
                    break;
                case FRUCTOSE:
                    parsingCandy.setFructose(Double.parseDouble(data));
                    break;
                case VANILLA:
                    parsingCandy.setVanilla(Double.parseDouble(data));
                    break;
                case FLAVOUR:
                    ((Caramel)parsingCandy).setFlavour(data);
                    break;
                case FILLING:
                    ((Chocolate)parsingCandy).setFilling(Boolean.parseBoolean(data));
                    break;
                case CHOCOLATEKIND:
                    ((Chocolate)parsingCandy).setChocolateKind(data);
                    break;
            }
        }
        curTag = null;
    }
}
