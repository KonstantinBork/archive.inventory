package inventory

class UrlMappings {

    static mappings = {

        // ADMIN VIEW
        "/admin"(controller: "admin")

        // USER VIEW
        "/signup"(view: "signup")

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')

    }
}
