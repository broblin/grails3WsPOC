package grails3wspoc

import grails.rest.Resource
import grails.validation.Validateable
import groovy.transform.ToString

/**
 * Created by broblin on 01/03/17.
 */
@Resource(readOnly = false, formats = ['json', 'xml'])
@ToString(includeNames = true, includeFields = true, excludes = "metaClass", includePackage = false)
class Posts {
    int id
    int userId
    String title
    String body
}
