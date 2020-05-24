package Com.Ronal.Controlador;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.Jose.Dao.UsDao;
import Com.Jose.Modelo.TbUsuariop;



/**
 * Servlet implementation class Servelet
 */
public class Servelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String us = request.getParameter("usuario");
		String contra = request.getParameter("contrasenia");
		
		TbUsuariop u = new TbUsuariop();
		UsDao udao= new UsDao();
		
		
		u.setUsuario(us);
		u.setContrasenia(contra);
		
		int verificaion= udao.usuario(u).size();
		
		if (verificaion ==1) {
			
			response.sendRedirect("Final.jsp");
			
		}else {
			System.out.println("¡Error Usuario o Contraseña incorrecto!");
			
		}
		
		
		
		
		
		
		
	}
	
	

}
