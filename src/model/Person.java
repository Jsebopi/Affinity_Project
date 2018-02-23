package model;

public class Person {
	private int id;
	private String name;
	private String lastName;
	private String city_Live;
	private String travel;
	private String song;
	
	
	public Person(int id, String name, String lastName, String city_Live,
			String travel, String song) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.city_Live = city_Live;
		this.travel = travel;
		this.song = song;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCity_Live() {
		return city_Live;
	}


	public void setCity_Live(String city_Live) {
		this.city_Live = city_Live;
	}


	public String getTravel() {
		return travel;
	}


	public void setTravel(String travel) {
		this.travel = travel;
	}


	public String getSong() {
		return song;
	}


	public void setSong(String song) {
		this.song = song;
	}
	


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@Override
	public String toString() {
		return  id  + name + lastName + city_Live  + travel  + song;
	}
	
	public String[] toStringVector() {
		String[] listPerson = { name, lastName,
				String.valueOf(id), city_Live,travel, song };
		return listPerson;
	}
	
	
}
