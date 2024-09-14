package database;

import models.CartItem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderDAO extends Database {
    public OrderDAO() {
        getConnection();

    }

    public class Status{
        public static final int PENDING = 0;
        public static final int SHIPPED = 1;
        public static final int COMPLETED = 2;
        public static final int CANCELLED = 3;
    }

    public int insertOrder(String name, String phone, String address, String note, float subTotal, float total){
        try {
            String sql = "insert into orders (full_name, phone, address, note, subtotal, total, tax, ship_fee, status) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, address);
            ps.setString(4, note);
            ps.setFloat(5, subTotal);
            ps.setFloat(6, total);
            ps.setFloat(7, total*10/100);
            ps.setFloat(8, 0);
            ps.setInt(9,Status.PENDING);
            ps.executeUpdate();

            //get order id
            return getLastId();
        }
        catch(Exception e){
                e.printStackTrace();
            }
        return -1;
    }

    public int getLastId(){
        try{
            String sql = "select max(id) from orders";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public boolean insertDetail(CartItem cartItem, int orderId){
        try{
            String sql = "insert into product_orders (order_id, product_id, quantity, price, name, total) values (?,?,?,?,?,?)";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, orderId);
            ps.setInt(2, cartItem.getProduct().getId());
            ps.setInt(3, cartItem.getQuantity());
            ps.setDouble(4, cartItem.getProduct().getPrice());
            ps.setString(5, cartItem.getProduct().getName());
            ps.setDouble(6, cartItem.getProduct().getPrice() *cartItem.getQuantity());
            ps.executeUpdate();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
