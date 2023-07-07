<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
if (session.getAttribute("admin") == null) {
	response.sendRedirect("index.jsp");
}
%>
<jsp:include page="partials/header.jsp" />
<!-- Page Wrapper -->
<div id="wrapper">

	<jsp:include page="partials/sidebar.jsp" />

	<!-- Content Wrapper -->
	<div id="content-wrapper" class="d-flex flex-column">

		<!-- Main Content -->
		<div id="content">
			<jsp:include page="partials/topbar.jsp" />

			<!-- Begin Page Content -->
			<div class="container-fluid">
				<% if(session.getAttribute("msg") != null) { %>
				<div class="alert alert-warning">${msg}</div>
					<% session.removeAttribute("msg"); %>
				<% } %>
				<!-- Page Heading -->
				<div
					class="d-sm-flex align-items-center justify-content-between mb-4">
					<h1 class="h3 mb-0 text-gray-800">Change Profile</h1>
				</div>

				<!-- Content Row -->
				<div class="row">
					<div class="col mb-4">
						<div class="card shadow h-100 py-2">
							<div class="card-body">
								<div class="row">
									<div class="col-xl-6 col-lg-6 col-md-12 col-sm-12 col-xs-12">
										<% HashMap<String,String>errors = (HashMap<String,String>)session.getAttribute("errors");%>
										<form action="updateProfile" method="post">
											<div class="form-group">
												<label for="name">Name</label> <input type="text"
													class="form-control" id="name" name="name"
													placeholder="Enter Name" value="${admin.name}">
													<% if(errors.get("name") != null) { %>
														<span class="error">${errors.name}</span>
													<% } %>
											</div>
											<div class="form-group">
												<label for="email">Email</label> <input type="email"
													class="form-control" id="email" name="email"
													placeholder="Enter Email" value="${admin.email}" disabled> <span
													class="error">${errors.email}</span>
											</div>
											<div class="form-group">
												<label for="mobile">Mobile</label> <input type="text"
													class="form-control" id="mobile" name="mobile"
													placeholder="Enter Mobile" value="${admin.mobile}">
												<span class="error">${errors.mobile}</span>
											</div>
											<div class="form-group">
												<button type="submit" class="btn btn-primary">Update
													Profile</button>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- End of Main Content -->
		<jsp:include page="partials/sticky-footer.jsp" />
	</div>
	<!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top"> <i
	class="fas fa-angle-up"></i>
</a>
<jsp:include page="partials/footer.jsp" />