package database;

import models.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDAO extends Database implements iDAO<Product> {
    public ProductDAO() {
        getConnection();
    }
    @Override
    public ArrayList<Product> list() {
        try {
            ArrayList<Product> list = new ArrayList<>();
            String sql = "SELECT * FROM products";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price($)"));
                product.setCategoryId(rs.getInt("categoryId"));
                product.setPath(rs.getString("path"));
                list.add(product);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Product get(int id) {
        try{
            String sql = "SELECT * FROM products WHERE id = " +id;
            ResultSet rs = connection.createStatement().executeQuery(sql);
            if(rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                return product;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean remove(int id) {
        try {
            String sql = "DELETE FROM products WHERE id = " +id;
            connection.createStatement().executeUpdate(sql);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Product update(int id, Product newProduct) {
        try{
            PreparedStatement ps  = connection.prepareStatement("UPDATE products SET name = ?, price = ?, categoryId=? WHERE id = ?");
            ps.setString(1,newProduct.getName());
            ps.setDouble(2, newProduct.getPrice());
            ps.setInt(3, newProduct.getCategoryId());
            ps.setInt(4, id);
            ps.executeUpdate();

            return get(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product add(Product newProduct) {
        try{
            PreparedStatement ps = connection.prepareStatement("INSERT INTO products(name, price, categoryId) VALUES (?, ?, ?)");
            ps.setString(1,newProduct.getName());
            ps.setDouble(2, newProduct.getPrice());
            ps.setInt(3, newProduct.getCategoryId());
            ps.executeUpdate();
            return get(getLastId());
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getLastId() {

        return 0;
    }
}
