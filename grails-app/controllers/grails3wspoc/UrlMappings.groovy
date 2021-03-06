package grails3wspoc

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/partner"(controller:"partner",action:"index",method:"GET")
        "/partner"(controller:"partner",action:"save",method:"POST")
        "/partner/$id"(controller:"partner",action:"update",method:"PUT")
        "/partner/$id"(controller:"partner",action:"show",method:"GET")
        "/partner/$id"(controller:"partner",action:"patch",method:"PATCH")
        "/partner/$id"(controller:"partner",action:"delete",method:"DELETE")

        "/posts"(controller:"posts",action:"index",method:"GET")
        "/posts"(controller:"posts",action:"save",method:"POST")
        "/posts/$id"(controller:"posts",action:"update",method:"PUT")
        "/posts/$id"(controller:"posts",action:"show",method:"GET")
        "/posts/$id"(controller:"posts",action:"patch",method:"PATCH")
        "/posts/$id"(controller:"posts",action:"delete",method:"DELETE")

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
