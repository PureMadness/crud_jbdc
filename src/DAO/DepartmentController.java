package DAO;

import Entity.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentController extends AbstractController<Department> {

    @Override
    public List<Department> getAll() {
        String sql = "SELECT `id`, `name`, `faculty` FROM `department`";
        Connection c = null;
        PreparedStatement p = null;
        ResultSet r = null;
        try {
            c = Connect.getConnection();
            p = c.prepareCall(sql);
            r = p.executeQuery();
            ArrayList<Department> list = new ArrayList<>();
            while(r.next()) {
                Department object = new Department();
                object.setId(r.getInt("id"));
                object.setName(r.getString("name"));
                object.setFaculty(r.getString("faculty"));
                list.add(object);
            }
            return list;
        } catch(SQLException e) {
           e.printStackTrace();
        } finally {
            try {
                r.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                p.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
        return null;
    }

    @Override
    public void update(Department entity) {
        String sql = "UPDATE `department` SET "
                + "`name` = ?, `faculty` = ? "
                + "WHERE `id` = ?";
        Connection c = null;
        PreparedStatement p = null;
        try {
            c = Connect.getConnection();
            p = c.prepareStatement(sql);
            p.setString(1, entity.getName());
            p.setString(2, entity.getFaculty());
            p.setLong(3, entity.getId());
            p.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            try {
                p.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    @Override
    public Department getEntityById(long id) {
        String sql = "SELECT `name`, `faculty` FROM `department`" +
                     "WHERE `id` = ?";
        Connection c = null;
        PreparedStatement p = null;
        ResultSet r = null;
        try {
            c = Connect.getConnection();
            p = c.prepareStatement(sql);
            p.setLong(1, id);
            r = p.executeQuery();
            Department object = new Department();
            if(r.next()){
                object.setId(id);
                object.setName(r.getString("name"));
                object.setFaculty(r.getString("faculty"));
            }
            return object;
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                r.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                p.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
        return null;
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM `department` WHERE `id` = ?";
        Connection c = null;
        PreparedStatement p = null;
        try {
            c = Connect.getConnection();
            p = c.prepareStatement(sql);
            p.setLong(1, id);
            p.execute();
        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            try {
                p.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    @Override
    public void create(Department entity) {
        String sql = "INSERT INTO `department` "
                + "(`name`, `faculty`) "
                + "VALUES "
                + "(?, ?)";
        Connection c = null;
        PreparedStatement p = null;
        try {
            c = Connect.getConnection();
            p = c.prepareStatement(sql);
            p.setString(1, entity.getName());
            p.setString(2, entity.getFaculty());
            p.execute();
        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            try {
                p.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }
}
