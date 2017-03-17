package camelpoc.dto

import com.fasterxml.jackson.annotation.JsonFormat

/**
 * Created by broblin on 03/03/17.
 */
@JsonFormat
enum InvoicesDiffusionMode {
    EMAIL,
    COURRIER,
    BOTH,
    NONE
}