package controller;

import model.DAO;
import model.JavaBeans;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/Controller", "/main", "/insert", "/select", "/update", "/delete"})
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    DAO dao = new DAO();
    JavaBeans produto = new JavaBeans();
    public Controller(){

        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);
        if(action.equals("/main")) {
            produtos(request, response);
        } else if (action.equals("/insert")) {
            novoProduto(request, response);
        } else if (action.equals("/select")) {
            listarProduto(request, response);
        } else if (action.equals("/update")) {
            editarProduto(request, response);
        } else if (action.equals("/delete")) {
            editarProduto(request, response);
        } else {
            response.sendRedirect("index.html");
        }
    }

    //listar produtos

    protected void produtos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // criando um objeto que ira receber os dados JavaBeans
        ArrayList<JavaBeans> lista = dao.listarProdutos();
        //Encaminhar a lista ao documento produto.jsp
        request.setAttribute("produtos", lista);
        RequestDispatcher rd = request.getRequestDispatcher("produto.jsp");
        rd.forward(request, response);

    }

    //Novo Produto
    protected void novoProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //setar variaveis
        produto.setCodigo(request.getParameter("codigo"));
        produto.setNome(request.getParameter("nome"));
        produto.setCategoria(request.getParameter("categoria"));
        produto.setValor(request.getParameter("valor"));
        produto.setQuantidade(request.getParameter("quantidade"));
        // invocar o metodo inserir contato passando o objeto
        dao.inserirProduto(produto);
        // redirecionar para o documento produto.jsp
        response.sendRedirect("main");
    }

    //Editar Produto
    protected void listarProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        //Seta variavel JavaBens
        produto.setId(id);
        //seleciona produto
        dao.selecionarProduto(produto);
        //setar os atributos do formulario com o conteudo JavaBeans
        request.setAttribute("id", produto.getId());
        request.setAttribute("codigo", produto.getCodigo());
        request.setAttribute("nome", produto.getNome());
        request.setAttribute("categoria", produto.getCategoria());
        request.setAttribute("valor", produto.getValor());
        request.setAttribute("quantidade", produto.getQuantidade());
        // encaminahr ao documento editar.jsp
        RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
        rd.forward(request, response);
    }
    protected void editarProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //setar as variaveis JavaBeans
        produto.setId(request.getParameter("id"));
        produto.setCodigo(request.getParameter("codigo"));
        produto.setNome(request.getParameter("nome"));
        produto.setCategoria(request.getParameter("categoria"));
        produto.setValor(request.getParameter("valor"));
        produto.setQuantidade(request.getParameter("quantidade"));
        //alterar contato
        dao.alterarProduto(produto);
        //redirecionamento para o documento produto.jsp
        response.sendRedirect("main");
    }
    protected void removerProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recebimento do id
        //setar a variavel
        produto.setId(request.getParameter("id"));
        //metodo deletar contato
        dao.deletarProduto(produto);
        // redirecionar para o documento produto.jsp
        response.sendRedirect("main");

    }

}
