package inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 *Cristiano Guimarães de Carvalho Fernandes Pinheiro CB3013111
 *Patricia Jessica Santos Fernandes Pinheiro         CB3013073
 */

public class OrdersDAO {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
	
    public OrdersDAO(String jdbcURL, String jdbcUsername, String jdbcPassword){
    	this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
    
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
    
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
    
    public boolean insertOrders(Orders Orders) throws SQLException {
        String sql = "INSERT INTO orders (purch_amt, ord_date, customer_id, salesman_id) VALUES (?, ?, ?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setFloat(1, Orders.getPurch_amt());
        statement.setDate(2, Orders.getOrd_date());
        statement.setInt(3, Orders.getCustomer_id());
        statement.setInt(4, Orders.getSalesman_id());     
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    
    public List<Orders> listAllOrders() throws SQLException {
        List<Orders> listOrders = new ArrayList<>();
         
        String sql = "SELECT * FROM orders";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int ord_no = resultSet.getInt("ord_no");
            float purch_amt = resultSet.getFloat("purch_amt");
            Date ord_date=resultSet.getDate("ord_date");
            int customer_id = resultSet.getInt("customer_id");
            int salesman_id = resultSet.getInt("salesman_id");
             
            Orders orders = new Orders(ord_no, purch_amt, ord_date, customer_id, salesman_id);
            listOrders.add(orders);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listOrders;
    }
    
    public boolean deleteOrders(Orders orders) throws SQLException {
        String sql = "DELETE FROM orders where ord_no = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, orders.getOrd_no());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
    }
    
    public boolean updateOrders(Orders Orders) throws SQLException {
        String sql = "UPDATE orders SET purch_amt = ?, ord_date = ?, customer_id = ?, salesman_id = ?";
        sql += " WHERE ord_no = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setFloat(1, Orders.getPurch_amt());
        statement.setDate(2, Orders.getOrd_date());
        statement.setInt(3, Orders.getCustomer_id());
        statement.setInt(4, Orders.getSalesman_id());
        statement.setInt(5, Orders.getOrd_no());
        
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
    
    public Orders getOrders(int ord_no) throws SQLException {
        Orders orders = null;
         String sql = "SELECT * FROM orders WHERE ord_no = ?";
          
         connect();
          
         PreparedStatement statement = jdbcConnection.prepareStatement(sql);
         statement.setInt(1, ord_no);
          
         ResultSet resultSet = statement.executeQuery();
          
         if (resultSet.next()) {
             float purch_amt = resultSet.getFloat("purch_amt");
             Date ord_date = resultSet.getDate("ord_date");
             int customer_id = resultSet.getInt("customer_id");
             int salesman_id = resultSet.getInt("salesman_id");
              
             orders = new Orders(ord_no, purch_amt, ord_date, customer_id, salesman_id);
         }
          
         resultSet.close();
         statement.close();
          
         return orders;
     }

}
