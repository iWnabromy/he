package helios.siteweb.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helios.siteweb.metier.HeliosManager;
import helios.siteweb.model.Partenaire;

@WebServlet("/admin/sponsor")

public class SponsorsServlet extends HttpServlet {

	private static final long serialVersionUID = 6880801727716084460L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Partenaire> sponsors = HeliosManager.getInstance().getPartenaire();
		request.setAttribute("listesponsors", sponsors);


		RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/Admin/sponsor.jsp");
		view.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id1 =request.getParameter("id");
		Integer id_Sponsor =Integer.parseInt(id1);
		

			HeliosManager.getInstance().supprimerMembre(id_Sponsor);

			response.sendRedirect("sponsor");
		
	}


}
