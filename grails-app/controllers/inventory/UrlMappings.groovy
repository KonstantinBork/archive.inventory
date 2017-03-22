package inventory

class UrlMappings {

    static mappings = {

        "/$controller/$action/$id?"()

        // SPRIN SECURITY CORE
        //"/login/auth"(controller: "login", action: "auth")

        // ADMIN VIEW
        //"/admin"(controller: "admin")

        // USER VIEW
        //"/signup"(view: "signup")

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')

    }

}