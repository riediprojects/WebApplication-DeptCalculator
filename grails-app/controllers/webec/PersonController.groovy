package webec

import grails.plugin.springsecurity.annotation.Secured

@Secured([Role.ADMIN, Role.USER])
class PersonController {

    static scaffold = User

    /*
     * Get a instanze of all existing user and make them selectable to make new expenses entries.
     */
   def newExpense(String errorMessage, double amount, String comment) {
       List<User> persons = User.findAll()

       render view: "newExpense", model: [persons: persons, errorMessage:errorMessage, amount:amount, comment:comment]
   }



}
