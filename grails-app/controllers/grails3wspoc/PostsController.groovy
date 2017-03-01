package grails3wspoc

import com.github.rahulsom.swaggydoc.SwaggyDelete
import com.github.rahulsom.swaggydoc.SwaggyList
import com.github.rahulsom.swaggydoc.SwaggySave
import com.github.rahulsom.swaggydoc.SwaggyShow
import com.github.rahulsom.swaggydoc.SwaggyUpdate
import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiImplicitParam
import com.wordnik.swagger.annotations.ApiImplicitParams
import com.wordnik.swagger.annotations.ApiOperation
import com.wordnik.swagger.annotations.ApiResponse
import com.wordnik.swagger.annotations.ApiResponses
import grails.converters.JSON
import grails.plugins.rest.client.RestBuilder
import grails.rest.Resource
import grails.validation.Validateable
import groovy.transform.ToString

@Api(
        value = 'posts',
        description = 'Posts API',
        position = 0,
        produces = 'application/json,application/xml,text/html',
        consumes = 'application/json,application/xml,application/x-www-form-urlencoded'
)
/**
 * utilisé pour se conencter avec un site distantde test (https://jsonplaceholder.typicode.com/)
 * permet de tester une façade
 */
class PostsController {
    static allowedMethods = [save: "POST", update: ["PUT", "POST"], patch: "PATCH", delete: "DELETE"]


    private String getUrl(){
        return grailsApplication.config.postsClient.url
    }

    private String getPath(){
        return grailsApplication.config.postsClient.resource
    }

    private void manageError(def resp){
        if(resp.status != 200 && resp.status != 201){
            throw new Exception("L'appel a échoué pour les raisons suivantes : ${resp.message}")
        }
    }


    @SwaggyList
    def index() {
        def client = new RestBuilder( )
        def resp = client.get("${getUrl()}/${getPath()}")
        manageError(resp)
        List posts = []
        resp.json.each { it ->
            posts << new Posts(it)
        }
        render posts as JSON
    }


    @SwaggyShow
    def show() {
        def client = new RestBuilder( )
        def resp = client.get("${getUrl()}/${getPath()}/${params.id}")
        manageError(resp)
        render resp.json
    }

    @ApiOperation(value = "Save Posts", response = Posts)
    @ApiResponses([
            @ApiResponse(code = 422, message = 'Bad Entity Received'),
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'body', paramType = 'body', required = true,
                    dataType = 'Posts'),
    ])
    def save(PostsCreateCommand cmd) {
        def client = new RestBuilder( )
        def resp = client.post("${getUrl()}/${getPath()}"){
            contentType "application/json"
            json cmd
        }
        manageError(resp)
        render resp.json
    }

    @ApiOperation(value = "Update Posts", response = Posts)
    @ApiResponses([
            @ApiResponse(code = 400, message = 'Bad Id provided'),
            @ApiResponse(code = 404, message = 'Could not find #Demo with that Id'),
            @ApiResponse(code = 422, message = 'Bad Entity Received'),
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'id', value = 'Id to update', paramType = 'path',
                    dataType = 'int', required = true),
            @ApiImplicitParam(name = 'body', paramType = 'body', required = true,dataType='Posts')
    ])
    def update(PostsUpdateCommand cmd) {
        def client = new RestBuilder( )
        def resp = client.put("${getUrl()}/${getPath()}/${params.id}"){
            contentType "application/json"
            json cmd
        }
        manageError(resp)
        render resp.json
    }

    @SwaggyDelete
    def delete() {
        def client = new RestBuilder( )
        def resp = client.delete("${getUrl()}/${getPath()}/${params.id}")
        manageError(resp)
        render resp.json
    }
}

@ToString(includeNames = true, includeFields = true, excludes = "metaClass", includePackage = false)
class PostsUpdateCommand implements Validateable {
    String title
    String body
}

@ToString(includeNames = true, includeFields = true, excludes = "metaClass", includePackage = false)
class PostsCreateCommand implements Validateable {
    int userId
    String title
    String body
}



