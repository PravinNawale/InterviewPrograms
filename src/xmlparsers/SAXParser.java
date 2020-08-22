package xmlparsers;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParser {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		File inputFile = new File("SampleXML.xml");
		SAXParserFactory factory = SAXParserFactory.newInstance();
		javax.xml.parsers.SAXParser saxParser = factory.newSAXParser();
		UserHandler userhandler = new UserHandler();
		saxParser.parse(inputFile, userhandler);
	}
}

class UserHandler extends DefaultHandler {

	   boolean bFirstName = false;
	   boolean bLastName = false;
	   boolean bNickName = false;
	   boolean bMarks = false;

	   @Override
	   public void startElement(
	      String uri, String localName, String qName, Attributes attributes)
	      throws SAXException {
	      
	      if (qName.equalsIgnoreCase("student")) {
	         String rollNo = attributes.getValue("rollno");
	         System.out.println("Roll No : " + rollNo);
	      } else if (qName.equalsIgnoreCase("firstname")) {
	         bFirstName = true;
	      } else if (qName.equalsIgnoreCase("lastname")) {
	         bLastName = true;
	      } else if (qName.equalsIgnoreCase("nickname")) {
	         bNickName = true;
	      }
	      else if (qName.equalsIgnoreCase("marks")) {
	         bMarks = true;
	      }
	   }

	   @Override
	   public void endElement(String uri, 
	      String localName, String qName) throws SAXException {
	      
	      if (qName.equalsIgnoreCase("student")) {
	         System.out.println("End Element :" + qName);
	      }
	   }

	   @Override
	   public void characters(char ch[], int start, int length) throws SAXException {

	      if (bFirstName) {
	         System.out.println("First Name: " + new String(ch, start, length));
	         bFirstName = false;
	      } else if (bLastName) {
	         System.out.println("Last Name: " + new String(ch, start, length));
	         bLastName = false;
	      } else if (bNickName) {
	         System.out.println("Nick Name: " + new String(ch, start, length));
	         bNickName = false;
	      } else if (bMarks) {
	         System.out.println("Marks: " + new String(ch, start, length));
	         bMarks = false;
	      }
	   }
	}