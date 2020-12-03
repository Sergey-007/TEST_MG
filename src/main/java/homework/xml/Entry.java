package homework.xml;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "entry")
@XmlAccessorType(XmlAccessType.FIELD)
public class Entry {

    private Integer field;

    public Integer getField() {
        return field;
    }

    public void setField(Integer field) {
        this.field = field;
    }

}