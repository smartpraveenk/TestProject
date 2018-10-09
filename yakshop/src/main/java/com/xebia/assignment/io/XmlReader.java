package com.xebia.assignment.io;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import com.xebia.assignment.model.Animal;
import com.xebia.assignment.model.LabYak;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XmlReader {
	private File xmlInput;
	private List<Animal> yakList;

	public XmlReader(File xmlInput) {
		this.xmlInput = xmlInput;

	}

	/**
	 * @return
	 */
	public List<Animal> read() {
		yakList = new ArrayList<Animal>();
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlInput);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("labyak");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					String name = eElement.getAttribute("name");
					float age = Float.parseFloat(eElement.getAttribute("age"));
					String sex = eElement.getAttribute("sex");
					LabYak.Sex yakSex = (sex.equalsIgnoreCase("f")) ? LabYak.Sex.FEMALE
							: LabYak.Sex.MALE;
					yakList.add(new LabYak(temp, name, age, yakSex));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return yakList;
	}
}
