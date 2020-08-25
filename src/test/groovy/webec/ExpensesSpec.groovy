package webec

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ExpensesSpec extends Specification implements DomainUnitTest<Expenses> {

    def setup() {
    }

    def cleanup() {
    }

    void "Find a entry and delete it"() {
        //Creat new Expense
        setup:
        def user = new User(username: "testUser", password: "123")
        def expense = new Expenses(creditor: user, amount: 99, comment: "Test Entry")
        when:
        expense.validate()
        then:
        expense.save()

        //Find the Expense
        when:
        def findetExpense = Expenses.findAllByAmount(99)
        then:
        findetExpense != null

        //Delete Expense
        when:
        def expenseToDelete = Expenses.get(1)
        then:
        expenseToDelete.id == 1
        expenseToDelete.amount == 99
        and:
        expenseToDelete.delete()
        and:
        expenseToDelete.count() == 0
    }


}
