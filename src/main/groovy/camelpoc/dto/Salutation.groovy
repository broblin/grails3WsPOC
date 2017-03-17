package camelpoc.dto

/**
 * Created by broblin on 03/03/17.
 */
enum Salutation {
    M("M."), MELLE("Melle"), MME("Mme"), DR("Dr"), PROF("Prof.");

    final String code;

    private Salutation(String code) {
        this.code = code;
    }

}