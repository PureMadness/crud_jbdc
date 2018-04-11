package DAO;

import Entity.Faculty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacultyController extends AbstractController<Faculty> {
    @Override
    public List<Faculty> getAll() {
        String sql = "SELECT `id`, `name` FROM `faculty`";
        Connection c = null;
        PreparedStatement p = null;
        ResultSet r = null;
        try {
            c = Connect.getConnection();
            p = c.prepareCall(sql);
            r = p.executeQuery();
            ArrayList<Faculty> list = new ArrayList<>();
            while(r.next()) {
                Faculty object = new Faculty();
                object.setId(r.getInt("id"));
                object.setName(r.getString("name"));
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
    public void update(Faculty entity) {
        String sql = "UPDATE `faculty` SET "
                + "`name` = ? "
                + "WHERE `id` = ?";
        Connection c = null;
        PreparedStatement p = null;
        try {
            c = Connect.getConnection();
            p = c.prepareStatement(sql);
            p.setString(1, entity.getName());
            p.setLong(2, entity.getId());
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
    public Faculty getEntityById(long id) {
        String sql = "SELECT `name` FROM `faculty`" +
                "WHERE `id` = ?";
        Connection c = null;
        PreparedStatement p = null;
        ResultSet r = null;
        try {
            c = Connect.getConnection();
            p = c.prepareStatement(sql);
            p.setLong(1, id);
            r = p.executeQuery();
            Faculty object = new Faculty();
            if(r.next()){
                object.setId(id);
                object.setName(r.getString("name"));
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
        String sql = "DELETE FROM `faculty` WHERE `id` = ?";
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
    public void create(Faculty entity) {
        String sql = "INSERT INTO `faculty` "
                + "(`name`) "
                + "VALUES "
                + "(?)";
        Connection c = null;
        PreparedStatement p = null;
        try {
            c = Connect.getConnection();
            p = c.prepareStatement(sql);
            p.setString(1, entity.getName());
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
