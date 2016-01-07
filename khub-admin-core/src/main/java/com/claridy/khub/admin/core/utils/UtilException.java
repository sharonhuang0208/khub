package com.claridy.khub.admin.core.utils;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import rx.functions.Action1;

public class UtilException<E extends Exception> {

    @SuppressWarnings("rawtypes")
    private static final UtilException INSTANCE = new UtilException();

    @SuppressWarnings("unchecked")
    public static <E extends Exception> UtilException<E> create() throws E {
        return INSTANCE;
    }

    private UtilException() {
        // Does nothing
    }

    @FunctionalInterface
    public interface Consumer_WithExceptions<T, E extends Exception> {
        void accept(T t) throws E;
    }

    @FunctionalInterface
    public interface Function_WithExceptions<T, R, E extends Exception> {
        R apply(T t) throws E;
    }

    @FunctionalInterface
    public interface Supplier_WithExceptions<T, E extends Exception> {
        T get() throws E;
    }

    /*
     * .forEach(rethrowConsumer(name ->
     * System.out.println(Class.forName(name)))); or
     * .forEach(rethrowConsumer(ClassNameUtil::println));
     */
    public <T> Consumer<T> rethrowConsumer(Consumer_WithExceptions<T, E> consumer) {
        return t -> {
            try {
                consumer.accept(t);
            } catch (Exception exception) {
                throwAsUnchecked(exception);
            }
        };
    }

    /*
     * .forEach(rethrowConsumer(name ->
     * System.out.println(Class.forName(name)))); or
     * .forEach(rethrowConsumer(ClassNameUtil::println));
     */
    public <T> Action1<T> rethrowAction1(Consumer_WithExceptions<T, E> consumer) {
        return t -> {
            try {
                consumer.accept(t);
            } catch (Exception exception) {
                throwAsUnchecked(exception);
            }
        };
    }

    /*
     * .map(rethrowFunction(name -> Class.forName(name))) or
     * .map(rethrowFunction(Class::forName))
     */
    public <T, R> Function<T, R> rethrowFunction(Function_WithExceptions<T, R, E> function) {
        return t -> {
            try {
                return function.apply(t);
            } catch (Exception exception) {
                throwAsUnchecked(exception);
                return null;
            }
        };
    }

    /*
     * rethrowSupplier(() -> new StringJoiner(new String(new byte[]{77, 97, 114,
     * 107}, "UTF-8"))),
     */
    public <T> Supplier<T> rethrowSupplier(Supplier_WithExceptions<T, E> function) {
        return () -> {
            try {
                return function.get();
            } catch (Exception exception) {
                throwAsUnchecked(exception);
                return null;
            }
        };
    }

    @SuppressWarnings("unchecked")
    private static <E extends Exception> void throwAsUnchecked(Exception exception) throws E {
        throw (E) exception;
    }
}