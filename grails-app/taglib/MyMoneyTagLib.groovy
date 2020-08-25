class MyMoneyTagLib {

    //provides security utility functions..
    def springSecurityService

    def currentUser = {attrs, body ->
        out <<body() << (springSecurityService.currentUser.username)
    }

    def myDepts = { attrs, body ->
        double currentUserDept = springSecurityService.currentUser.dept
        def deptFormated = formatNumber(number: currentUserDept, type: "currency", currencyCode: "CHF")
        out << body(currentUserDept >= 0 ? "Credit:  +" + deptFormated : "Depts: " + deptFormated)
    }

    def myExpenses = { attrs, body ->
        double currentUserExpenses = springSecurityService.currentUser.totalExpenses
        def deptFormated = formatNumber(number: currentUserExpenses, type: "currency", currencyCode: "CHF")
        out << body() << ("Expenses: " + deptFormated)
    }







}