package com.mygdx.game.Core;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by matthewelbing on 21.02.17.
 */
public class ResourceFetcher { //If null is returned the string does not exist
    public static String getString(String key) {
    try

    {
        File stringsXml = new File(System.getProperty("user.dir") + File.separator + "core" + File.separator + "assets" + File.separator + "strings.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        org.w3c.dom.Document stringsXmlDoc = documentBuilder.parse(stringsXml);
        stringsXmlDoc.getDocumentElement().normalize();

        NodeList nodeList = stringsXmlDoc.getElementsByTagName("strings");

        for (int i = 0; i < nodeList.getLength(); i++) {
            org.w3c.dom.Node n = nodeList.item(i);

            if (n.getNodeType() == n.ELEMENT_NODE){
                Element element = (Element) n;
                if (element.getElementsByTagName(key).item(0).getTextContent() != null)
                    return element.getElementsByTagName(key).item(0).getTextContent();
            }
        }
    }
    catch (Exception e){
        e.printStackTrace();
    }
    return null;
    }
}
