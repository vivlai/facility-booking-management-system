package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import com.mysql.jdbc.Driver;

public class DBUtil {
    
    public static Connection getConnection() {
        InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream( "/db.properties" );
        Properties properties = new Properties();
        try {
            properties.load( inputStream );
            String driver = properties.getProperty( "driver" );
            String url = properties.getProperty( "url" );
            String user = properties.getProperty( "user" );
            String password = properties.getProperty( "password" );
            Class.forName( driver );
            return DriverManager.getConnection( url, user, password );
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("io exception");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("class not found exception");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("sql exception");
        }
        
        return null;
    }
 
    public static void closeConnection( Connection toBeClosed ) {
        if( toBeClosed == null )
            return;
        try {
            toBeClosed.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
