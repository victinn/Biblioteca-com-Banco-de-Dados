package BibliotecaBD.pacotes.Model;

import BibliotecaBD.pacotes.DAO.LivrosDAO;
import BibliotecaBD.pacotes.Entities.Livro;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public final class modelLivro extends AbstractTableModel{
    
    ArrayList<Livro> livros = new ArrayList();
    String[] colunas = {"Titulo", "Autor", "Editora", "Páginas", "Ano de Publicação", "Gênero"};
    
    @Override
    public int getRowCount() {
        return livros.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public String getColumnName(int column){
        return colunas[column];
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return livros.get(linha).getTitulo();
            case 1:
                return livros.get(linha).getNomeAutor();
            case 2:
                return livros.get(linha).getEditora();
            case 3:
                return livros.get(linha).getPaginas();
            case 4:
                return livros.get(linha).getAnoPublicacao();
            case 5:
                return livros.get(linha).getGenero();

        }
        return null;
    }
    
    public modelLivro() throws SQLException {
        this.carregarDados();
    }
        
    public void Adicionar(Livro l) throws SQLException {
        LivrosDAO dao = new LivrosDAO();
        
        dao.Inserir(l);
        
        this.carregarDados();
    }
    
    public void Remover(int index) throws SQLException{
        LivrosDAO dao = new LivrosDAO();
        Livro l = livros.get(index);
        
        dao.Remover(l);
        this.carregarDados();
    }
    
    public void Alterar(Livro l) throws SQLException{
        LivrosDAO dao = new LivrosDAO();
        
        dao.Alterar(l);
        this.carregarDados();
    }
    
    public Livro getSelectedLivro(int index) {
        return this.livros.get(index);
    }
    
    public void carregarDados() throws SQLException {
        LivrosDAO dao = new LivrosDAO();
        
        this.livros = dao.selecionarTodos();
        
        this.fireTableDataChanged();
    }    
    
}
