package com.awexa.awexa;

/**
 * Created by Corey on 11/14/17.
 */

@FunctionalInterface
public interface OnCheckInterface<T, U> {
    void accept(T t, U u);
}
