package grails3wspoc

class BootStrap {

    def init = { servletContext ->
        new Invoice(name:"test1","url":"un lien").save()
        new Partner(name:"test").save()
    }
    def destroy = {
    }
}
