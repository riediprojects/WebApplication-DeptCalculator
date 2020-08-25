package webec

import grails.plugin.springsecurity.annotation.Secured
import org.springframework.dao.DataIntegrityViolationException

import javax.annotation.PostConstruct

@Secured([Role.ADMIN, Role.USER])
class ExpensesController {

    static scaffold = Expenses
    PersonController personController = new PersonController()

    //provides security utility functions.
    def springSecurityService


    /*
    @return all entries of expenses
     */

    def getAllExpenses() {
        List<Expenses> result = Expenses.findAll()

        render view: "ShowAllExpenses", model: [expenses: result]
    }

    /*
    Save new expense to database
     */

    def newEntry(String creditorName, double amount, String comment) {

        User creditor = User.findByUsername(creditorName)

        //Checks if creditor has been specified
        if (creditor == null) {
            String errorMessage = "Please choose a creditor"
            personController.newExpense(errorMessage, amount, comment)
        } else {
            Expenses e = new Expenses(creditor: creditor, amount: amount, comment: comment)
            e.save()
            calculateDeptPerPerson()

            //Gets the currently logged in user
            def user = springSecurityService.currentUser

            render view: "ConfirmEntry", model: [creditor: creditor, amount: amount, comment: comment, user: user]
        }
    }

    /*
     * Get depts for all User and for the current logged in user
     */

    @PostConstruct
    def getDeptPerPerson() {
        calculateDeptPerPerson()
        List<User> allUser = User.findAll()

        render view: "ShowAllDepts", model: [debtors: allUser]
    }

    /*
    Calculates how much spending each person made in total
    The total expenses of each person is a necessary part to calculate the depts between all the user.)
     */

    def getExpensePerPerson() {

        List<User> p = User.findAll()
        List<Expenses> expenses
        double totalSpending

        for (User per : p) {
            totalSpending = 0
            expenses = Expenses.findAllByCreditor(per)

            for (double sum : expenses.amount) {
                totalSpending = totalSpending + sum
            }

            per.setTotalExpenses(totalSpending)
            per.save(flush: true)
        }
    }

    /*
    Calculates the average of the total expenses each person has
    (Hint: This average is a necessary part to calculate the depts between all the user)
     */

    double calculateAverage() {
        getExpensePerPerson()
        List<User> p = User.findAll()
        double sumAmount = 0

        for (double amount : p.totalExpenses) {
            sumAmount = sumAmount + amount
        }
        double mean = sumAmount / p.size()

        return mean
    }

    /*
    Calculates for every person the dept and set the dept in the specific person table
     */

    def calculateDeptPerPerson() {
        double mean = calculateAverage()
        List<User> per = User.findAll()

        for (User p : per) {
            p.setDept(p.totalExpenses - mean)
            p.save(flush: true)
        }
    }

    /*
    / Delete existing Entry from DB
    */

    def delete(Long id) {
        def expense = Expenses.get(id)
        if (!expense) {
            flash.message = "Not found"
            redirect(action: "getAllExpenses")
            return
        }
        try {
            expense.delete(flush: true)
            flash.message = "deleted"
            calculateDeptPerPerson()
            redirect(action: "getAllExpenses")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = "Not deleted"
            redirect(action: "getAllExpenses", id: id)
        }
    }

    /*
    / Confirm delete before actually delete
    */

    def confirmDelete(Long id) {
        def expense = Expenses.get(id)

        render view: "ConfirmDelete", model: [expense: expense]
    }

}
