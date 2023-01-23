package conex;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
public class BDConex {

    
    private static final BasicDataSource dataSource = new BasicDataSource();

    static {  
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");                       
        dataSource.setUrl("jdbc:mysql://localhost/tienda");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        
        dataSource.setMaxTotal(12); 
        dataSource.setMaxOpenPreparedStatements(80);  
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();         
    }    
}
