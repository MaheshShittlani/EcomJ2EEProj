<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Admin Login | Ecom</title>

    <!-- Custom fonts for this template-->
    <link href="<%=application.getContextPath()%>/admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<%=application.getContextPath()%>/admin/css/sb-admin-2.min.css" rel="stylesheet">
    <link href="<%=application.getContextPath()%>/admin/css/custom.css" rel="stylesheet">

</head>

<% 
	String  bodyAttributes = "";
	String[] parts =  request.getRequestURI().split("/"); 
	String requestPage = parts[parts.length-1];
   if(!requestPage.endsWith(".jsp")) {
	   bodyAttributes = "class=\"bg-gradient-primary\"";
   } else if(requestPage.endsWith("index.jsp")) {
	   bodyAttributes = "class=\"bg-gradient-primary\"";
   }  else {
	   bodyAttributes = "id=\"page-top\"";
   }
%>
<body <%=bodyAttributes %>>