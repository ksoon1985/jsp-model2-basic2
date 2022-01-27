package model2.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.PageDTO;

@SuppressWarnings("serial")
@WebServlet("/board2/delete.do")
public class BoardDeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int currentPage = 0;
		if (req.getParameter("currentPage") == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(req.getParameter("currentPage"));
		}
		int currPageBlock = 0;
		if (req.getParameter("currPageBlock") == null) {
			currPageBlock = 1;
		} else {
			currPageBlock = Integer.parseInt(req.getParameter("currPageBlock"));
		}
		PageDTO pdto = new PageDTO();
		pdto.setCurrentPage(currentPage);
		pdto.setCurrPageBlock(currPageBlock);
		req.setAttribute("pdto", pdto);
		int num = Integer.parseInt(req.getParameter("num"));
		// DAO 가져오기
		BoardDAO dao = BoardDAO.getInstance();
		// DAO메소드실행
		int r = dao.deleteArticle(num);
		req.setAttribute("r", r);
		
		req.getRequestDispatcher("/board2/deletePro.jsp").forward(req, resp);
	
	}

	
}
