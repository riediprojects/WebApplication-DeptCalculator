<!DOCTYPE html>
<html lang="en">
<head>

    <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.css')}" type="text/css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Login</title>

    <style media="screen">

    body {
        margin: 20px;
        margin-top: 40px;
    }

    #infoText {
        color: red;
    }

    #loginBorder {
        border: 1px solid #e8e8e9;
        padding: 30px;
        margin: auto;
        max-width: 450px;
    }


    .btn-primary {
        background-color: #27ae60;
        border-color: #27ae60;
        border-radius: 0px;
        width: 250px;
        height: 50px;

    }

    .btn-primary:hover {
        background-color: #2ecc71;
        border-color: #2ecc71;
    }


    .getPadding {
        margin: 15px;
    }


    .form-control {
        background: transparent;
        border: none;
        border-bottom: 1px solid #bdc3c7;
        border-radius: 0;
    }

    .form-control:focus {
        -webkit-box-shadow: none;
        box-shadow: none;
        border-color: #2ecc71;

    }
        h3 {
            text-align: center;
            color: #4e555b;
        }


    </style>
</head>


<body>

<div id="loginBorder">
    <div class="container" >
        <h3>DEBT CALCULATOR 3000</h3>

        <div class="col justify-content-center">

            <div class="row">

                <div id="infoText">
                    <g:if test='${flash.message}'>
                        <div class="login_message">${flash.message}</div>
                    </g:if>
                </div>
            </div>


            <div class="row justify-content-center">
                <form action="${postUrl ?: '/login/authenticate'}" method="POST" autocomplete="off">
                    <div class="form-row">
                        <input placeholder="username" type="text" class="text_ form-control getPadding"
                               name="${usernameParameter ?: 'username'}"/>
                    </div>

                    <div class="form-row">
                        <input placeholder="password" type="password" class="text_ form-control getPadding"
                               name="${passwordParameter ?: 'password'}"/>
                    </div>

                    <div class="form-row form-check justify-content-center getPadding">
                        <input type="checkbox" class="form-check-input" name="${rememberMeParameter ?: 'remember-me'} "
                               <g:if test='${hasCookie}'>checked="checked"</g:if>/>
                        <label class="form-check-label">Stay logged in</label>
                    </div>

                    <div class="form-row">
                        <input type="submit" class="btn btn-primary"
                               value="${message(code: 'springSecurity.login.button')}"/>
                    </div>
                </form>
            </div>

        </div>

    </div>
</div>



<script>
    (function () {
        document.forms['loginForm'].elements['${usernameParameter ?: 'username'}'].focus();
    })();
</script>
</body>
</html>
