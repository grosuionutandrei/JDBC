package dao;

import config.DataBaseManager;
import model.Customer;
import model.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    public  Order getById(Integer id){
        Order order = new Order();
        try
                (Connection connection = DataBaseManager.getPostgreSqlDataSourceConnection();
                 Statement stmt = connection.createStatement();
                 PreparedStatement ps = connection.prepareStatement("select * from orders where id in (?)")
                ){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
                 while(rs.next()){
                     order.setNumber(rs.getString("number"));
                     order.setPlaced(rs.getDate("placed").toLocalDate());
                     order.setCustomer_id(rs.getInt("customer_id"));
                     order.setId(rs.getInt("id"));
                 }
        }catch(SQLException e){
            e.printStackTrace();
        }
           return order;
    }
    public List<Order> getAllOrders(Integer id){
        List<Order> orders = new ArrayList<>();
        try(Connection connection = DataBaseManager.getPostgreSqlDataSourceConnection();
            Statement stmt = connection.createStatement();
            PreparedStatement ps = connection.prepareStatement("select * from customers s join orders o on o.customer_id = customer_id where s.id in (?)")
        ){
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Order order = new Order();
                order.setNumber(rs.getString("number"));
                order.setPlaced(rs.getDate("placed").toLocalDate());
                order.setCustomer_id(rs.getInt("customer_id"));
                order.setId(rs.getInt("id"));
                orders.add(order);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return orders;
    }

}
