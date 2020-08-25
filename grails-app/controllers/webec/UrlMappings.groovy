package webec

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/" {
            controller = "expenses"
            action = "getDeptPerPerson"
        }

        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
