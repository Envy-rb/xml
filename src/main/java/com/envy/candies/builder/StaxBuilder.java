package com.envy.candies.builder;

import com.envy.candies.builder.AbstractBuilder;
import com.envy.candies.builder.Tag;
import com.envy.candies.entity.Candy;
import com.envy.candies.entity.Caramel;
import com.envy.candies.entity.Chocolate;
import com.envy.candies.exception.ProjectException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StaxBuilder extends AbstractBuilder {
    private XMLInputFactory inputFactory;

    public StaxBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public void setCandiesFromFile(String filename) throws ProjectException {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filename);
            XMLStreamReader xmlReader = inputFactory.createXMLStreamReader(inputStream);

            while (xmlReader.hasNext()) {
                if (xmlReader.next() == XMLStreamConstants.START_ELEMENT) {
                    if (xmlReader.getLocalName().equals(Tag.CANDY.getTag())
                            || xmlReader.getLocalName().equals(Tag.CHOCOLATE.getTag())) {
                        Candy candy = buildCandy(xmlReader);
                        candies.add(candy);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Candy buildCandy(XMLStreamReader xmlReader) throws XMLStreamException {
        Candy candy = null;
        
        if (xmlReader.getLocalName().equals(Tag.CARAMEL)) {
            candy = new Caramel();
        } else if (xmlReader.getLocalName().equals(Tag.CHOCOLATE)) {
            candy = new Chocolate();
        }
        
        if (candy != null) {
            while (xmlReader.hasNext()) {
                int type = xmlReader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    String elementTag = xmlReader.getLocalName().toUpperCase();
                    switch (Tag.valueOf(elementTag)) {
                        case NAME:
                            candy.setName(xmlReader.getElementText());
                            break;
                        case PROTEINS:
                            candy.setProteins(Double.parseDouble(xmlReader.getElementText()));
                            break;
                        case FATS:
                            candy.setFats(Double.parseDouble(xmlReader.getElementText()));
                            break;
                        case CARBOS:
                            candy.setCarbos(Double.parseDouble(xmlReader.getElementText()));
                            break;
                        case PRODUCTION:
                            candy.setProduction(xmlReader.getElementText());
                            break;
                        case WATER:
                            candy.setWater(Double.parseDouble(xmlReader.getElementText()));
                            break;
                        case SUGAR:
                            candy.setSugar(Double.parseDouble(xmlReader.getElementText()));
                            break;
                        case FRUCTOSE:
                            candy.setFructose(Double.parseDouble(xmlReader.getElementText()));
                            break;
                        case VANILLA:
                            candy.setVanilla(Double.parseDouble(xmlReader.getElementText()));
                            break;
                        case FLAVOUR:
                            ((Caramel)candy).setFlavour(xmlReader.getElementText());
                            break;
                        case FILLING:
                            ((Chocolate)candy).setFilling(Boolean.parseBoolean(xmlReader.getElementText()));
                            break;
                        case CHOCOLATEKIND:
                            ((Chocolate)candy).setChocolateKind(xmlReader.getElementText());
                            break;
                    }
                }
                if (type == XMLStreamConstants.END_ELEMENT) {
                    if (xmlReader.getLocalName().equals(Tag.CHOCOLATE.getTag())
                            || xmlReader.getLocalName().equals(Tag.CARAMEL.getTag())) {
                        break;
                    }
                }
            }
        }
        
        return candy;
    }
}
