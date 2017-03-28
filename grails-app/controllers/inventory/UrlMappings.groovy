package inventory

class UrlMappings {

    static mappings = {

        // STANDARD URL MAPPING
        // "/$controller/$action/$id?"()

        // SPRING SECURITY CORE
        "/login/auth"(controller: "login", action: "auth")

        // ADMIN VIEW
        "/admin"(controller: "admin")
        "/import"(view: "/inventory/import")

        // USER VIEW
        "/signup"(controller: "signup")
        "/user"(controller: "user")

        // DEFAULT
        "/"(view: "/index")
        "500"(view: '/error')
        "404"(view: '/notFound')

    }

}