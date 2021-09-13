package br.com.alura.autor.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.autor.ConnectionFactory;
import br.com.alura.autor.dao.AutorDao;
import br.com.alura.autor.modelo.Autor;

/**
 * Servlet implementation class AutorServlet
 */
@WebServlet("/autores")
public class AutoresServlet extends HttpServlet {

    private AutorDao dao;
 
    public AutoresServlet() {
        this.dao = new AutorDao(new ConnectionFactory().getConnection());
    }

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("autores", dao.listar());

		req.getRequestDispatcher("WEB-INF/autores.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		LocalDate nascimento = LocalDate.parse(req.getParameter("nascimento"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		Autor autor = new Autor(nome, email, nascimento);
		
		dao.cadastrar(autor);
		
		resp.sendRedirect("autores");
	}

}
