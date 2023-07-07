<%@page import="com.ecom.model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ecom.persistence.CategoryDAO"%>
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
				<% if(session.getAttribute("msg") != null) { %>
				<div class="alert alert-warning">${msg}</div>
					<% session.removeAttribute("msg"); %>
				<% } %>
				<!-- Page Heading -->
				<div
					class="d-sm-flex align-items-center justify-content-between mb-4">
					<h1 class="h3 mb-0 text-gray-800">Categories</h1>
					<a href="category/create.jsp"
						class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
							class="fas fa-plus-circle fa-sm text-white-50"></i> Create Category</a>
				</div>

				<!-- Content Row -->
				<div class="row">
					<div class="col mb-4">
						<div class="card shadow h-100 py-2">
							<div class="card-body">
								<div class="row">
									<div class="col">
										<table class="table table-bordered table-striped">
											<thead>
											<tr>
												<th>S.No.</th>
												<th>Title</th>
												<th>Status</th>
												<th>Created At</th>
												<th>Updated At</th>
												<th>Action</th>
											</tr>
											</thead>
											<tbody>
												<%	
													int i = 1;
													ArrayList<Category>categories =  (ArrayList<Category>)request.getAttribute("list");
													for(Category category: categories) {
														%>
														<tr>
															<td><%=i %></td>
															<td><%=category.getTitle() %></td>
															<td><%=category.getStatus() %></td>
															<td><%=category.getCreatedAt() %></td>
															<td><%=category.getUpdatedAt() %></td>
														</tr>
														<%
														i++;
													}
												%>
											</tbody>
											
										</table>
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