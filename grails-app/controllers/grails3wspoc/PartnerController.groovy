package grails3wspoc

import com.github.rahulsom.swaggydoc.SwaggyDelete
import com.github.rahulsom.swaggydoc.SwaggyList
import com.github.rahulsom.swaggydoc.SwaggyPatch
import com.github.rahulsom.swaggydoc.SwaggySave
import com.github.rahulsom.swaggydoc.SwaggyShow
import com.github.rahulsom.swaggydoc.SwaggyUpdate
import com.wordnik.swagger.annotations.Api
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
    @SwaggyList
    def index(Integer max) { super.index(max) }

    @Override
    @SwaggyShow
    def show() {
        super.show()
    }

    @Override
    @SwaggySave
    def save() {
        super.save()
    }

    @Override
   @SwaggyUpdate
    def update() {
        super.update()
    }

    @Override
    @SwaggyDelete
    def delete() {
        super.delete()
    }

    @Override
    @SwaggyPatch
    Object patch() {
        return super.patch()
    }
}



