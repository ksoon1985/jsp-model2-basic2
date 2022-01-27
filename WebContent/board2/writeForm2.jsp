<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Write something else you want</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
 
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
 
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
<form action="writePro.do" method="post" encType="multiplart/form-data">
  <table class="table table-bordered">
    <thead>
        <caption> 글쓰기 </caption>
    </thead>
    <tbody>
        <tr>
            <th>제목: </th>
            <td><input type="text" placeholder="제목을 입력하세요. " name="subject"/></td>
        </tr>
        <tr>
            <th>내용: </th>
            <td><textarea cols="80%" placeholder="내용을 입력하세요. " name="content"></textarea></td>
        </tr>
        <tr>
            <th>첨부파일: </th>
            <td><input type="file" placeholder="파일을 선택하세요. " name="filename"/></td>
        </tr>
        <tr>
            <th>비밀번호: </th>
            <td><input type="password" placeholder="비밀번호를 입력하세요"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="button" value="등록" onclick="sendData()"/>
                <input type="button" value="reset"/>
                <input type="button" value="글 목록으로... " onclick="javascript:location.href='lsit.do'"/>
            </td>
        </tr>
    </tbody>
  </table>
</form>
</div>
</body>
</html>

