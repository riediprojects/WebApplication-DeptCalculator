<!DOCTYPE html>

<html>
<head>
    <meta name="layout" content="mainLayout">
    <title>Debts overview</title>

</head>

<body>

<content tag="contentRight">
    <p class="h5">All Depts</p>
    <hr>

    <table class="table table-borderless" id="table">
        <tbody>
        <g:each var="person" in="${debtors}">
            <tr>
                <td><div class="fontBasic deptName">${person.username}</div></td>
                <g:if test="${person.dept >= 0}">
                    <td><div class="visualValues positive">+<g:formatNumber number="${person.dept}" format="#.##"/></div></td>
                </g:if>
                <g:else>
                    <td><div class="visualValues negative"><g:formatNumber number="${person.dept}" format="#.##"/></div></td>
                </g:else>
            </tr>
        </g:each>
        </tbody>
    </table>
</content>
</body>
</html>