<%@page import="com.models.sachDB"%>
<%@page import="com.models.sach"%>
<%@page import="java.util.List"%>
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
    <title>See books</title>
</head>
<body>
<%
    String tenSachFilter = request.getParameter("tenSachFilter");
    String maThuThuFilter = request.getParameter("maThuThuFilter");
    String theLoaiFilter = request.getParameter("theLoaiFilter");
    String ngayNhapFilter = request.getParameter("ngayNhapFilter");
    
    List<sach> sachList = sachDB.getFilteredBooks(tenSachFilter, maThuThuFilter, theLoaiFilter, ngayNhapFilter);
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
            <div class="top-main">
                <div class="tit">
                    <h3>Kiểm tra sách</h3>
                </div>
                <form action="addbooks.jsp">
                <div class="">
                  <div class="">
                    <input type="submit"  value="Thêm sách"></input>
                  </div>
                </div>
            	</form>
            </div>
            <div class="filter-form">
            	<form action="seebooks.jsp" method="get">
				    <label>Tên sách:</label>
				    <input type="text" name="tenSachFilter" value="<%= (request.getParameter("tenSachFilter") != null) ? request.getParameter("tenSachFilter") : "" %>">
				    <label>Mã thủ thư:</label>
				    <input type="text" name="maThuThuFilter" value="<%= (request.getParameter("maThuThuFilter") != null) ? request.getParameter("maThuThuFilter") : "" %>">
				    <label>Thể loại:</label>
				    <input type="text" name="theLoaiFilter" value="<%= (request.getParameter("theLoaiFilter") != null) ? request.getParameter("theLoaiFilter") : "" %>"><br>
				    <label>Ngày nhập:</label>
				    <input type="text" name="ngayNhapFilter" value="<%= (request.getParameter("ngayNhapFilter") != null) ? request.getParameter("ngayNhapFilter") : "" %>">
				    <input type="submit" value="Lọc">
				</form>
            </div>
            <div class="book-table">
                <table>
                    <thead>
                        <tr>
                            <th>Mã sách</th>
                            <th>Tên sách</th>
                            <th>Số lượng sách</th>
                            <th>Ngày nhập</th>
                            <th>Mã thủ thư</th>
                            <th>Thể loại</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                		for (sach sach : sachList) {
					%> 
                			
                			<tr>
                                <td><%= sach.getMasach() %></td>
                                <td><%= sach.getTensach() %></td>
                                <td><%= sach.getSlsach() %></td>
                                <td><%= sach.getNgaynhap() %></td>
                                <td><%= sach.getMathuthu() %></td>
                                <td><%= sach.getTheloai() %></td>
                                <td>
                                    <form action="updatebooks.jsp">
                                    	<input type="hidden" name="masach" value="<%=sach.getMasach()%>">
										<input class="btn btn-outline-dark" type="submit"  value="Update">
                                    </form>
                                </td>
                                <td>
                                    <form action="deletebookServlet" onsubmit="return confirmDelete('<%=sach.getMasach()%>')">
									    <input type="hidden" name="masach" value="<%=sach.getMasach()%>">
									    <input class="btn btn-outline-dark" type="submit" value="Delete">
									</form>
									
									<script>
									    function confirmDelete(maSach) {
									        var isConfirmed = confirm("Bạn có chắc chắn muốn xóa mã sách: " + maSach + "?");
									
									        return isConfirmed;
									    }
									</script>

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