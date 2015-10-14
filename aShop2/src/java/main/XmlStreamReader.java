package main;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

import java.io.InputStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * This is a simple XML stream reader example that is fairly much self
 * contained.
 */
public class XmlStreamReader {

    private enum Element {
        BICYCLE,
        ID,
        TITLE,
        IMG,
        IMG2,
        BRAND,
        STYLE,
        FRAME,
        WHEELS,
        BRAKES,
        FORK,
        SPEEDS,
        WEIGHT,
        PRICE
    }
    private final XMLInputFactory factory;
    private final Map<String, Element> nameToTypeMapping;

    private StringBuilder currentText;
    private Element currentElement;
    
    private InputStream xmlStream;

    ArrayList<Bicycle> bicycles = new ArrayList<Bicycle>();
    //    private Bicycles bicycles;
    public int iter = 0;
    public String[] strDifferentWheel;
    
    ArrayList<String> uniqueBrand=new ArrayList();
    public int uniqueBrandCount;
    ArrayList<String> uniqueStyle=new ArrayList();
    public int uniqueStyleCount;
    ArrayList<String> uniqueWheels=new ArrayList();
    public int uniqueWheelsCount;

    String lastDifferent[];
    int countDif = 0;
    int hit=0;
    
    UniqueTo brUniqueTo;
    UniqueTo stUniqueTo;
    UniqueTo whUniqueTo;
    /**
     * Create the stream reader class and put in the mappings between
     * element names and the Element type (currentElement). This mapping
     * is used to work out how to handle each data type.
     */
    public XmlStreamReader() {
        this.nameToTypeMapping = new HashMap<String, Element>();
        factory = XMLInputFactory.newFactory();
        nameToTypeMapping.put("bicycle", Element.BICYCLE);
        nameToTypeMapping.put("id", Element.ID);
        nameToTypeMapping.put("title", Element.TITLE);
        nameToTypeMapping.put("img", Element.IMG);
        nameToTypeMapping.put("img2", Element.IMG2);
        nameToTypeMapping.put("brand", Element.BRAND);
        nameToTypeMapping.put("style", Element.STYLE);
        nameToTypeMapping.put("frame", Element.FRAME);
        nameToTypeMapping.put("wheels", Element.WHEELS);
        nameToTypeMapping.put("brakes", Element.BRAKES);
        nameToTypeMapping.put("fork", Element.FORK);
        nameToTypeMapping.put("speeds", Element.SPEEDS);
        nameToTypeMapping.put("weight", Element.WEIGHT);
        nameToTypeMapping.put("price", Element.PRICE);
    }

    /**
     * Actually performs the read operation on the XML file by repeatedly
     * calling hasNext() and next() until the document ends.
     * @param input the XML stream to read.
     * @throws XMLStreamException if the parsing fails.
     */
    public void readXml() throws XMLStreamException {
        
        try {
           xmlStream = new FileInputStream(new File("/home/huma/NetBeansProjects/Gusachenko/aShop/web/xml/listOfGoods.xml")); 
       } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
         
        // get an XML reader instance.
        XMLStreamReader xmlReader = factory.createXMLStreamReader(xmlStream);

        // before calling next() we can find out key things about the
        // document, because we would now be in XMLEvent.START_DOCUMENT
        // state.
        assert (xmlReader.getEventType() == XMLEvent.START_DOCUMENT);

        // iterate by calling hasNext in a loop until there are no more
        // elements left to process.
        while (xmlReader.hasNext()) {

            // get the next event and process it.
            int eventType = xmlReader.next();
            switch (eventType) {
            case XMLEvent.CDATA:
            case XMLEvent.SPACE:
            case XMLEvent.CHARACTERS:
                processText(xmlReader.getText());
                break;
            case XMLEvent.END_ELEMENT:
                ended(xmlReader.getLocalName());
                break;
            case XMLEvent.START_ELEMENT:
                startElement(xmlReader.getLocalName());
                int attributes = xmlReader.getAttributeCount();
                for (int i = 0; i < attributes; ++i) {
                    attribute(xmlReader.getAttributeLocalName(i), xmlReader.getAttributeValue(i));
                }
                break;
            }
        }
        


        for (int i = 0; i < iter; i++) {
            uniqueWheels.add(bicycles.get(i).wheels);
            uniqueBrand.add(bicycles.get(i).brand);
            uniqueStyle.add(bicycles.get(i).style);
       }
        
        brUniqueTo=removeDuplicates(uniqueBrand);
        stUniqueTo=removeDuplicates(uniqueStyle);
        whUniqueTo=removeDuplicates(uniqueWheels);
       
        
//        uniqueBrand = removeDuplicates(uniqueBrand);
        uniqueBrandCount=brUniqueTo.uniqueCounts;
        uniqueStyleCount=brUniqueTo.uniqueCounts; 
//        uniqueWheels = removeDuplicates(uniqueWheels);
        uniqueWheelsCount=whUniqueTo.uniqueCounts;
//	for (String element : uniqueWheels) {
//	    System.out.println(element);
//	} 
    }

public class UniqueTo{
    ArrayList<String> list=new ArrayList();
    public int uniqueCounts;
    public UniqueTo(ArrayList<String> list_){
        list=list_;
        uniqueCounts=list.size();
    }
    
}

