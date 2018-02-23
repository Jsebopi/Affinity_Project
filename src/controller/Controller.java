package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import persisstense.ReadXML;
import model.DaoPerson;
import model.Person;
import view.Constants;
import view.JDInfo;
import view.JDNewPerson;
import view.JDViewList;
import view.JFWindow;

public class Controller implements ActionListener {
	private JFWindow jfWindow;
	private JDNewPerson jdNewPerson;
	private JDInfo jiInfo;
	private JDViewList jdViewList;
	private DaoPerson daoPerson;
	private ReadXML xml;

	public Controller() {
		xml = new ReadXML();
		jfWindow = new JFWindow(this);
		jiInfo = new JDInfo(this);
		jdNewPerson = new JDNewPerson(this);
		jdViewList = new JDViewList(this);
		daoPerson = new DaoPerson();
		initial();
		jfWindow.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		switch (a.getActionCommand()) {
		case Constants.C_AGREE_NEW_PERSON:
			jdNewPerson.setVisible(true);
			break;
		case Constants.C_AGREE_PERSON:
			if (jdNewPerson.ValidateScreen()) {
				agreePerson();

			} else
				JOptionPane.showMessageDialog(null, "Por Favor Llenar");

			break;
		case Constants.C_EXIT:
			jdViewList.dispose();
			break;
		case Constants.C_CALCULATE_AFFINITY:
			jdViewList.CountProgress(affinityResult(jdViewList.namePersonOne(),
					jdViewList.namePersonTwo()));
			break;
			
		case Constants.C_INFO:
			jiInfo.setVisible(true);
			break;
		case Constants.C_LIST_PERSON:
			jdViewList.setVisible(true);;
			break;
			
		case Constants.C_ACCEPT_INFO:
			jiInfo.dispose();
			break;
		}
	}

	public void agreePerson() {
		Person person = jdNewPerson.createPerson();
		daoPerson.insertPerson(person);
		xml.setClients(daoPerson.getListPerson());
		xml.write();
		insertComboBox(person);
		jdViewList.agreeRowPerson(person);
		jdNewPerson.setVisible(false);
		jdNewPerson.CleanScreen();
	}

	public void insertComboBox(Person person) {
		jdViewList.insertInfoCombo(person.getName());
	}

	public int affinityResult(String nameOne, String nameTwo) {
		return daoPerson.affinityReturn(daoPerson.getPerson(nameOne),
				daoPerson.getPerson(nameTwo));
	}
	
	public void initial(){
		xml.read();
		daoPerson.setListPerson(xml.getPersons());
		cargeListView(daoPerson.getListPerson());
	}
	
	public void cargeListView(ArrayList<Person> list){
		for (int i = 0; i < list.size(); i++) {
			jdViewList.agreeRowPerson(list.get(i));
			jdViewList.insertInfoCombo(list.get(i).getName());
		}		
	}
}
