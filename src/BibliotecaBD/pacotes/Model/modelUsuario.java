package BibliotecaBD.pacotes.Model;

import BibliotecaBD.pacotes.DAO.UsuariosDAO;
import BibliotecaBD.pacotes.Entities.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public final class modelUsuario extends AbstractTableModel {
    ArrayList<Usuario> usuarios = new ArrayList();
    String[] colunas = {"Nome", "Email", "Senha", "Idade", "Curso"};

    @Override
    public int getRowCount() {
        return usuarios.size();
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
        switch(coluna){
            case 0:
                return usuarios.get(linha).getNome();
            case 1:
                return usuarios.get(linha).getEmail();
            case 2:
                return usuarios.get(linha).getSenha();
            case 3:
                return usuarios.get(linha).getIdade();
            case 4:
                return usuarios.get(linha).getCurso();
        }
        return null;
    }
    
    public void carregarDados() throws SQLException{
        UsuariosDAO dao = new UsuariosDAO();
        this.usuarios = dao.selecionarTodos();
        this.fireTableDataChanged();
    }
    
    public modelUsuario() throws SQLException{
        this.carregarDados();
    }
    
    public void Adicionar(Usuario u) throws SQLException{
        UsuariosDAO dao = new UsuariosDAO();
        dao.Adicionar(u);
        this.carregarDados();
    }
    
    public void Remover(int index) throws SQLException{
        UsuariosDAO dao = new UsuariosDAO();
        Usuario u = usuarios.get(index);
        dao.Remover(u);
        this.carregarDados();
    }
    
    public Usuario getSelectedUsuario(int index){
        return usuarios.get(index);
    }
    
    public void Alterar(Usuario u) throws SQLException{
        UsuariosDAO dao = new UsuariosDAO();
        dao.Alterar(u);
        carregarDados();
    }
    
}
