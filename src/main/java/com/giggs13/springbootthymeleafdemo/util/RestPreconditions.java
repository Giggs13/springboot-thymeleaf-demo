package com.giggs13.springbootthymeleafdemo.util;

import com.giggs13.springbootthymeleafdemo.error.ResourceNotFoundException;

public class RestPreconditions {

    private RestPreconditions() {
        throw new AssertionError();
    }

    public static <T> T checkFound(final T resource) {
        return checkFound(resource, "Resource not found");
    }

    public static <T> T checkFound(final T resource,
                                   final String errorMessage) {
        if (resource == null) {
            throw new ResourceNotFoundException(errorMessage);
        }

        return resource;
    }
}
