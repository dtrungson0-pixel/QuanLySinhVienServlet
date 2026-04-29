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
		// 1. Lấy ID từ URL
		String idString = request.getParameter("id");
		System.out.println("--- Đang thử xóa ID: " + idString + " ---"); // In ra Console để kiểm tra

		int id = Integer.parseInt(idString);

		// 2. Không cần gọi selectByID nữa. Tự tạo 1 sinhvien rỗng để hứng ID truyền vào
		// hàm delete
		sinhvien sv = new sinhvien();
		sv.setId(id); // Set ID cho nó (Đảm bảo Class sinhvien của bạn có hàm setId)

		// 3. Thực hiện xóa và kiểm tra kết quả
		int ketQua = dao.delete(sv);

		if (ketQua > 0) {
			System.out.println("-> Xóa thành công sinh viên có ID = " + id);
		} else {
			System.out.println("-> LỖI: Xóa thất bại. Không tìm thấy ID hoặc lỗi CSDL.");
		}

		// 4. Load lại trang
		response.sendRedirect("sinhvien");
	}

	private void listSinhVien(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<sinhvien> arrayList = new ArrayList();
		arrayList = dao.selectAll();
		request.setAttribute("listSV", arrayList);
		request.getRequestDispatcher("list.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			if (id == null || id.isEmpty()) {
				insertSinhVien(request, response);
			} else {
				updateSinhVien(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void updateSinhVien(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void insertSinhVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("hoTen");
		String diaChi = request.getParameter("diaChi");
		String tenLop = request.getParameter("tenLop");
		String namSinh = request.getParameter("namSinh");
		sinhvien sv = new sinhvien(id, name, diaChi, tenLop, namSinh);
		dao.inSert(sv);
		response.sendRedirect("sinhvien");

	}

}
