package BibliotecaBD.pacotes.DAO;
import BibliotecaBD.pacotes.Connections.ConnectionFactory;
import BibliotecaBD.pacotes.Entities.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class LivrosDAO{
    public void Inserir(Livro l) throws SQLException{
        String sql = "INSERT INTO LIVRO (TITULO, PAGINAS, NOMEAUTOR, GENERO, EDITORA, ANOPUBLICACAO) VALUES (?, ?, ?, ?, ?, ?)";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, l.getTitulo());
        stmt.setInt(2, l.getPaginas());
        stmt.setString(3, l.getNomeAutor());
        stmt.setString(4, l.getGenero());
        stmt.setString(5, l.getEditora());
        stmt.setInt(6, l.getAnoPublicacao());
        
        stmt.execute();
        
        stmt.close();
        connection.close();
        
    }
    
    public ArrayList<Livro> selecionarTodos() throws SQLException{
        ArrayList<Livro> arrayLivro = new ArrayList();
        
        String sql = "SELECT ID, TITULO, PAGINAS, NOMEAUTOR, GENERO, EDITORA, ANOPUBLICACAO FROM LIVRO";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()){
            Livro l = new Livro();
            l.setId(rs.getInt("ID"));
            l.setTitulo(rs.getString("TITULO"));
            l.setPaginas(rs.getInt("PAGINAS"));
            l.setNomeAutor(rs.getString("NOMEAUTOR"));
            l.setGenero(rs.getString("GENERO"));
            l.setEditora(rs.getString("EDITORA"));
            l.setAnoPublicacao(rs.getInt("ANOPUBLICACAO"));
            
            arrayLivro.add(l);
           
        }
        
        return arrayLivro;
    }
    
    public void Remover(Livro l) throws SQLException{
        String sql = "DELETE FROM LIVRO WHERE ID = ?";
        
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setInt(1, l.getId());
        stmt.execute();
        
        stmt.close();
        connection.close();
        
    }
    
    public void Alterar(Livro l) throws SQLException{
        String sql = "UPDATE LIVRO SET TITULO = ?, PAGINAS = ?, NOMEAUTOR = ?, GENERO = ?, EDITORA = ?, ANOPUBLICACAO = ? WHERE ID = ?";
        
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, l.getTitulo());
        stmt.setInt(2, l.getPaginas());
        stmt.setString(3, l.getNomeAutor());
        stmt.setString(4, l.getGenero());
        stmt.setString(5, l.getEditora());
        stmt.setInt(6, l.getAnoPublicacao());
        stmt.setInt(7, l.getId());
        
        stmt.execute();
        
        stmt.close();
        connection.close();
      
    }
}
