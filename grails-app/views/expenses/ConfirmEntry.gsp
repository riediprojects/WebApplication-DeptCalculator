<!DOCTYPE html>

<html>
<head>
    <meta name="layout" content="mainLayout">
    <title>Input Overview</title>

</head>

<body>
<content tag="contentRight">
    <div class="card">
        <div class="card-header">
            Your Entry
        </div>

        <div class="card-body">
            <dl class="row">
                <dt class="col-sm-3">Creditor</dt>
                <dd class="col-sm-9">${creditor.username}</dd>
                <dt class="col-sm-3">Amount</dt>
                <dd class="col-sm-9">
                    <g:formatNumber number="${amount}" type="currency" currencyCode="CHF"/>
                </dd>
                <dt class="col-sm-3">Created by</dt>
                <dd class="col-sm-9"><p>${user.username}</p></dd>
                <dt class="col-sm-3">Comment</dt>
                <dd class="col-sm-9"><p>${comment}</p></dd>
            </dl>
            <a href="/expenses/getAllExpenses" class="btn btn-block">Go to Expenses overview</a>
        </div>
    </div>
</content>

</body>
</html>