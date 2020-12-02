package homework.xml;

import javax.xml.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "entries")
@XmlAccessorType(XmlAccessType.FIELD)

public class Entries {

    @XmlElement(name = "entry")
    private List<Entry> entries = null;

    public Entries() throws ParseException {
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }
}