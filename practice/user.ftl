<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>FreeMarker</title>
</head>
<body>

<form>
    First name: <input type="text" name="firstName" /><br/>
    Last name: <input type="text" name="lastName" /><br/>
    <input type="submit" value="Save" />
</form>

<table border="1">
    <thead>
    <tr>
        <th>FirstName</th>  <th>LastName</th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>