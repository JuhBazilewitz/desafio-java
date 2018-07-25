package br.com.desafio.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.desafio.java.model.User;

/**
 * 
 * @author juliane.bazilewitz
 *
 */
public class UserDao {  
    
    private JdbcTemplate jdbcTemplate;

    public void salvar(User usuario) {
        try {
            Connection con = connection();
            String sql = "insert into dbo.usuario (username, password, is_enabled, register_date, name, surname, email, phone) "
                    + " values('" + usuario.getUsername() + "', '" + usuario.getPassword() + "',"
                    + 1 + ", cast('" + usuario.getRegisterDate() + "' as datetime), '"+ usuario.getNome() + "', '" + usuario.getSobrenome() + "', '"
                    + usuario.getEmail() + "', '" + usuario.getTelefone() + "')";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void template(String sql) {
        jdbcTemplate.update(sql);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public Connection connection() throws SQLException {
        String conexao = "jdbc:sqlserver://UBR3144\\SQLEXPRESS; databaseName=db_curso_unicred; user=sa;password=xongas_1234;";
        Connection con = DriverManager.getConnection(conexao);
        return con;
    }
    
}
