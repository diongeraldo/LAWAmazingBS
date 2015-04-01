<%-- 
    Document   : display
    Created on : Apr 1, 2015, 2:18:05 PM
    Author     : Dion Geraldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Amazing.DatabaseInfo" %>
<%@page import="Amazing.Buku" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Display Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
        <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
    </head>
    <body style="font-family: 'Roboto', sans-serif;">
        <h1>Daftar Buku</h1>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>#ID</th>
                    <th>Judul</th>
                    <th>Pengarang</th>
                    <th>Tahun Terbit</th>
                    <th>Jenis</th>
                </tr>
            </thead>
            
            <tbody>
                <% 
                    DatabaseInfo db = new DatabaseInfo();
                    ArrayList<Buku> mybook = new ArrayList<Buku>();
                    
                    mybook = db.getAllBooks();
                    
                    for(Buku b : mybook){
                %>
                <tr>
                    <td> <&= b.getId() &> </td>
                    <td> <&= b.getJudul() &> </td>
                    <td> <&= b.getPengarang() &> </td>
                    <td> <&= b.getTahunTerbit() &> </td>
                    <td> <&= b.getJenis() &> </td>
                </tr>
                <%
                    }
                %>
            </tbody>
            
        </table>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    </body>
</html>
