package homework.xml;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Parser {

    public static void parrsing() throws IOException, SAXException, ParserConfigurationException {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder  = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse("src/main/java/homework/model/2.xml");
        NodeList nodeList = document.getElementsByTagName("entry");
        long sum = 0;
        for(int i = 0; i < nodeList.getLength(); i++) {
            String field = nodeList.item(i).getAttributes().getNamedItem("field").getNodeValue();
            sum += Integer.parseInt(field);
        }
        System.out.println("Arithmetic sum of all field attributes: " + sum);


    }
}
