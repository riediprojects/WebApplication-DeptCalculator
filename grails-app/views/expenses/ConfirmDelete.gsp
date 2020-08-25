<!DOCTYPE html>

<html>
<head>
    <title>Confirm Delete</title>
    <meta name="layout" content="mainLayout">
</head>

<body>

<content tag="contentRight">

    <div class="alert alert-light" role="alert">

        <h4 class="alert-heading">Are you sure you want to delete the following entry?</h4>

        <p></p>
        <dl class="row">
            <dt class="col-sm-3">Creditor</dt>
            <dd class="col-sm-9">${expense.creditor.username}</dd>
            <dt class="col-sm-3">Amount</dt>
            <dd class="col-sm-9">${expense.amount}</dd>
            <dt class="col-sm-3">Comment</dt>
            <dd class="col-sm-9">${expense.comment}</dd>
        </dl>
        <hr>

        <g:link controller="expenses" class="btn btn-primary" action="delete" params="[id: expense.id]">YES
        </g:link>

        <g:link url="${request.getHeader('referer')}" class="btn btn-link">
            CANCEL
        </g:link>

    </div>
</content>

</body>
</html>