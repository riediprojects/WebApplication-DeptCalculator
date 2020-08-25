<!DOCTYPE html>
<html lang="en">
<head>
    <title><g:layoutTitle default="Grails"/></title>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'myBootstrapExtended.css')}" type="text/css">
    <!--Quelle Bootstrap: Improves mobile responive aspects-->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

</head>

<body>

<div class="container">

    <!--Navigation-->
    <div class="row">
        <div class="col-sm-12">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="/person/newExpense">Add</a>
                <a class="navbar-brand" href="/expenses/getAllExpenses">Expenses</a>
                <a class="navbar-brand" href="/expenses/getDeptPerPerson">Depts</a>
                <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
                    <ul class="navbar-nav ml-auto">
                        <li>
                            <g:img dir="images" file="skin/logo.png" width="55" height="55" alt="not found"/>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>


    <!--Content-->
    <div class="row">

        <!--left block-->
        <div class="col-sm-8 sideInfoSpaces order-sm-2">
            <div id="contentRight">
                <g:pageProperty name="page.contentRight"/>
            </div>
        </div>

        <!--right block-->
        <div class="col-sm-4 sideInfo order-sm-1">

            <!--My Money information-->
            <div class="sideInfoSpaces">
                <h5>My Money</h5>
                <hr>

                <div>
                    <g:myDepts>
                        <g:set var="myVariable" value="${it}"/>
                        <g:if test="${myVariable.contains('+')}">
                            <div class="visualValues positive">${myVariable}</div>
                        </g:if>
                        <g:else>
                            <div class="visualValues negative">${myVariable}</div>
                        </g:else>
                    </g:myDepts>
                </div>

                <div class="visualValues neutral">
                    <g:myExpenses></g:myExpenses>
                </div>
            </div>

            <!--Logged-In information-->
            <div class="col sideInfoSpaces">
                <h5>Logged as</h5>
                <hr>
                <h6><g:currentUser></g:currentUser></h6>
                <a href="/logout/index" class="btn btn-outline-danger" role="button">Sign Out</a>
            </div>
        </div>
    </div>
    <g:layoutBody/>
    <div class="col-sm-12 footer">
        <p class="smallTextes">&copy;2019 Manu</p>
    </div>
</div>
</body>
</html>