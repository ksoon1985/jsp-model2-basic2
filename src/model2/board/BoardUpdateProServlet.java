package model2.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardDTO;
import board.PageDTO;

@SuppressWarnings("serial")
@WebServlet("/board2/updatePro.do")
public class BoardUpdateProServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 한글 확인업을 위해 utf-8로 전환
		/* req.setCharacterEncoding("utf-8"); */
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
		// updateForm에서 보내준 데이터 모두 받기
		BoardDTO dto = new BoardDTO();
		dto.setNum(Integer.parseInt(req.getParameter("num")));
		dto.setSubject(req.getParameter("subject"));
		dto.setContent(req.getParameter("content"));
		dto.setEmail(req.getParameter("email"));
		dto.setPasswd(req.getParameter("passwd"));
		dto.setAttachNm(req.getParameter("attachNm"));

		// DAO에 대한 인스턴스 받아오기
		BoardDAO dao = BoardDAO.getInstance();
		// DAO에 해당 데이터 저장하는 로직을 만들고
		// 그 로직을 사용한 후
		dao.boardUpdate(dto);
		// 다음 페이지로 이동 시킴

		req.getRequestDispatcher("/board2/updatePro.jsp").forward(req, resp);
	}
	
}
