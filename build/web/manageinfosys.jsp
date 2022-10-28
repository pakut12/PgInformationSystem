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
                            <div class="card">
                                <div class="card-header">
                                    InformationSystem
                                </div>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-md-6 col-sm-12">
                                            <div class="input-group input-group-sm mb-3">
                                                <span class="input-group-text" >UserId</span>
                                                <input type="text" class="form-control text-center" name="UserId" id="UserId">
                                            </div>
                                            <div class="input-group input-group-sm mb-3">
                                                <span class="input-group-text" >ComputerName</span>
                                                <input type="text" class="form-control text-center" name="ComputerName" id="ComputerName" readonly>
                                            </div>
                                            <div class="input-group input-group-sm mb-3">
                                                <span class="input-group-text" >Ip</span>
                                                <input type="text" class="form-control text-center" name="Ip" id="Ip" readonly>
                                            </div>
                                            <div class="input-group input-group-sm mb-3">
                                                <span class="input-group-text" >OS</span>
                                                <input type="text" class="form-control text-center" name="OS" id="OS" readonly>
                                            </div>
                                        </div>
                                        <div class="col-md-6 col-sm-12 overflow-auto" style="height:180px">
                                            <ul class="list-group ">
                                                
                                            </ul> 
                                        </div>
                                        <div class="d-grid gap-2">
                                            <button type="button" class="btn btn-success btn-sm mt-3" id="btn-getdata">ลงทะเบียน</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="card mt-3">
                                <div class="card-header">
                                    ViewInformationSystem
                                </div>
                                <div class="card-body">
                                    <table class="table table-striped table-sm table-bordered " id="mytable">
                                        <thead>
                                            <tr>
                                                <th>a</th>
                                                <th>b</th>
                                                <th>c</th>
                                                <th>d</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>a</td>
                                                <td>b</td>
                                                <td>c</td>
                                                <td>d</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
            
        </form>
        <script>
            $( document ).ready(function() {
                $("#page2").addClass("active");
                $("#mytable").DataTable();
                function GetdataInfo(){
                    $.ajax({
                        type:"POST",
                        url:"GetDataInformationSystem",
                        success:function(data){
                            var infosys = $.parseJSON(data);
                            console.log(infosys);
                            $("#ComputerName").val(infosys.ComputerName);
                            $("#Ip").val(infosys.Ip);
                            $("#OS").val(infosys.OS);
                            $(".list-group").append(infosys.Program);
                        }
                    });
                }
                $("#btn-getdata").click(function(){
                    var dataform =  $("#MyForm").serialize();
                    $("input:checkbox:checked").each(function () {
                        alert($(this).val());
                    });
                    console.log(dataform);
                     
                });
                GetdataInfo();
                
            });
        </script>
        <footer>
            <%@include file="share/footer.jsp"%> 
        </footer>
    </body>
</html>
