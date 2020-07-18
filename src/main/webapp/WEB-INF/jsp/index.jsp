<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/globalStyles.css" rel="stylesheet">
<link href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"
	rel="stylesheet">
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.jqueryui.min.css"
	rel="stylesheet">
<link
	href="https://cdn.datatables.net/scroller/2.0.1/css/scroller.jqueryui.min.css"
	rel="stylesheet">

</head>
<body>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.10.20/js/dataTables.jqueryui.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/scroller/2.0.1/js/dataTables.scroller.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<!-- <script type="text/javascript" src="js/ColReorderWithResize.js"></script> -->
	<script type="text/javascript" src="js/colResizable-1.6.min.js"></script>

	<h1>Welcome to App...</h1>
	<a href="/addUserPage">Add User</a><br/>
	<a href="/retrieveDataPage">Retrieve</a>
	<input type="button" value="submit" class="btn btn-xs btn-primary" />
	<input type="button" value="submit1" class="btn btn-xs" />

	<div class="container">
		<h2>Dynamic Tabs</h2>
		<p>To make the tabs toggleable, add the data-toggle="tab"
			attribute to each link. Then add a .tab-pane class with a unique ID
			for every tab and wrap them inside a div element with class
			.tab-content.</p>

		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#home">Home</a></li>&nbsp;&nbsp;&nbsp;
			<li><a data-toggle="tab" href="#menu1" onclick="getUsers();">Menu
					1</a></li>&nbsp;&nbsp;&nbsp;
			<li><a data-toggle="tab" href="#menu2" onclick="clicked2();"
				id="tab2">Menu 2</a></li>&nbsp;&nbsp;&nbsp;
			<li><a data-toggle="tab" href="#menu3">Menu 3</a></li>
		</ul>

		<div class="tab-content">
			<div id="home" class="tab-pane fade in active">
				<table id="testTable" border="1">
					<tr>
						<th>H1</th>
						<th>H2</th>
						<th>H3</th>
						<th>H4</th>
					</tr>
					<tr>
						<td>1</td>
						<td>2</td>
						<td>3</td>
						<td>4</td>
					</tr>
				</table>
			</div>
			<div id="menu1" class="tab-pane fade">
				<span id="userMenu"></span>
			</div>
			<div id="menu2" class="tab-pane fade">Menu2...</div>
			<div id="menu3" class="tab-pane fade">
					<div style="width: 100%;">
				   <div style="float:left; width: 80%">
				   Hello
				   </div>
				   <div style="float:right;">
				   hello2
				   </div>
				</div>
			</div>
		</div>
	</div>

	
	<div class="container">
    <div class="row">
        <div class="col-md-6">
            <!-- Nav tabs -->
            <ul class="nav nav-tabs" role="tablist">
                <li role="presentation" class="active"><a href="#Section1" aria-controls="home" role="tab" data-toggle="tab"><i class="fa fa-envelope-o"></i>Section 1</a></li>
                <li role="presentation"><a href="#Section2" aria-controls="profile" role="tab" data-toggle="tab"><i class="fa fa-cube"></i>Section 2</a></li>
                <li role="presentation"><a href="#Section3" aria-controls="messages" role="tab" data-toggle="tab"><i class="fa fa-comment"></i>Section 3</a></li>
            </ul>
 
            <!-- Tab panes -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane fade in active" id="Section1">
                    <h4>Section 1</h4>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer hendrerit dui vitae leo efficitur, et rutrum nisi fermentum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia.
                    </p>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="Section2">
                    <h4>Section 2</h4>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer hendrerit dui vitae leo efficitur, et rutrum nisi fermentum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia.
                    </p>
                </div>
                <div role="tabpanel" class="tab-pane fade" id="Section3">
                    <h4>Section 3</h4>
                    <p>
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer hendrerit dui vitae leo efficitur, et rutrum nisi fermentum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia.
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
	
	<input type="button" class="btn" value="test"/>
	<table id="example" class="display nowrap" style="width: 100%">
		<thead>
			<tr>
				<th>ID</th>
				<th>First name</th>
				<th>Last name</th>
				<th>Phone</th>
				<th>Email</th>
				<th>Address</th>
			</tr>
		</thead>
	</table>
	<input type="hidden" value="${pageContext.request.contextPath}"
		id="contextPath" />
</body>
</html>