    public UniqueTo removeDuplicates(ArrayList<String> list) {

            // Store unique items in result.
            ArrayList<String> result = new ArrayList<String>();

            // Record encountered Strings in HashSet.
            HashSet<String> set = new HashSet<String>();

            // Loop over argument list.
            for (String item : list) {

                // If String is not in set, add it to the list and the set.
                if (!set.contains(item)) {
                    result.add(item);
                    set.add(item);
                }
            }
            return new UniqueTo(result);
        }





    /**
     * Handles the start of a new XML element, so we can prepare for the new
     * element. In our case we clear down the text storage and set the element
     * type field.
     * @param localName the name of the element without namespace
     */
    private void startElement(String localName) {
        currentElement = nameToTypeMapping.get(localName);
        currentText = new StringBuilder(256);
        if (currentElement == Element.BICYCLE) {
            bicycles.add(new Bicycle());
        }
    }
    

    /**
     * Called when text is found within the element, this may be whitespace,
     * text or CDATA.
     * @param text the text to be added to the current elements data.
     */
    private void processText(String text) {
        if (currentElement != null && currentText != null) {
            currentText.append(text);
        }
    }

    /**
     * Called for each attribute in the start element call. With the name and
     * value.
     * @param localName the name of the attribute
     * @param value the value of the attribute
     */
    private void attribute(String localName, String value) {
        if (currentElement == Element.BICYCLE && localName.equals("id")) {
            bicycles.get(iter).setId(value);

        }
    }

    /**
     * Called each time an element ends, with the name of the element that
     * has just ended.
     * @param localName the element name that has ended
     */
    private void ended(String localName) {
        // find the element type, and see if we can process it.
        currentElement = nameToTypeMapping.get(localName);
        if (currentElement != null) {

            // We can process the element, so perform the right function.
            // In a real world example, the "currentElement" type may be
            // more complex and have functionality to perform the action.
            switch (currentElement) {
            case ID:
                bicycles.get(iter).setId(currentText.toString());
                break;
            case TITLE:
                bicycles.get(iter).setTitle(currentText.toString());
                break;
            case IMG:
                bicycles.get(iter).setImg(currentText.toString());
                break;
            case IMG2:
                    bicycles.get(iter).setImg2(currentText.toString());
                    break;
            case BRAND:
                    bicycles.get(iter).setBrand(currentText.toString());
                    break;
            case STYLE:
                bicycles.get(iter).setStyle(currentText.toString());
                break;
            case FRAME:
                bicycles.get(iter).setFrame(currentText.toString());
                break;
            case WHEELS:
                bicycles.get(iter).setWheels(currentText.toString());
                break;
            case BRAKES:
                bicycles.get(iter).setBrakes(currentText.toString());
                break;
            case FORK:
                bicycles.get(iter).setFork(currentText.toString());
                break;
            case SPEEDS:
                bicycles.get(iter).setSpeeds(currentText.toString());
                break;
            case WEIGHT:
                bicycles.get(iter).setWeight(currentText.toString());
                break;
            case PRICE:
                bicycles.get(iter).setPrice(currentText.toString());
                break;


            case BICYCLE:
                renderBicycle();
            }

            currentElement = null;
            currentText = null;
        }
    }

    /**
     * Renders an Animal instance onto the console.
     */
    private void renderBicycle() {
        //        System.out.println("getId: id=" + bicycles.get(iter).getId());
        //        System.out.println("  getTitle=" + bicycles.get(iter).getTitle());
        //        System.out.println("  getImg=" + bicycles.get(iter).getImg());
        //        System.out.println("  getPrice=" + bicycles.get(iter).getPrice());
        iter++;
    }


    public String getId(int iter) {
        return bicycles.get(iter).getId();
    }

    public String getTitle(int iter) {
        return bicycles.get(iter).getTitle();
    }

    public String getImg(int iter) {
        return bicycles.get(iter).getImg();
    }
    public String getImg2(int iter) {
        return bicycles.get(iter).getImg2();
    }
    
    public String getBrand(int iter) {
        return bicycles.get(iter).getBrand();
    }

    public String getStyle(int iter) {
        return bicycles.get(iter).getStyle();
    }

    public String getFrame(int iter) {
        return bicycles.get(iter).getFrame();
    }

    public String getWheels(int iter) {
        return bicycles.get(iter).getWheels();
    }

    public String getBrakes(int iter) {
        return bicycles.get(iter).getBrakes();
    }

    public String getFork(int iter) {
        return bicycles.get(iter).getFork();
    }

    public String getSpeeds(int iter) {
        return bicycles.get(iter).getSpeeds();
    }

    public String getWeight(int iter) {
        return bicycles.get(iter).getWeight();
    }

    public String getPrice(int iter) {
        return bicycles.get(iter).getPrice();
    }
    
    
    
    public String getUniqueBrand(int iter) {
        
        return brUniqueTo.list.get(iter);
    }
    public String getUniqueStyle(int iter) {
        
        return stUniqueTo.list.get(iter);
    }
    
    public String getUniqueWheels(int iter) {
        return whUniqueTo.list.get(iter);
    }
    //
    //    public static void main(String[] args) throws XMLStreamException {
    //        InputStream xmlStream = XmlStreamReader.class.getResourceAsStream("/example.xml");
    //        XmlStreamReader reader = new XmlStreamReader();
    //        reader.readXml(xmlStream);
    //    }
}
