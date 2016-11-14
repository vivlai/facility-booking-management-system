package dao;

import java.util.ArrayList;

import model.Location;

public class LocationDao {
	ArrayList<Location> locations;
	
	public LocationDao(){
		/*students = new ArrayList<Student>();
		Student student1 = new Student("Robert",0);
		Student student2 = new Student("John",1);
		students.add(student1);
		students.add(student2);*/		
	}
	
	public void deleteLocation(Location locationName) {
		locations.remove(locationName.getLocationName());
	}
	
	public ArrayList<Location> getAllLocations() {
		return locations;
	}
	
	public Location getLocation(String locationName) {
		for (Location l : locations) {
			String ln = l.getLocationName();
			if (ln == locationName) {
				return l;
			}
		}
		return null;
	}
}
