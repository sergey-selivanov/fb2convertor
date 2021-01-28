package org.svs.fb2conv;

public class ConvertorException extends Exception {

    public ConvertorException(String string) {
        super(string);
    }

    public ConvertorException(String string, Throwable ex) {
        super(string, ex);
    }
}
