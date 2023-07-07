<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
if (session.getAttribute("admin") == null) {
	response.sendRedirect("index.jsp");
}
%>
<jsp:include page="../partials/header.jsp" />
<!-- Page Wrapper -->
<div id="wrapper">

	<jsp:include page="../partials/sidebar.jsp" />

	<!-- Content Wrapper -->
	<div id="content-wrapper" class="d-flex flex-column">

		<!-- Main Content -->
		<div id="content">
			<jsp:include page="../partials/topbar.jsp" />

			<!-- Begin Page Content -->
			<div class="container-fluid">
				<%
				if (session.getAttribute("msg") != null) {
				%>
				<div class="alert alert-warning">${msg}</div>
				<%
				session.removeAttribute("msg");
				%>
				<%
				}
				%>
				<!-- Page Heading -->
				<div
					class="d-sm-flex align-items-center justify-content-between mb-4">
					<h1 class="h3 mb-0 text-gray-800">Create Category</h1>
					<a href="index.jsp"
						class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
						class="fas fa-list fa-sm text-white-50"></i> View All Categories</a>
				</div>

				<!-- Content Row -->
				<div class="row">
					<div class="col mb-4">
						<div class="card shadow h-100 py-2">
							<div class="card-body">
								<%
								HashMap<String, String> errors = (HashMap) session.getAttribute("errors");
								if (errors == null) {
									errors = new HashMap<>();
								}
								%>
								<form action="store" method="post">
									<div class="form-group">
										<label for="title">Title</label> <input type="text"
											class="form-control" id="title" name="title"
											placeholder="Enter Category Title">
										<%
										if (errors.get("title") != null) {
										%>
										<span class="error">${errors.title}</span>
										<%
										}
										%>
									</div>
									<div class="form-group">
										<label for="status">Status</label> <select
											class="form-control" name="status" id="status">
											<option value="">---Select Status---</option>
											<option value="Active">Active</option>
											<option value="Inactive">Inactive</option>
										</select>
										<%
										if (errors.get("status") != null) {
										%>
										<span class="error">${errors.status}</span>
										<%
										}
										%>
									</div>
									<div class="form-group">
										<button type="submit" class="btn btn-primary">Create
											Category</button>
									</div>
								</form>
							</div>
						</div>
					</div>

				</div>
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- End of Main Content -->
		<jsp:include page="../partials/sticky-footer.jsp" />
	</div>
	<!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top"> <i
	class="fas fa-angle-up"></i>
</a>
<jsp:include page="../partials/footer.jsp" />