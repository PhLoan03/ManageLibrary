<%@page import="com.models.muontraDB"%>
<%@page import="com.models.muontra"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/styleseebooks.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lexend+Deca:wght@100;200;300;400;500;600;700;800;900&family=Montserrat:wght@100&family=Mulish:wght@300&family=Roboto+Condensed:wght@300&family=Space+Mono&family=Titillium+Web:wght@200&family=Ubuntu:wght@300&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link href="https://fonts.googleapis.com/css2?family=Josefin+Sans&display=swap" rel="stylesheet">
    <title> Quá hạn</title>
</head>
<body>
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
            <div class="top-main">
                <div class="tit">
                    <h3>Kiểm tra thông tin quá hạn</h3>
                </div>
            </div>
            
          
            <div class="book-table">
                <table>
                    <thead>
                        <tr>
                            <th>Mã mượn trả</th>
                            <th>Mã sinh viên</th>
                            <th>Mã sách</th>
                            <th>Ngày mượn</th>
                            <th>Trạng thái</th>
                            <th>Mã thủ thư</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                    	List<muontra> muontraList = muontraDB.getMuonTraQuaHan();
                        for (muontra muontra : muontraList) {
                    %> 
                        
                            <tr>
                                <td><%= muontra.getMamuontra()%></td>
                                <td><%= muontra.getMasv() %></td>
                                <td><%= muontra.getMasach() %></td>
                                <td><%= muontra.getNgaymuon() %></td>
                                <td><%= muontra.getTrangthai() %></td>
                                <td><%= muontra.getMathuthu() %></td>
                                <td style="display: flex; justify-content: flex-start;gap:10px">
                                	<form action="updatestatusServlet">
                                        <input type="hidden" name="mamuontra" value="<%=muontra.getMamuontra()%>">
                                        <input style="width: 70px; padding-left:10px; background-color: orange; color:black; " class="btn btn-outline-dark" type="submit"  value="Trả sách">
                                    </form>
                                </td>
                            </tr>
                     <%
                        }
                     %>
                    </tbody>
                </table>
            </div>
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
