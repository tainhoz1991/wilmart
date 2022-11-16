<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="/css/create_user.css"/>" />
</head>

<body>
<div class="container">
    <form action="/users/update" method="post">
        <div class="row">
            <div class="col-25">
                <label for="fname">Full Name</label>
            </div>
            <div class="col-75">
                <input type="text" id="fname" name="fullName" placeholder="${user.fullName}">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="department">Department</label>
            </div>
            <div class="col-75">
                <input type="text" id="department" name="department" placeholder="${user.department}">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="gender">Gender</label>
            </div>
            <div class="col-75">
                <select id="gender" name="gender">
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="yobirth">Year of birth</label>
            </div>
            <div class="col-75">
                <input type="text" id="yobirth" name="year" placeholder="${user.year}">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="email">Email</label>
            </div>
            <div class="col-75">
                <input type="text" id="email" name="email" placeholder="${user.email}">
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <label for="mphone">Mobile phone</label>
            </div>
            <div class="col-75">
                <input type="text" id="mphone" name="mobilePhone" placeholder="${user.mobilePhone}">
            </div>
        </div>
        <div class="row">
            <input type="submit" value="Create">
        </div>
    </form>
</div>
</body>

</html>