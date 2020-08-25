<!DOCTYPE html>

<html>
<head>
    <meta name="layout" content="mainLayout">
    <title>Expenses</title>

</head>

<body>

<content tag="contentRight">
    <h5>All Expenses</h5>
    <hr>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Creditor</th>
            <th>Cost (CHF)</th>
            <th>Comment</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <g:each var="expense" in="${expenses}">
            <tr>
                <td>${expense.creditor.username}</td>
                <td>${expense.amount}</td>
                <td>${expense.comment}</td>
                <td>
                    <g:link class="btn btn-light btn-sm" controller="expenses" action="confirmDelete"
                            params="[id: expense.id]">x</g:link>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
</content>

</body>
</html>