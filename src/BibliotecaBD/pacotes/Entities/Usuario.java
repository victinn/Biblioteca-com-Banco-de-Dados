package BibliotecaBD.pacotes.Entities;

public class Usuario {
    private String nome, email, senha;
    private int idade;
    private String curso;
    private int id;

    public Usuario(String nome, String email, String senha, int idade, String curso, int id) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idade = idade;
        this.curso = curso;
        this.id = id;
    }

    public Usuario(String nome, String email, String senha, int idade, String curso) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.idade = idade;
        this.curso = curso;
    }

    public Usuario() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
