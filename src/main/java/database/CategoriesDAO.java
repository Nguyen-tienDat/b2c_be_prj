package database;

import jakarta.servlet.http.HttpServlet;
import models.Categories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoriesDAO extends Database implements iDAO<Categories> {

    public CategoriesDAO(){
        //open connection to DB
        getConnection();
    }
    //method: ArrayList<Categories> list
    //use to get the table in asc position
    //convert each db row into an object
    public ArrayList<Categories> list() {
        try{
            ArrayList<Categories> list = new ArrayList<>();
            String sql = "SELECT * FROM categories";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            while (rs.next()) {
                /* moves the pointer to the next row in the result set and return true if there is another row*/
                Categories c = new Categories();
                c.setId(rs.getInt("id"));
                c.setName((rs.getString("name")));
                list.add(c);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    //method: get
    // design to retrieve an object in Categories table by using its id
    public Categories get(int id) {
        try{
            String sql = "SELECT * FROM categories WHERE id = "+id;
            ResultSet rs = connection.createStatement().executeQuery(sql);
            if(rs.next()){
  //check if the rs contains at least 1 row -> move to the next row and return true if there is a row available
                Categories c = new Categories();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                return c;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    /*method: remove
    * design for removing an object by using id
    * note: executeQuery -> executeUpdate
    * */
    public boolean remove(int id) {
        try{
            String sql = "DELETE FROM categories WHERE id = "+id;
            connection.createStatement().executeUpdate(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
    * method update
    * update existing Categories table including new data added
     * */
    @Override
    public Categories update(int id, Categories newCategories) {
        try{
            PreparedStatement ps = connection.prepareStatement("UPDATE categories SET name = ? WHERE id = ?");
            //set value for "?" in SQL query
            ps.setString(1, newCategories.getName());
            ps.setInt(2, id);
            ps.executeUpdate();

            //object after updating
            return get(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
/*
*method : add
* use to insert a new category into the existed table
* */
    @Override
    public Categories add(Categories newCategories) {
        try{
            PreparedStatement ps = connection.prepareStatement("INSERT INTO categories (name) VALUES (?)");
            ps.setString(1, newCategories.getName());
            ps.executeUpdate();
            return get(getLastId()); //retrieve the ID of the last inserted category
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    /*
    * method : getLastId
    * retrieves the highest id in the categoies*/
    public int getLastId() {
        try{
            String sql = "SELECT MAX(id) FROM categories";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            if(rs.next()){
                return rs.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
