<%-- 
    Document   : index
    Created on : 27 ต.ค. 2565, 8:25:37
    Author     : pakutsing
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
    <head>
        <%@include file="share/head.jsp"%> 
    </head>
    
    <body>
        <%@include file="share/nav.jsp"%> 
        <form id="MyForm">
            <div class="container">
                <div class="mt-5">
                    <div class="card shadow col-md-9 col-sm-12 mx-auto">
                        <div class="card-header text-center">PgInformationSystem</div>
                        <div class="card-body">
                            <table class="table table-striped table-sm table-bordered" id="mytable">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Program</th>
                                        <th>Edit</th>
                                        <th>Del</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>ID</td>
                                        <td>Program</td>
                                        <td>Edit</td>
                                        <td>Del</td>
                                    </tr>
                                </tbody>
                                
                            </table>
                            
                        </div>
                    </div>
                    
                </div>
            </div>
            
        </form>
        <script>
            $( document ).ready(function() {
                $("#page3").addClass("active");
                $("#mytable").DataTable();
            });
        </script>
        <footer>
            <%@include file="share/footer.jsp"%> 
        </footer>
    </body>
</html>
