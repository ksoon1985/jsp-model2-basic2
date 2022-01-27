package model2.board;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardDTO;
import board.PageDTO;

@SuppressWarnings("serial")
@WebServlet("/board2/updateForm.do")
public class BoardUpdateFormServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
		// DAO를 통해서 해당 글 갖고오기
		BoardDAO dao = BoardDAO.getInstance();
		// 해당 인스턴스에서 해당되는 메소드 실행
		BoardDTO dto = null;
		try {
			dto = dao.getArticle(num);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// setAttribute를 해줘야 됨
		req.setAttribute("dto", dto);

		req.getRequestDispatcher("/board2/updateForm.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
}
