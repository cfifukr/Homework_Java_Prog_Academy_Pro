<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Prog Academy chat server</title>
</head>
<body>
    <br><h2>Log in</h2>
    <form action="/get" method="POST">
        <div class="input-group mb-3">
            <span class="input-group-text" id="basic-addon1">@</span>
            <input type="text" class="form-control" name = "user" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
        </div>
        <button type="submit" class = "btn btn-dark ">Submit</button>
    </form>
</body>
</html>