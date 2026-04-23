package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.sinhvien;
import dataBase.sinhvienDAO;

/**
 * Servlet implementation class sinhvienServlet
 */
@WebServlet("/sinhvien")
public class sinhvienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	sinhvienDAO dao = new sinhvienDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public sinhvienServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			if (action == null) {
				listSinhVien(request, response);
			} else if (action.equals("delete")) {
				deleteSinhVien(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void deleteSinhVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		sinhvien sv  =dao.selectByID(id);
		dao.delete(sv);
		response.sendRedirect("sinhvien");
		

	}

	private void listSinhVien(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<sinhvien> arrayList = new ArrayList();
		arrayList = dao.selectAll();
		request.setAttribute("listSV", arrayList);
		request.getRequestDispatcher("list.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
