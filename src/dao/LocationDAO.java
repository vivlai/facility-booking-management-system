package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Booking;
import model.Location;
import model.Person;
import util.DBUtil;

public class LocationDao {
	private static LocationDao instance;
	
	private LocationDao(){
				
	}
	
	public static LocationDao getInstance() {
		if (instance == null) instance = new LocationDao();
		return instance;
	}
	
	public void addLocation(Location location) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
        try {
        	conn = DBUtil.getConnection();
        	String query = "insert into location (name) values (?)";
            preparedStatement = conn.prepareStatement( query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString( 1, location.getLocationName() );
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
	
	public void deleteLocation(Location location) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
        try {
        	conn = DBUtil.getConnection();
        	String query = "delete from location where id=?";
            preparedStatement = conn.prepareStatement( query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt( 1, location.getId() );
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
	
	public ArrayList<Location> getAllLocations() {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		ArrayList<Location> locations = new ArrayList<Location>();
		
        try {
        	conn = DBUtil.getConnection();
        	String query = "select * from location";
            preparedStatement = conn.prepareStatement( query, Statement.RETURN_GENERATED_KEYS);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
            	int locationId = rs.getInt(1);
            	Location location = new Location( 
            			locationId, 
            			rs.getString(2)
            	);
            	locations.add(location);
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
		
        return locations;
	}
	
	public Location getLocation(int id) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
        try {
        	conn = DBUtil.getConnection();
        	String query = "select * from location where id=?";
            preparedStatement = conn.prepareStatement( query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt( 1, id );
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
            	int locationId = rs.getInt(1);
            	Location location = new Location( 
            			locationId, 
            			rs.getString(2)
            	);
            	return location;
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
}
