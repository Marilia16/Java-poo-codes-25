package com.login.repository;
import com.login.model.Logins;
import com.login.repository.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginsDao implements Dao<Logins> {
    @Override
    public Logins get(Long cpf){
        Logins login = null;
        String sql = "SELECT * FROM tbLogins WHERE cpf = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(sql); 
            pstmt.setLong(1, cpf);
            rs = pstmt.executeQuery();
            while(rs.next()){
                login = new Logins();
                login.setCpf(rs.getLong("cpf"));
                login.setName(rs.getString("name"));
                login.setSenha(rs.getString("senha"));
            }
           
        } catch (SQLException e) {
            System.err.println("Error fetching login: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
        return login;
    }

    @Override
    public List<Logins> getAll() {
        List<Logins> loginsList = new ArrayList<>();
        String sql = "SELECT * FROM tbLogins";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Logins login = new Logins();
                login.setCpf(rs.getLong("cpf"));
                login.setName(rs.getString("name"));
                login.setSenha(rs.getString("senha"));
                loginsList.add(login);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching all logins: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
        return loginsList;
    }

    @Override
    public void save(Logins login) {
        String sql = "INSERT INTO tbLogins (cpf, name, senha) VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, login.getCpf());
            pstmt.setString(2, login.getName());
            pstmt.setString(3, login.getSenha());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error saving login: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }
    @Override
    public void update(Logins login, String[] params) {
        String sql = "UPDATE tbLogins SET name = ?, senha = ? WHERE cpf = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, login.getName());
            pstmt.setString(2, login.getSenha());
            pstmt.setLong(3, login.getCpf());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating login: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }
    @Override
    public void delete(Long cpf) {
        String sql = "DELETE FROM tbLogins WHERE cpf = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, cpf);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting login: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }
    @Override
    public boolean ifsenhaisvalid(Long cpf, String senha) {
        String sql = "SELECT COUNT(*) FROM tbLogins WHERE cpf = ? AND senha = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean isValid = false;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, cpf);
            pstmt.setString(2, senha);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                isValid = rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error validating login credentials: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
        return isValid;
    }
    @Override
    public void updateSenha(Long cpf, String senha) {
        String sql = "UPDATE tbLogins SET senha = ? WHERE cpf = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, senha);
            pstmt.setLong(2, cpf);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating password: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }
    @Override
    public void updateName(Long cpf, String name) {
        String sql = "UPDATE tbLogins SET name = ? WHERE cpf = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setLong(2, cpf);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating name: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    @Override
    public void updateCpf(Long cpf, Long newCpf) {
        String sql = "UPDATE tbLogins SET cpf = ? WHERE cpf = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, newCpf);
            pstmt.setLong(2, cpf);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating CPF: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }
    @Override
    public boolean ifcpfexists(Long cpf) {
        String sql = "SELECT COUNT(*) FROM tbLogins WHERE cpf = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean exists = false;
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, cpf);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                exists = rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.err.println("Error checking if CPF exists: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
        return exists;
    }
    @Override
    public boolean isvalidname(String name) {
        return name != null && name.matches("[\\p{L} ]+");
    }

}
