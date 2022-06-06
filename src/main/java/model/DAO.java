package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
    /**
     * Módulo de conexão
     **/
    //parametros de conexão
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/dbestoque?useTimezone=true&serverTimezone=UTC";

    private String user = "root";
    private String password = "8409";

    // Método de conexão
    private Connection conectar() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /** CRUD CREATE **/
    public void inserirProduto(JavaBeans produto) {
        String create = "insert into produto (codigo,nome,categoria,valor,quantidade) values (?,?,?,?,?)";
        try {
            //abrir conexao com o banco
            Connection con = conectar();
            // Preparar a query para execução
            PreparedStatement pst = con.prepareStatement(create);
            // Substitui os parametros (?) pelo conteudo
            pst.setString(1, produto.getCodigo());
            pst.setString(2, produto.getNome());
            pst.setString(3, produto.getCategoria());
            pst.setString(4, produto.getValor());
            pst.setString(5, produto.getQuantidade());
            // Executar a query
            pst.executeUpdate();
            //encerrar conexao com o banco
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /** CRUD READ **/
    public ArrayList<JavaBeans> listarProdutos() {
            // criando um objeto para acessar  a classe JavaBeans
            ArrayList<JavaBeans> produtos = new ArrayList<>();
            String read =  "select * from produto order by nome;";
            try {
                Connection con = conectar();
                PreparedStatement pst = con.prepareStatement(read);
                ResultSet rs = pst.executeQuery();
                // Laço de repetição
                while (rs.next()) {
                    // variaveis de apoio que recebem dados de banco
                    String id = rs.getString(1);
                    String codigo = rs.getString(2);
                    String nome = rs.getString(3);
                    String categoria = rs.getString(4);
                    String valor = rs.getString(5);
                    String quantidade = rs.getString(6);
                    // populando o arraylist
                    produtos.add(new JavaBeans(id, codigo, nome, categoria, valor, quantidade));
                }
                con.close();
                return produtos;
            } catch (Exception e) {
                System.out.println(e);
                return null;
            }
    }

    //CRUD UPDATE//
    //SELECIONAR O Produto
    public void selecionarProduto(JavaBeans produto) {
        String read2 = "select * from produto where id=?;";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read2);
            pst.setString(1, produto.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                //Setar as variaveis JavaBeans
                produto.setId(rs.getString(1));
                produto.setCodigo(rs.getString(2));
                produto.setNome(rs.getString(3));
                produto.setCategoria(rs.getString(4));
                produto.setValor(rs.getString(5));
                produto.setQuantidade(rs.getString(6));
            }
            con.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
    //editar produto
    public void alterarProduto(JavaBeans produto){
        String update = "update produto set codigo=?, nome=?, categoria=?, valor=?, quantidade=? where id=?;";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(update);
            pst.setString(1, produto.getCodigo());
            pst.setString(2, produto.getNome());
            pst.setString(3, produto.getCategoria());
            pst.setString(4, produto.getValor());
            pst.setString(5, produto.getQuantidade());
            pst.executeUpdate();
            con.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    //CRUD DELETE
    public void deletarProduto(JavaBeans produto) {
        String delete = "delete from produto where id=?;";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(delete);
            pst.setString(1, produto.getId());
            pst.executeUpdate();
            con.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}











   /** // teste de conexão
    public void testeConexao() {
        try {
            Connection con = conectar();
            System.out.println(con);
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }
    }**/
