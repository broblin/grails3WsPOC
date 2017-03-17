package camelpoc.dto

/**
 * Created by broblin on 03/03/17.
 */
enum PaymentMode {
    /**
     * Carte bancaire
     */
    CREDIT_CARD("CB"),

    /**
     * Chèque
     */
            CHECK("CHQ-OK"),

    /**
     * Virement
     */
            TRANSFER("VIR-OK"),

    /**
     * Store credit (avoir sur magento)
     */
            STORE_CREDIT("STORE-CREDIT");

    final String erpValue;

    private PaymentMode(String erpValue) {
        this.erpValue = erpValue;
    }

}