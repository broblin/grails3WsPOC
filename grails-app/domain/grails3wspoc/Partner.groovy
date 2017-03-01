package grails3wspoc


import grails.rest.*

@Resource(readOnly = false, formats = ['json', 'xml'])
class Partner {
    String name

}