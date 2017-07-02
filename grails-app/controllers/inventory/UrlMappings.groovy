package inventory

class UrlMappings {

    static mappings = {

        // STANDARD URL MAPPING
        // "/$controller/$action/$id?"()

        // SPRING SECURITY CORE
        "/login"(controller: "signup", action: "login")
        "/login/auth"(controller: "login", action: "auth")

        // ADMIN VIEW
        "/admin"(controller: "admin")
        "/import"(view: "/inventory/import")

        // USER VIEW
        "/signup"(controller: "signup")
        "/user"(controller: "user")
        "/user/add"(controller: "user", action: "addMedia")
        "/user/remove"(controller: "user", action: "removeMedia")
        "/user/show"(controller: "user", action: "showMedia")

        // DEFAULT
        "/"(view: "/index")
        "500"(view: '/error')
        "404"(view: '/notFound')

    }

}