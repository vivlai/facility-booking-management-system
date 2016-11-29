package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Booking;
import model.Person;
import util.DBUtil;

public class PersonDao {
	private static PersonDao instance;
	
	private PersonDao(){
				
	}
	
	public static PersonDao getInstance() {
		if (instance == null) instance = new PersonDao();
		return instance;
	}
	
	public void addPerson(Person person) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
        try {
        	conn = DBUtil.getConnection();
        	String query = "insert into person (email, password, role) values (?,?,?)";
            preparedStatement = conn.prepareStatement( query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString( 1, person.getEmail() );
            preparedStatement.setString( 2, person.getPassword() );
            preparedStatement.setString( 3, person.getRole() );
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	try {
        		if (preparedStatement != null) preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	
        	try {
        		if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
    }
	
	public void deletePerson(Person person) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
        try {
        	conn = DBUtil.getConnection();
        	String query = "delete from person where id = ?";
            preparedStatement = conn.prepareStatement( query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt( 1, person.getId() );
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	try {
        		if (preparedStatement != null) preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	
        	try {
        		if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
	}
	
	public ArrayList<Person> getAllPersons() {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		ArrayList<Person> persons = new ArrayList<Person>();
		
        try {
        	conn = DBUtil.getConnection();
        	String query = "select * from person";
            preparedStatement = conn.prepareStatement( query, Statement.RETURN_GENERATED_KEYS);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
            	int personId = rs.getInt(1);
            	Person person = new Person( 
            			personId, 
            			rs.getString(2), 
            			rs.getString(3), 
            			rs.getString(4), 
            			BookingDao.getInstance().getBookingsByPerson(personId)
            	);
            	persons.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	try {
        		if (rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	
        	try {
        		if (preparedStatement != null) preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	
        	try {
        		if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
		
        return persons;
	}
	
	public Person getPerson(String email) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
        try {
        	conn = DBUtil.getConnection();
        	String query = "select * from person where email = ?";
            preparedStatement = conn.prepareStatement( query, Statement.RETURN_GENERATED_KEYS);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
            	int personId = rs.getInt(1);
            	Person person = new Person( 
            			personId, 
            			rs.getString(2), 
            			rs.getString(3), 
            			rs.getString(4), 
            			BookingDao.getInstance().getBookingsByPerson(personId)
            	);
            	return person;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	try {
        		if (rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	
        	try {
        		if (preparedStatement != null) preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	
        	try {
        		if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
		
        return null;
	}
	
	public ArrayList<Person> getPersonsByBooking(int id) {
		
		return null;
	}

}