<!doctype html>
<html>
<head>
    <meta name="layout" content="mainLayout">
    <title>New Expense</title>

</head>

<body>
<content tag="contentRight">
    <h5>New Entry</h5>

    <hr>

    <div class="container my-container">
        <form action="/expenses/newEntry" method="POST">
            <div class="form-row">
                <!--Creditor-->
                <div class="col-md-6 mb-3">

                <label for="creditorName">Creditor</label> <span class="errorMessage" style="white-space: nowrap;">&nbsp;${errorMessage}</span>

                    <select class="form-control selectBar" id="creditorName" name="creditorName"
                            size="${persons.size()}">
                        <g:each var="person" in="${persons}">
                            <option value= ${person.username}>${person.username}</option>
                        </g:each>
                    </select>
                </div>
                <!--Amaount-->
                <div class="col-md-6 mb-3">
                    <label for="amount">Amount</label>
                    <input class="form-control" id="amount" name="amount" type="number" step="0.05" value="${amount}">
                </div>
            </div>

            <div class="form-row">
                <!--Comment-->
                <div class="col-md-12 mb-3">
                    <label for="comment">Comment</label>
                    <textarea class="form-control" id="comment" name="comment" rows="2" cols="10">${comment}</textarea>
                </div>
            </div>

            <div class="form-row">
                <!--Submit-->
                <div class="col mb-3">
                    <button name="subject" type="submit" class="btn btn-primary" value="HTML">Save</button>
                </div>
            </div>
        </form>

    </div>
</content>

</body>

</html>