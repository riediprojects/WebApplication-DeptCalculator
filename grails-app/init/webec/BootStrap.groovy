package webec

import grails.util.Environment

class BootStrap {

    def init = { servletContext ->

        if (Environment.current == Environment.PRODUCTION) {
            return
        }

        //User Domains
        Role adminRole = save(Role.findOrCreateWhere(authority: Role.ADMIN))
        Role userRole = save(Role.findOrCreateWhere(authority: Role.USER))

        User elmoAdmin = save(new User(username: 'Elmo', password: '123'))
        User biboUser = save(new User(username: 'Bibo', password: '123'))
        User krümelmonsterUser = save(new User(username: 'Cookiemonster', password: '123'))

        UserRole.create(elmoAdmin, adminRole, true)
        UserRole.create(biboUser, userRole, true)
        UserRole.create(krümelmonsterUser, userRole, true)

        //Expenses Domain
        Expenses expandExample1 = save(new Expenses(amount: 7.80, comment: "Fruits from Mr.Huber's grocery", creditor: elmoAdmin))
        Expenses expandExample2 = save(new Expenses(amount: 20, comment: "Garbage bags", creditor: biboUser))
        Expenses expandExample3 = save(new Expenses(amount: 128.60, comment: "Electricity bill paid", creditor: elmoAdmin))
        Expenses expandExample5 = save(new Expenses(amount: 180.15, comment: "Big bag of cookies", creditor: krümelmonsterUser))
        Expenses expandExample4 = save(new Expenses(amount: 10.00, comment: "Cleaning supplies", creditor: biboUser))



    }


    static save(domainObject) {
        domainObject.save(failOnError: true)
    }

    def destroy = {
    }


}
