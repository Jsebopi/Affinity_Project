package persisstense;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import model.Person;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXML {

	private ArrayList<Person> listFPerson;

	public ReadXML() {
		listFPerson = new ArrayList<Person>();
	}

	public void read() {
		try {

			File fXmlFile = new File("file\\listPerson.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("PERSON");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					Person cliente = new Person(Integer.parseInt(eElement
							.getElementsByTagName("id").item(0)
							.getTextContent()), eElement
							.getElementsByTagName("name").item(0)
							.getTextContent(), eElement
							.getElementsByTagName("lastName").item(0)
							.getTextContent(), eElement
							.getElementsByTagName("city_live").item(0)
							.getTextContent(), eElement
							.getElementsByTagName("travel").item(0)
							.getTextContent(), eElement
							.getElementsByTagName("song").item(0)
							.getTextContent());
					listFPerson.add(cliente);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void write() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// LIST elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("LISTPERSON");
			doc.appendChild(rootElement);

			// Person elements
			for (int i = 0; i < listFPerson.size(); i++) {

				Element person = doc.createElement("PERSON");
				rootElement.appendChild(person);

				Element id = doc.createElement("id");
				id.appendChild(doc.createTextNode(String.valueOf(listFPerson
						.get(i).getId())));
				person.appendChild(id);

				Element name = doc.createElement("name");
				name.appendChild(doc.createTextNode(listFPerson.get(i)
						.getName()));
				person.appendChild(name);

				Element lastName = doc.createElement("lastName");
				lastName.appendChild(doc.createTextNode(listFPerson.get(i)
						.getLastName()));
				person.appendChild(lastName);

				Element city_live = doc.createElement("city_live");
				city_live.appendChild(doc.createTextNode(listFPerson.get(i)
						.getCity_Live()));
				person.appendChild(city_live);

				Element travel = doc.createElement("travel");
				travel.appendChild(doc.createTextNode(listFPerson.get(i)
						.getTravel()));
				person.appendChild(travel);

				Element song = doc.createElement("song");
				song.appendChild(doc.createTextNode(listFPerson.get(i)
						.getSong()));
				person.appendChild(song);

			}
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(
					"file/listPerson.xml"));


			transformer.transform(source, result);

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}

	}

	public void setClients(ArrayList<Person> persons) {
		this.listFPerson = persons;

	}

	public ArrayList<Person> getPersons() {
		return listFPerson;
	}
}
