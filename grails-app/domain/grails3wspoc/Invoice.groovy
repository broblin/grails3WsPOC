package grails3wspoc


import grails.rest.*

@Resource(uri='/invoice',readOnly = false, formats = ['json', 'xml'])
class Invoice {
    String url
    String name
}