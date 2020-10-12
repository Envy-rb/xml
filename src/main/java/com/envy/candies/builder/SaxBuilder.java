package com.envy.candies.builder;

import com.envy.candies.builder.handler.CandyHandler;

import com.envy.candies.entity.Candy;
import com.envy.candies.exception.ProjectException;
import org.apache.xerces.parsers.SAXParser;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.HashSet;

public class SaxBuilder extends AbstractBuilder{
    private CandyHandler handler;
    private SAXParser saxParser;

    public SaxBuilder() {
        handler = new CandyHandler();
        saxParser = new SAXParser();
        candies = new HashSet<Candy>();
        saxParser.setContentHandler(handler);
    }

    public void setCandiesFromFile(String filename) throws ProjectException {
        try {
            saxParser.parse(filename);
            candies = handler.getCandies();
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
