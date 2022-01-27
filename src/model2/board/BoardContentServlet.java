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
@WebServlet("/board2/content.do")
public class BoardContentServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int num = Integer.parseInt(req.getParameter("num"));
		int currentPage =0;
		if(req.getParameter("currentPage")==null) {
			currentPage = 1; 
		}else {
			currentPage=Integer.parseInt(req.getParameter("currentPage"));
		}
		
		int currPageBlock=0;
		if(req.getParameter("currPageBlock")==null) {
			currPageBlock=1;
		}else {
			currPageBlock=Integer.parseInt(req.getParameter("currPageBlock"));
		}
		
		PageDTO pdto = new PageDTO();
		pdto.setCurrentPage(currentPage);
		pdto.setCurrPageBlock(currPageBlock);
		
		//실제 데이터 가져오기
		//DAO 사용.. 인스턴스 얻어오기
		BoardDAO dao = BoardDAO.getInstance();
		
		//해당 인스턴스에서 해당되는 메소드 실행
		BoardDTO dto = null;
		
		try {
			dto = dao.getArticle(num);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//setAttribute를 해줘야 됨
		req.setAttribute("dto", dto);
		req.setAttribute("pdto", pdto);
		
		req.getRequestDispatcher("/board2/content.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	
}
