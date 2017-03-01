package grails3wspoc

import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiImplicitParam
import com.wordnik.swagger.annotations.ApiImplicitParams
import com.wordnik.swagger.annotations.ApiOperation
import com.wordnik.swagger.annotations.ApiResponse
import com.wordnik.swagger.annotations.ApiResponses
import grails.rest.RestfulController


@Api(
        value = 'partner',
        description = 'Partner API',
        position = 0,
        produces = 'application/json,application/xml,text/html',
        consumes = 'application/json,application/xml,application/x-www-form-urlencoded'
)
class PartnerController extends RestfulController<Partner> {
    static responseFormats = ['json', 'xml']
    PartnerController() {
        super(Partner)
    }

    @Override
    @ApiOperation(value = 'List Partners', response = Partner, responseContainer = 'list')
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'offset', value = 'Records to skip', defaultValue = '0', paramType = 'query', dataType = 'int'),
            @ApiImplicitParam(name = 'max', value = 'Max records to return', defaultValue = '10', paramType = 'query', dataType = 'int'),
            @ApiImplicitParam(name = 'sort', value = 'Field to sort by', defaultValue = 'id', paramType = 'query', dataType = 'string'),
            @ApiImplicitParam(name = 'order', value = 'Order to sort by', defaultValue = 'asc', paramType = 'query', dataType = 'string'),
            @ApiImplicitParam(name = 'q', value = 'Query', paramType = 'query', dataType = 'string'),
    ])
    def index(Integer max) { super.index(max) }

    @Override
    @ApiOperation(value = "Show Partner", response = Partner)
    @ApiResponses([
            @ApiResponse(code = 400, message = 'Bad Id provided'),
            @ApiResponse(code = 404, message = 'Could not find Partner with that Id'),
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'id', value = 'Id to fetch', paramType = 'path', dataType = 'int', required = true),
    ])
    def show() {
        super.show()
    }

    @ApiOperation(value = "Save Partner", response = Partner)
    @ApiResponses([
            @ApiResponse(code = 422, message = 'Bad Entity Received'),
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'body', paramType = 'body', required = true, dataType = 'Partner'),
    ])
    @Override
    def save() {
        super.save()
    }

    @Override
    @ApiOperation(value = "Update Partner", response = Partner)
    @ApiResponses([
            @ApiResponse(code = 400, message = 'Bad Id provided'),
            @ApiResponse(code = 404, message = 'Could not find Partner with that Id'),
            @ApiResponse(code = 422, message = 'Bad Entity Received'),
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'id', value = 'Id to update', paramType = 'path', dataType = 'int', required = true),
            @ApiImplicitParam(name = 'body', paramType = 'body', required = true, dataType = 'Partner')
    ])
    def update() {
        super.update()
    }

    @Override
    @ApiOperation(value = "Delete Partner")
    @ApiResponses([
            @ApiResponse(code = 400, message = 'Bad Id provided'),
            @ApiResponse(code = 404, message = 'Could not find Partner with that Id'),
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'id', value = 'Id to delete', paramType = 'path', dataType = 'int', required = true),
    ])
    def delete() {
        super.delete()
    }

    @Override
    @ApiOperation(value = "Patch Partner", response = Partner)
    @ApiResponses([
            @ApiResponse(code = 400, message = 'Bad Id provided'),
            @ApiResponse(code = 404, message = 'Could not find Partner with that Id'),
            @ApiResponse(code = 422, message = 'Bad Entity Received'),
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'id', value = 'Id to patch', paramType = 'path', dataType = 'int', required = true),
            @ApiImplicitParam(name = 'body', paramType = 'body', required = true, dataType = 'Partner')
    ])
    Object patch() {
        return super.patch()
    }
}



