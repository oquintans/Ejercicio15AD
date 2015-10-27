/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlpruebaleer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author oracle
 */
public class XMLpruebaLeer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // FLUJO DE LECTURA
            XMLStreamReader sr = XMLInputFactory.newInstance().createXMLStreamReader(new FileInputStream("autores.xml"));

            while (sr.hasNext()) {
                sr.next();

                if (sr.getEventType() == XMLStreamConstants.START_ELEMENT) {

                    String nomLA = sr.getAttributeLocalName(0);
                    String nomA = sr.getAttributeValue(0);
                    if (nomLA != null && nomA != null) {
                        System.out.print("<" + sr.getLocalName() + " " + nomLA + "=" + '"' + nomA + '"' + ">");
                    } else {
                        System.out.print("<" + sr.getLocalName() + ">");
                    }
                } else if (sr.getEventType() == XMLStreamConstants.CHARACTERS) {
                    System.out.print(sr.getText());
                } else if (sr.getEventType() == XMLStreamConstants.END_ELEMENT) {
                    System.out.print("</" + sr.getLocalName() + ">");
                }
            }

            sr.close();

        } catch (FileNotFoundException | XMLStreamException ex) {
            Logger.getLogger(XMLpruebaLeer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
