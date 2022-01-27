package model2.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardDTO;
import board.PageDTO;
import common.ServletUpload;

/***
 * 게시판 작성 처리 서블릿 
 * @author kwons
 *
 */
@SuppressWarnings("serial")
@WebServlet("/board2/writePro.do")
public class BoardWriteProServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Map<String, Object> mutlDTO = ServletUpload.uploadEx(req, resp);
		//DAO를 통해서 받은데이터저장하기
		//DAO에 대한 인스턴스 받아오기
		BoardDAO dao = BoardDAO.getInstance();
		try {
			dao.boardWrite((BoardDTO)mutlDTO.get("dto"));
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("pdto", (PageDTO)mutlDTO.get("pdto"));
		
		req.getRequestDispatcher("/board2/writePro.jsp").forward(req, resp);
	}
	

}
