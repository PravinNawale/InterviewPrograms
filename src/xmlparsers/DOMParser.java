package xmlparsers;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParser {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		parsingXML();
		creatingXML();
	}

	public static void parsingXML() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		/*
		 * StringBuilder xmlStringBuilder = new StringBuilder();
		 * xmlStringBuilder.append("<?xml version=\"1.0\"?> " + "<class> " +
		 * "<className>Java Classes" + "</className>" + "</class>");
		 * ByteArrayInputStream input = new
		 * ByteArrayInputStream(xmlStringBuilder.toString().getBytes("UTF-8")); Document
		 * document = builder.parse(input);
		 */

		File inputFile = new File("SampleXML.xml");
		Document document = builder.parse(inputFile);
		document.getDocumentElement().normalize();
		NodeList nList = document.getElementsByTagName("student");
		System.out.println("----------------------------");

		Element root = document.getDocumentElement();
		System.out.println("Root element :" + root.getNodeName());
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			System.out.println("\nCurrent Element :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				System.out.println("Student roll no : " + eElement.getAttribute("rollno"));
				System.out
						.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
				System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
				System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
				System.out.println("Marks : " + eElement.getElementsByTagName("marks").item(0).getTextContent());
			}
		}
	}

	public static void creatingXML() throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.newDocument();

		// root element
		Element rootElement = doc.createElement("cars");
		doc.appendChild(rootElement);

		// supercars element
		Element supercar = doc.createElement("supercars");
		rootElement.appendChild(supercar);

		// setting attribute to element
		Attr attr = doc.createAttribute("company");
		attr.setValue("Ferrari");
		supercar.setAttributeNode(attr);

		// carname element
		Element carname = doc.createElement("carname");
		Attr attrType = doc.createAttribute("type");
		attrType.setValue("formula one");
		carname.setAttributeNode(attrType);
		carname.appendChild(doc.createTextNode("Ferrari 101"));
		supercar.appendChild(carname);

		Element carname1 = doc.createElement("carname");
		Attr attrType1 = doc.createAttribute("type");
		attrType1.setValue("sports");
		carname1.setAttributeNode(attrType1);
		carname1.appendChild(doc.createTextNode("Ferrari 202"));
		supercar.appendChild(carname1);

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("cars.xml"));
		transformer.transform(source, result);

		// Output to console for testing
		StreamResult consoleResult = new StreamResult(System.out);
		transformer.transform(source, consoleResult);
	}
}
