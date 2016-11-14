package dao;

import java.util.ArrayList;

import model.Person;

public class PersonDao {
	ArrayList<Person> persons;
	
	public PersonDao(){
		/*students = new ArrayList<Student>();
		Student student1 = new Student("Robert",0);
		Student student2 = new Student("John",1);
		students.add(student1);
		students.add(student2);*/		
	}
	
	public void deletePerson(Person person) {
		persons.remove(person.getEmail());
	}
	
	public ArrayList<Person> getAllPersons() {
		return persons;
	}
	
	public Person getPerson(String email) {
		for (Person p : persons) {
			String e = p.getEmail();
			if (e == email) {
				return p;
			}
		}
		return null;
	}
}