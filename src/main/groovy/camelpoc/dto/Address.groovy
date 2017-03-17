package camelpoc.dto

import groovy.transform.ToString

/**
 * Created by broblin on 03/03/17.
 */
@ToString
class Address {
    String line
    String lineComplement
    String postalCode
    String city
    String countryCode
    String regionCode
}
