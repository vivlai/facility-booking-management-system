package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Booking;
import model.Person;
import util.DBUtil;

public class BookingDao {
	private static BookingDao instance;
	
	private BookingDao(){
				
	}
	
	public static BookingDao getInstance() {
		if (instance == null) instance = new BookingDao();
		return instance;
	}
	
	public void addBooking(Booking booking) {
		Connection conn = null;
		ArrayList<PreparedStatement> preparedStatements = new ArrayList<PreparedStatement>();
		ResultSet rs = null;
		
        try {
        	conn = DBUtil.getConnection();
        	String query = "insert into booking (startDate, endDate, locationId) values (?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement( query, Statement.RETURN_GENERATED_KEYS);
            preparedStatements.add(preparedStatement);
            preparedStatement.setTimestamp( 1, booking.getStartDate() );
            preparedStatement.setTimestamp( 2, booking.getEndDate() );
            preparedStatement.setInt( 3, booking.getLocation().getId() );
            preparedStatement.executeUpdate();
            
            // get booking id after it is added to db
            rs = preparedStatement.getGeneratedKeys();
            int bookingId = 0;
            if (rs.next()){
                bookingId = rs.getInt(1);
            }
            
            // add people to person_booking
            ArrayList<Person> persons = booking.getPersons();
            for (Person person : persons) {
            	query = "insert into person_booking (personId, bookingId) values (?,?)";
            	preparedStatement = conn.prepareStatement( query );
                preparedStatements.add(preparedStatement);
                preparedStatement.setInt( 1, person.getId() );
                preparedStatement.setInt( 2, bookingId );
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	try {
        		if (rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	
        	for (PreparedStatement preparedStatement : preparedStatements) {
	        	try {
	        		if (preparedStatement != null) preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
        	}
        	
        	try {
        		if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
        
    }
	
	public void deleteBooking(Booking booking) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
        try {
        	conn = DBUtil.getConnection();
        	String query = "delete from booking where id = ?";
            preparedStatement = conn.prepareStatement( query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt( 1, booking.getId() );
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
	
	public ArrayList<Booking> getAllBookings() {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		
        try {
        	conn = DBUtil.getConnection();
        	String query = "select * from booking";
            preparedStatement = conn.prepareStatement( query, Statement.RETURN_GENERATED_KEYS);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
            	int bookingId = rs.getInt(1);
            	Booking booking = new Booking( 
            			bookingId, 
            			rs.getTimestamp(2), 
            			rs.getTimestamp(3), 
            			PersonDao.getInstance().getPersonsByBooking(bookingId),
            			LocationDao.getInstance().getLocation( rs.getInt(4) )
            	);
            	bookings.add(booking);
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
		
        return bookings;
	}
	
	public Booking getBooking(int id) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
        try {
        	conn = DBUtil.getConnection();
        	String query = "select * from booking where id = ?";
            preparedStatement = conn.prepareStatement( query, Statement.RETURN_GENERATED_KEYS);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
            	int bookingId = rs.getInt(1);
            	Booking booking = new Booking( 
            			bookingId, 
            			rs.getTimestamp(2), 
            			rs.getTimestamp(3), 
            			PersonDao.getInstance().getPersonsByBooking(bookingId),
            			LocationDao.getInstance().getLocation( rs.getInt(4) )
            	);
            	return booking;
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
	
	public ArrayList<Booking> getBookingsByPerson(int id) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		
        try {
        	conn = DBUtil.getConnection();
        	String query = "select bookingId from person_booking where personId=?";
            preparedStatement = conn.prepareStatement( query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt( 1, id );
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
            	Booking booking = getBooking( rs.getInt(1) );
            	bookings.add(booking);
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
		
        return bookings;
	}
	
	public void updateBooking(Booking booking) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
        try {
        	conn = DBUtil.getConnection();
        	String query = "update booking set startDate=?, endDate=?, locationId=? where id=?";
            preparedStatement = conn.prepareStatement( query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setTimestamp( 1, booking.getStartDate() );
            preparedStatement.setTimestamp( 2, booking.getEndDate() );
            preparedStatement.setInt( 3, booking.getLocation().getId() );
            preparedStatement.setInt( 4, booking.getId() );
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
}
