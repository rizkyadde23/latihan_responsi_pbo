/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.latres.model;

import com.pbo.latres.config.DatabaseConnection;
import com.pbo.latres.dto.InsertTodoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADVAN
 */
public class RealTodoRepository implements TodoRepository {

    private final DatabaseConnection conn;

    public RealTodoRepository() {
        this.conn = DatabaseConnection.getInstance();
    }

    @Override
    public List<TodoTask> getAll() {
        List<TodoTask> result = new ArrayList<>();
        try {
            String sql = "SELECT * FROM task";
            Connection connection = this.conn.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                TodoTask task = new TodoTask(
                        rs.getInt("id_task"),
                        rs.getString("nama_task"),
                        rs.getString("status")
                );
                result.add(task);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return result;
    }

    @Override
    public TodoTask getById(int id) {
        TodoTask task = null;
        try {
            String sql = "SELECT * FROM task WHERE id_task=?";
            Connection connection = this.conn.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                task = new TodoTask(
                        rs.getInt("id_task"),
                        rs.getString("nama_task"),
                        rs.getString("status")
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return task;
    }

    @Override
    public Boolean insert(InsertTodoDTO insertTodoDTO
    ) {
        try {
            String sql
                    = "INSERT INTO task (nama_task, status) VALUES (?, ?)";
            Connection connection = this.conn.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, insertTodoDTO.getTitle());
            stmt.setString(2, insertTodoDTO.getStatus());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public Boolean update(TodoTask todoTask
    ) {
        try {
            String sql
                    = "UPDATE task SET "
                    + "nama_task=?, "
                    + "status=? ";
            Connection connection = this.conn.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, todoTask.getTitle());
            stmt.setString(2, todoTask.getStatus());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    public Boolean deleteById(int id
    ) {
        try {
            String sql
                    = "DELETE from task "
                    + "WHERE id_task = ?";
            Connection connection = this.conn.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

}
