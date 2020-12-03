package homework.xml;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XslTransform {
    public static void Transforming() throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File("src/main/java/homework/model/1a.xsl"));
        Transformer transformer = factory.newTransformer(xslt);
        Source xml = new StreamSource(new File("src/main/java/homework/model/1.xml"));
        transformer.transform(xml, new StreamResult(new File("src/main/java/homework/model/2.xml")));
    }
}