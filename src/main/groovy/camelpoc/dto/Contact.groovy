package camelpoc.dto

import groovy.transform.ToString

/**
 * Created by broblin on 03/03/17.
 */
@ToString
class Contact {
    String lastname
    String firstname
    Salutation salutation
    String email
    String tel1
    String tel2
    String fax
    InvoicesDiffusionMode invoicesDiffusionMode
}
