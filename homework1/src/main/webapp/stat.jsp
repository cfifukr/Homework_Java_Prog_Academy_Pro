<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="homework1.homework1.FormServlet" %>

<%
  Map<String, Integer> statGender =  new FormServlet().getGenderStat();
  Map<String, Integer> statOccupation =  new FormServlet().getOccupationStat();
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Stat</title>
</head>
<body>

<h2 class="text-center">Stat Gender</h2>
<table class="table table-dark table-striped">
  <thead>
  <tr>
    <th scope="col">Gender</th>
    <th scope="col">Times selected</th>
  </tr>
  </thead>

  <tbody>

  <% for (HashMap.Entry<String, Integer> entry : statGender.entrySet()){%>
  <tr>
    <td><%= entry.getKey() %></td>
    <td><%= entry.getValue() %></td>
  </tr>
  <%
    }
  %>
  </tbody>
</table>
<br>

<h2 class="text-center">Stat Occupation</h2>

<table class="table table-dark table-striped">
  <thead>
  <tr>
    <th scope="col">Occupation</th>
    <th scope="col">Times selected</th>
  </tr>
  </thead>

  <tbody>

  <% for (HashMap.Entry<String, Integer> entry : statOccupation.entrySet()){%>
  <tr>
    <td><%= entry.getKey() %></td>
    <td><%= entry.getValue() %></td>
  </tr>
  <%
    }
  %>
  </tbody>
</table>

<form action="${pageContext.request.contextPath}/form" method="get">
  <button class="btn btn-dark" type="submit">Go to Form</button>
</form>

</body>
</html>