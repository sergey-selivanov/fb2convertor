package org.svs.fb2conv;

public class ConvertorException extends Exception {

    private static final long serialVersionUID = 1L;

    public ConvertorException(final String string) {
        super(string);
    }

    public ConvertorException(final String string, final Throwable ex) {
        super(string, ex);
    }
}
