package webec


class Expenses {

    User creditor
    double amount
    String comment

    String toString() {
        return creditor.username
    }

    static constraints = {
        creditor()
        amount(blank: false, nullable: false)
        comment(nullable: true)
    }


}
