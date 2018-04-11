package DAO;

import Entity.Department;
import Entity.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorController extends AbstractController<Professor> {


    @Override
    public List<Professor> getAll() {
        String sql = "SELECT `id`, `name`, `department` FROM `professor`";
        Connection c = null;
        PreparedStatement p = null;
        ResultSet r = null;
        try {
            c = Connect.getConnection();
            p = c.prepareCall(sql);
            r = p.executeQuery();
            ArrayList<Professor> list = new ArrayList<>();
            while(r.next()) {
                Professor object = new Professor();
                object.setId(r.getInt("id"));
                object.setName(r.getString("name"));
                object.setDepartment(r.getString("department"));
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
    public void update(Professor entity) {
        String sql = "UPDATE `professor` SET "
                + "`name` = ?, `department` = ? "
                + "WHERE `id` = ?";
        Connection c = null;
        PreparedStatement p = null;
        try {
            c = Connect.getConnection();
            p = c.prepareStatement(sql);
            p.setString(1, entity.getName());
            p.setString(2, entity.getDepartment());
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
    public Professor getEntityById(long id) {
        String sql = "SELECT `name`, `department` FROM `professor`" +
                "WHERE `id` = ?";
        Connection c = null;
        PreparedStatement p = null;
        ResultSet r = null;
        try {
            c = Connect.getConnection();
            p = c.prepareStatement(sql);
            p.setLong(1, id);
            r = p.executeQuery();
            Professor object = new Professor();
            if(r.next()){
                object.setId(id);
                object.setName(r.getString("name"));
                object.setDepartment(r.getString("department"));
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
        String sql = "DELETE FROM `professor` WHERE `id` = ?";
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
    public void create(Professor entity) {
        String sql = "INSERT INTO `professor` "
                + "(`name`, `department`) "
                + "VALUES "
                + "(?, ?)";
        Connection c = null;
        PreparedStatement p = null;
        try {
            c = Connect.getConnection();
            p = c.prepareStatement(sql);
            p.setString(1, entity.getName());
            p.setString(2, entity.getDepartment());
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
