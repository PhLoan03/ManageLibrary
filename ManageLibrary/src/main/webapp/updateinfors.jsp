<%@page import="com.models.muontraDB"%>
<%@page import="com.models.muontra"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/styleaddinfors.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lexend+Deca:wght@100;200;300;400;500;600;700;800;900&family=Montserrat:wght@100&family=Mulish:wght@300&family=Roboto+Condensed:wght@300&family=Space+Mono&family=Titillium+Web:wght@200&family=Ubuntu:wght@300&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link href="https://fonts.googleapis.com/css2?family=Josefin+Sans&display=swap" rel="stylesheet">
    <title> Update infor</title>
</head>
<body>
<%
	int mamuontra = Integer.parseInt(request.getParameter("mamuontra"));
	muontra muontra = muontraDB.getMuonTraById(mamuontra);
%>
	<div id="header">
        <div class="banner">
            <img src="images/main-backgr.png" alt="">
        </div>
        <div class="main-header">
             <div class="menu">
                <a href=""><img src="images/main-menu.png" alt=""></a>
                <ul>
                    <li>
                        <a href="seebooks.jsp">Sách</a>
                        <ul class="submenu">
                            <li><a href="addbooks.jsp">Thêm sách</a></li>
                            <li><a href="seebooks.jsp">Kiểm tra sách</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="seeinfors.jsp">Mượn trả</a>
                        <ul class="submenu">
                            <li><a href="addinfors.jsp">Thêm thông tin mượn trả</a></li>
                            <li><a href="seeinfors.jsp">Kiểm tra thông tin mượn trả</a></li>
                        </ul>
                    </li>
                    <li><a href="seesv.jsp">Bạn đọc</a></li>
                    <li><a href="quahan.jsp">Quá hạn</a></li>
                </ul>
            </div>
            <div class="brand">
                <a href="">L I B R A R Y</a>
            </div>
            <div class="user-all">
                <div class="log">
                    <a href="login.jsp">Đăng xuất</a>
                </div>
                <div class="user">
                    <a href=""><img src="images/user.png" alt=""></a>
                </div>
            </div>
        </div>  
    </div>
    <div id="main">
        <div class="form-login">
            <h3>Sửa thông tin mượn sách</h3>
            <form action="/ManageLibrary/updateinforsServlet">
                <div class="f">
                  <label class="">Mã sinh viên</label>
                  <div class="">
                    <input type="text" name="masv" value="<%= muontra.getMasv()%>">
                  </div>
                </div>
                
                <div class="">
                  <label  class="">Mã sách</label>
                  <div class="">
                    <input type="text" name="masach" value="<%=muontra.getMasach()%>">
                  </div>
                </div>
                <div class="">
                  <div class="">
                  	<input type="hidden" name="mamuontra" value="<%= mamuontra %>">
                    <input type="submit"  value="Sửa"></input>
                  </div>
                </div>
              </form>
        </div>
    </div>
    <div id="footer">
        <div class="contact">
            <p>Copyright © 2023-2024 Loan Nhu Hang</p>
            <div class="img-amex">
                <img src="images/Vector (1).png" alt="">
            </div>
            
            <div class="img-visa">
                <img src="images/Vector.png" alt="">
            </div>
            <div class="img-round">
                <img src="images/uim_master-card.png" alt="">
            </div>
        </div>
        <div class="clear"></div>
    </div>
</body>
</html>