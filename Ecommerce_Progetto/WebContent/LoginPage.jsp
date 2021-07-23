<!DOCTYPE html>

<html lang="en">

<head>

<title>VGHUB</title>

<meta charset="UTF-8">



<link rel="stylesheet" type="text/css" href="./css/form.css">



<meta name="robots" content="noindex, follow">

</head>

<body>

    <div class="wrapper fadeInDown">

        <div id="formContent">

          <!-- Tabs Titles -->

          <h2 class="active"> Login </h2>

          <h2 class="inactive underlineHover"><a href="RegisterPage.jsp">Registrazione </a></h2>

      

          <!-- Icon -->

          <div class="fadeIn first">


          </div>

      

          <!-- Login Form -->

          <form action="login" method="get" onsubmit="return validate();">

            <input type="text" id="login" class="fadeIn second" name="Username" placeholder="Username">

            <input type="text" id="password" class="fadeIn third" name="Password" placeholder="password">

            <input type="submit" class="fadeIn fourth" value="Log In">

          </form>

        </div>

      </div>

</body>

</html>