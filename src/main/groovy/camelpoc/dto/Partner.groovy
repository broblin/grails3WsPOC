package camelpoc.dto

import groovy.transform.ToString
import org.springframework.stereotype.Component

/**
 * Created by broblin on 03/03/17.
 */
@ToString
@Component
class Partner {
    String name
    String code
    String idTva
    String language
    String siret
    PaymentMode paymentMode
    String bankName
    String iban
    String bic
    String bankAccountName
    Date accountingEndOfLife

    Contact contact
    Address billingAddress
    Address shippingAddress
}
