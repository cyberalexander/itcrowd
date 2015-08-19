package com.leonovich.itcrowd.web.exception;

/**
 * Created by alexanderleonovich on 15.08.15.
 */
public enum WebExceptionCode {

    NC_WEB_000("Cannot get all inquiries"),
    NC_WEB_001("Cannot get all inquiries by customer name"),
    NC_WEB_002("Cannot get all inquiries by customer name and by id"),
    NC_WEB_003("Cannot edit inquiry"),
    NC_WEB_004("Cannot edit write inquiry instance"),
    NC_WEB_005("Cannot create inquiry"),
    NC_WEB_006("Cannot save inquiry"),
    NC_WEB_007("Cannot add write attribute of inquiry"),
    NC_WEB_008("The page cannot be displayed"),
    NC_WEB_009("Cannot delete inquiry"),
    NC_WEB_010("Cannot get list of topic dtos");


    private final String value;

    private WebExceptionCode(String s) {
        value = s;
    }

    public boolean equalsValue(String value2) {
        return (value2 != null) && value.equals(value2);
    }

    public String toString() {
        return value;
    }
}
