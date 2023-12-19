<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/stylehomes.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Lexend+Deca:wght@100;200;300;400;500;600;700;800;900&family=Montserrat:wght@100&family=Mulish:wght@300&family=Roboto+Condensed:wght@300&family=Space+Mono&family=Titillium+Web:wght@200&family=Ubuntu:wght@300&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link href="https://fonts.googleapis.com/css2?family=Josefin+Sans&display=swap" rel="stylesheet">
    <title>Library</title>
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
                        <a href="login.jsp">Sách</a>
                        <ul class="submenu">
                            <li><a href="login.jsp">Thêm sách</a></li>
                            <li><a href="login.jsp">Kiểm tra sách</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="login.jsp">Mượn trả</a>
                        <ul class="submenu">
                            <li><a href="login.jsp">Thêm thông tin mượn trả</a></li>
                            <li><a href="login.jsp">Kiểm tra thông tin mượn trả</a></li>
                        </ul>
                    </li>
                    <li><a href="login.jsp">Bạn đọc</a></li>
                    <li><a href="login.jsp">Quá hạn</a></li>
                </ul>
            </div>
            <div class="brand">
                <a href="">L I B R A R Y</a>
            </div>
            <div class="user-all">
                <div class="log">
                    <a href="login.jsp">Đăng nhập</a>
                </div>
                <div class="user">
                    <a href="login.jsp"><img src="images/user.png" alt=""></a>
                </div>
            </div>
        </div>  
    </div>
    <div id="main">
        <div class="main-intro">
            <h2>CHÀO MỪNG BẠN ĐẾN VỚI TRANG WEB QUẢN LÝ THƯ VIỆN</h2>
            <p>
				Chào thủ thư, dưới đây là một hướng dẫn ngắn cho hệ thống quản lý thư viện: <br>
			
				Đầu tiên, bạn phải đăng nhập <br>
				
				<b>Thêm Sách:</b>  Chọn "Thêm sách" và điền thông tin sách cần thêm.<br>
				- Kiểm Tra Sách:Sử dụng chức năng "Kiểm tra sách" để lọc và xem danh sách sách theo các tiêu chí như tên sách, mã thủ thư, thể loại, ngày nhập, vv.<br>
				
				<b>Quản Lý Mượn Trả:</b><br>
				- Thêm thông tin mượn trả bằng cách nhấn "Thêm thông tin mượn trả."<br>
				- Kiểm tra thông tin mượn trả sử dụng bộ lọc để tìm kiếm và xem các thông tin cần thiết.<br>
				
				<b>Quản Lý Bạn Đọc:</b><br>
				- Để thêm bạn đọc mới, chọn "Thêm bạn đọc" và nhập thông tin liên quan.<br>
				- Sử dụng chức năng "Kiểm tra bạn đọc" để lọc và xem danh sách bạn đọc.<br>
				
				<b>Quản Lý thời gian trả:</b><br>
				- Để xem sách quá hạn, truy cập mục "Quá Hạn" để kiểm tra và thực hiện các bước cần thiết.<br>
				
				<b>Đăng Xuất:</b><br>
				An toàn thông tin bằng cách nhấn "Đăng Xuất" khi bạn hoàn tất công việc.<br>
				Chúc bạn sử dụng hệ thống hiệu quả! Nếu cần trợ giúp, liên hệ với chúng tôi.</p>
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