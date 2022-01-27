package model2.board;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
@WebServlet("/board2/list.do")
public class BoardListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		// TODO Auto-generated method stub
		
		BoardDAO dao = BoardDAO.getInstance();
		PageDTO pdto = new PageDTO();
		//전체 레코드 수
		int cnt = dao.getAllCount();
		pdto.setAllCount(cnt);
		//전체 페이지 수 계산
		int pageCnt = cnt%pdto.getLinePerPage();
		if(pageCnt==0) {
			//몫이 전체페이지수
			pdto.setAllPage(cnt/pdto.getLinePerPage());   
		}else {
			//몫+1이 전체 페이지 수
			pdto.setAllPage(cnt/pdto.getLinePerPage()+1);
		}
		
		int currentPage =0;
		if(req.getParameter("currentPage")==null || req.getParameter("currentPage").equals("0")) {
			currentPage = 1; 
		}else {
			currentPage=Integer.parseInt(req.getParameter("currentPage"));
		}
		
		//현재 블럭 받아오기
		int currPageBlock=0;
		if(req.getParameter("currPageBlock")==null || req.getParameter("currPageBlock").equals("0")) {
			currPageBlock=1;
		}else {
			currPageBlock=Integer.parseInt(req.getParameter("currPageBlock"));
		}
		pdto.setCurrentPage(currentPage);
		pdto.setCurrPageBlock(currPageBlock);
		   
		int startPage = 1;
		int endPage=1;

		startPage = (currPageBlock-1)*pdto.getPageBlock()+1;
		endPage = currPageBlock*pdto.getPageBlock()>pdto.getAllPage()?pdto.getAllPage():currPageBlock*pdto.getPageBlock(); 
	
		pdto.setStartPage(startPage);
		pdto.setEndPage(endPage);
		  
		//시작 값
		int sRow=(currentPage-1)*pdto.getLinePerPage()+1;
		List<BoardDTO> list = null ;
		
		try {
			list = dao.getArticles(sRow, currentPage*pdto.getLinePerPage());
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//view에서 사용할 결과 값 저장
		req.setAttribute("list", list);
		//페이지 정보도 저장
		req.setAttribute("pdto",pdto);
		
		req.getRequestDispatcher("/board2/boardList.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	
}
