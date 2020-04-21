<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <table bgcolor="#ff7f50" border="1">
        <tbody>
        <#list students as student>
            <tr>
                <td>${student.name}</td>
                <td>${student.age}</td>
                <td>${student.group}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</body>
</html>