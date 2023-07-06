<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="partials/header.jsp" />
<div class="container">
	<!-- Outer Row -->
	<div class="row justify-content-center">
		<div class="col-xl-10 col-lg-12 col-md-9">
			<div class="card o-hidden border-0 shadow-lg my-5">
				<div class="card-body p-0">
					<!-- Nested Row within Card Body -->
					<div class="row">
						<div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
						<div class="col-lg-6">
							<div class="p-5">
								<div class="text-center">
									<h1 class="h4 text-gray-900 mb-4">Welcome Admin!</h1>
								</div>
								<%
								if (session.getAttribute("msg") != null) {
								%>
								<div class="alert alert-danger" role="alert">${msg}</div>
								<%
								}
								%>
								<form class="user" method="post" action="login">
									<div class="form-group">
										<input type="text" class="form-control form-control-user"
											id="email" name="email" aria-describedby="emailHelp"
											placeholder="Enter Email Address..."> <span
											class="error">${errors.email}</span>
									</div>
									<div class="form-group">
										<input type="password" class="form-control form-control-user"
											id="password" name="password" placeholder="Password">
										<span class="error">${errors.password}</span>
									</div>
									<button type="submit"
										class="btn btn-primary btn-user btn-block">Login</button>
									<%
									session.removeAttribute("errors");
									%>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="partials/footer.jsp" />
