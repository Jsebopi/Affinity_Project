package model;

import java.util.ArrayList;

public class DaoPerson {
	private ArrayList<Person> listPerson;

	public DaoPerson() {
		listPerson = new ArrayList<Person>();
	}
	
	

	public void setListPerson(ArrayList<Person> listPerson) {
		this.listPerson = listPerson;
	}



	public void insertPerson(Person person) {
		listPerson.add(person);
	}

	public Person getPerson(String name) {
		for (int i = 0; i < listPerson.size(); i++) {
			if (listPerson.get(i).getName().compareTo(name) == 0)
				return listPerson.get(i);

		}

		return null;
	}

	public ArrayList<Person> getListPerson() {
		return listPerson;
	}

	public int affinityReturn(Person personOne, Person personTwo) {
		int affinity = 0;
		if (personOne.getCity_Live().compareToIgnoreCase(personTwo.getCity_Live()) == 0) {
			affinity += 33;
		}
		if (personOne.getTravel().compareToIgnoreCase(personTwo.getTravel()) == 0) {
			affinity += 33;
		}
		if (personOne.getSong().compareToIgnoreCase(personTwo.getSong()) == 0) {
			affinity += 34;
		}

		return affinity;
	}

}
