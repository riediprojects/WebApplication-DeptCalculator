// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'webec.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'webec.UserRole'
grails.plugin.springsecurity.authority.className = 'webec.Role'

// For logout functionality
grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.logout.afterLogoutUrl = "/"

grails.plugin.springsecurity.securityConfigType = 'Annotation'

grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/', access: ['permitAll']],
        [pattern: '/error', access: ['permitAll']],
        [pattern: '/index', access: ['ROLE_ADMIN']],
        [pattern: '/index.gsp', access: ['permitAll']],
        [pattern: '/shutdown', access: ['permitAll']],
        [pattern: '/assets/**', access: ['permitAll']],
        [pattern: '/**/js/**', access: ['permitAll']],
        [pattern: '/**/css/**', access: ['permitAll']],
        [pattern: '/**/images/**', access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']],

        //Rights concerned to expenses
        [pattern: '/**/expenses/index/', access: ['ROLE_ADMIN']],
        [pattern: '/**/expenses/create/', access: ['ROLE_ADMIN']],
        [pattern: '/**/expenses/delete/', access: ['ROLE_ADMIN']],
        [pattern: '/**/expenses/update/', access: ['ROLE_ADMIN']],

        //Rights concerned to User
        [pattern: '/**/person/index/', access: ['ROLE_ADMIN']],
        [pattern: '/**/person/create/', access: ['ROLE_ADMIN']],
        [pattern: '/**/person/delete/', access: ['ROLE_ADMIN']],
        [pattern: '/**/person/update/', access: ['ROLE_ADMIN']]


]


