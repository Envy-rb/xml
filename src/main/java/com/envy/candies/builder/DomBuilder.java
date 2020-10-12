package com.envy.candies.builder;

import com.envy.candies.entity.Candy;
import com.envy.candies.entity.Caramel;
import com.envy.candies.entity.Chocolate;
import com.envy.candies.exception.ProjectException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;

public class DomBuilder extends AbstractBuilder{
    private DocumentBuilder documentBuilder;

    public DomBuilder() throws ProjectException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new ProjectException("Dom builder error", e);
        }
    }

    @Override
    public void setCandiesFromFile(String filename) throws ProjectException {
        try {
            Document document = documentBuilder.parse(filename);
            Element root = document.getDocumentElement();
            NodeList candiesList = root.getChildNodes();
            for (int i = 0; i < candiesList.getLength(); i++) {
                if (candiesList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) candiesList.item(i);
                    Candy candy = buildCandy(element);
                    candies.add(candy);
                }
            }
        } catch (SAXException | IOException | ParseException e) {
            throw new ProjectException("Parsing error", e);
        }
    }

    private String getElementByTagName(Element element, String tag) {
        NodeList nodeList = element.getElementsByTagName(tag);
        Element targetElement = (Element) nodeList.item(0);

        return targetElement.getTextContent();
    }

    private Candy buildCandy(Element element) throws ParseException {
        Candy candy = null;

        if (element.getTagName().equals(Tag.CARAMEL.getTag())) {
            candy = buildCaramel(element);
        } else if (element.getTagName().equals(Tag.CHOCOLATE.getTag())) {
            candy = buildChocolate(element);
        }
        candy.setVanilla(Double.parseDouble(getElementByTagName(element, Tag.VANILLA.getTag())));
        candy.setFructose(Double.parseDouble(getElementByTagName(element, Tag.FRUCTOSE.getTag())));
        candy.setSugar(Double.parseDouble(getElementByTagName(element, Tag.SUGAR.getTag())));
        candy.setWater(Double.parseDouble(getElementByTagName(element, Tag.WATER.getTag())));
        candy.setProduction(getElementByTagName(element, Tag.PRODUCTION.getTag()));
        candy.setCarbos(Double.parseDouble(getElementByTagName(element, Tag.CARBOS.getTag())));
        candy.setFats(Double.parseDouble(getElementByTagName(element, Tag.FATS.getTag())));
        candy.setProteins(Double.parseDouble(getElementByTagName(element, Tag.PROTEINS.getTag())));
        candy.setName(getElementByTagName(element, Tag.NAME.getTag()));
        return candy;
    }

    private Candy buildChocolate(Element element) {
        Chocolate chocolate = new Chocolate();

        chocolate.setChocolateKind(getElementByTagName(element, Tag.CHOCOLATEKIND.getTag()));
        chocolate.setFilling(Boolean.parseBoolean(getElementByTagName(element, Tag.FILLING.getTag())));

        return chocolate;
    }

    private Caramel buildCaramel(Element element) throws ParseException {
        Caramel caramel = new Caramel();

        caramel.setFlavour(getElementByTagName(element, Tag.FLAVOUR.getTag()));

        return caramel;
    }
}
