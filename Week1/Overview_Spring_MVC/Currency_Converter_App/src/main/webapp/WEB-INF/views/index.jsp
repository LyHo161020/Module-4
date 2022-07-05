<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 19/06/2022
  Time: 9:58 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <form method="post">
            <div class="mb-3">
                <label for="exchangeRate" class="form-label">Tỉ giá</label>
                <input type="number" class="form-control" id="exchangeRate" aria-describedby="emailHelp" name = "exchangeRate">
            </div>

            <div class="mb-3">
                <label for="money" class="form-label">Tiền(USD)</label>
                <input type="number" class="form-control" id="money" name="money">
            </div>

            <button type="submit" class="btn btn-primary">Convert</button>
        </form>
    </div>
</body>
</html>
