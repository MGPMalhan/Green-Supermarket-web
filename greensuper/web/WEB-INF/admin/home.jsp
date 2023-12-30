<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin Home</title>
       <c:import url="includes/header.jsp" />
    </head>
    <body class="sb-nav-fixed">
        <c:import url="includes/nav.jsp" />
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <c:import url="includes/sidenav.jsp" />
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Dashboard</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Dashboard</li>
                        </ol>
                        <div class="row">
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-primary text-white mb-4">
                                    <div class="card-body">No of products</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link"><c:out value="${ requestScope.count }" /></a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
       
                        </div>

                    </div>
                </main>
            </div>
        </div>
    </body>
</html>