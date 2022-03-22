package BibliotecaBD.pacotes.DAO;

import BibliotecaBD.pacotes.Connections.ConnectionFactory;
import BibliotecaBD.pacotes.Entities.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuariosDAO {
    public void Adicionar(Usuario u) throws SQLException{
        String sql = "INSERT INTO USUARIO (NOME, EMAIL, SENHA, IDADE, CURSO) VALUES (?,?,?,?,?)";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getEmail());
        stmt.setString(3, u.getSenha());
        stmt.setInt(4, u.getIdade());
        stmt.setString(5, u.getCurso());
        
        stmt.execute();
        stmt.close();
        connection.close();      
    }
    
    public ArrayList<Usuario> selecionarTodos() throws SQLException{
        ArrayList<Usuario> retorno = new ArrayList();
        String sql = "SELECT ID, NOME, EMAIL, SENHA, IDADE, CURSO FROM USUARIO";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Usuario u = new Usuario();
            u.setId(rs.getInt("ID"));
            u.setNome(rs.getString("NOME"));
            u.setEmail(rs.getString("EMAIL"));
            u.setSenha(rs.getString("SENHA"));
            u.setIdade(rs.getInt("IDADE"));
            u.setCurso(rs.getString("CURSO"));
            retorno.add(u);
        }
        return retorno;      
    }
    
    public void Remover(Usuario u) throws SQLException{
        String sql = "DELETE FROM USUARIO WHERE ID = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setInt(1, u.getId());
        
        stmt.execute();
        stmt.close();
        connection.close();        
    }
    
    public void Alterar(Usuario u) throws SQLException{
        String sql = "UPDATE USUARIO SET NOME = ?, EMAIL = ?, SENHA = ?, IDADE = ?, CURSO = ? WHERE ID = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getEmail());
        stmt.setString(3, u.getSenha());
        stmt.setInt(4, u.getIdade());
        stmt.setString(5, u.getCurso());
        stmt.setInt(6, u.getId());
        
        stmt.execute();
        stmt.close();
        connection.close();
    }
}
