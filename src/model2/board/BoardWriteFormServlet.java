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
 * 게시판 작성 폼 서블릿
 * @author kwons
 *
 */
@SuppressWarnings("serial")
@WebServlet("/board2/writeForm.do")
public class BoardWriteFormServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
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
			currPageBlock=Integer.parseInt( req.getParameter("currPageBlock"));
		}
			
		PageDTO pdto = new PageDTO();
			
		pdto.setCurrentPage(currentPage);
		pdto.setCurrPageBlock(currPageBlock);
		
		//답글인지 아닌지 확인
		int num = 0, ref=0, re_step=1, re_level=1;
		if(req.getParameter("num")!=null) {
		  num = Integer.parseInt(req.getParameter("num"));
		  ref = Integer.parseInt(req.getParameter("ref"));
		  re_step= Integer.parseInt(req.getParameter("re_step"));
		  re_level= Integer.parseInt(req.getParameter("re_level"));
	   }
		
	   //view에서 쓸 결과 값 저장
	   req.setAttribute("num", num);
	   req.setAttribute("ref", ref);
	   req.setAttribute("re_step", re_step);
	   req.setAttribute("re_level", re_level);
	   req.setAttribute("pdto", pdto);
	   
	   req.getRequestDispatcher("/board2/writeForm.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
