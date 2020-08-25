package webec

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class UserSpec extends Specification implements DomainUnitTest<User> {

    def setup() {
    }

    def cleanup() {
    }

    void "Find a User"() {
        //Creat new User
        setup:
        def user = new User(username: "missedUser", password: "123")
        when:
        user.validate()
        then:
        user.save()

        //Find the User
        when:
        def findetUser = User.findAllByUsername("missedUser")
        then:
        findetUser != null
    }

    void "Username cannot be null or blank "() {
        expect:
        domain != null

        when:
        domain.username = null
        then:
        !domain.validate(['username'])
        domain.errors['username'].code == 'nullable'
    }


    void "Insert a new User and delete it"() {

        //Insert
        setup:
        def user = new User(username: "TestUser", password: "123")
        assert User.count() == 0

        when:
        user.validate()
        then:
        def saved = user.save()
        and:
        User.count() == 1
        saved.id == 1

        //Delete
        when:
        def found = User.get(1)
        then:
        found.id == 1
        found.username == 'TestUser'
        and:
        found.delete()
        and:
        User.count() == 0
    }
}
