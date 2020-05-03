<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<table border="1">
    <tbody>
    <#list user.name as user>
        <tr>
            <td>${user.x}</td>
            <td>${user.y}</td>
            <td>${user.operation}</td>
            <td>${user.result}</td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>
