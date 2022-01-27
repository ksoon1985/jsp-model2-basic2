# jsp-model2-basic2

jsp-model2-basic 프로젝트에서 
게시판 로직들을 모두 서블릿으로 변경 

## java
* board
  * BoardDAO - DB 로직 처리
  * BoardDTO - 게시판 DTO
  * PageDTO - 페이징 DTO
  
* common
  * ServletUpload 
  * dbutil 
    * CommonEncodingFilter 
    * DBConnection

* model2.board
  * BoardContentServlet
  * BoardDeleteServlet
  * BoardListServlet
  * BoardUpdateFormServlet
  * BoardUpdateProServlet
  * BoardWriteFormServlet
  * BoardWriteProServlet

## jsp
* view

## js
* boardScript - validation chk
* jquery 

## web-inf
* web.xml
  * 인코딩 필터 common.dbutil.CommonEncodingFilter - Encoding Filter

## lib
* commons-fileupload-1.4
* commons-io-2.7
* cos
* jstl-1.2
* ojdbc8

## db
* oracle - 21 


## 회고...
BoardWriteServlet, BoardUpdateServet 으로 form은 doGet, 작성및 수정은 doPost로 처리하려 했다.  
작성에 대한 url 을 write.do, 수정에 대한 url 을 update.do로 해서  
단순 페이지 이동은 doGet , 작업 처리는 doPost로 개발하려 했으나 ...  

페이지 이동간에 다양한 파라미터를 가지고 이동함에 따라 get방식은 너무많은 정보를 흘리게 됨.  
또한 뭔가 자꾸 꼬이게 됨.  
특히 게시글 상세페이지 -> 수정,삭제,답글 페이지 갈 때(단순히 패이지 이동이지만...)  
원본 글 정보가 필요함 -> post가 가장 좋은 방법  
처음 생각했던, 페이지 이동은 doGet으로만 설계했던 방식에 문제가 생기기 시작.  

결론적으론, 페이지 이동 부분과 처리부분(작성 및 수정 등)은 나눠놓는게 편하겠다고 생각하여  
BoardWriteServlet -> BoardWriteFormServlet, BoardWriteProServlet  
BoardUpdateServlet -> BoardUpdateFormServlet, BoardUpdateProServelt 으로 나눠둠.  
