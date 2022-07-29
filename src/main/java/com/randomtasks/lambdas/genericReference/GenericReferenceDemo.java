package com.randomtasks.lambdas.genericReference;

interface InterfaceForGeneric<T> {
    T get();
}

interface InterfaceForGenericConstructor<T> {
    GenericRefTest init(T value);
}

class GenericRefTest<T> {
    private T value;

    public GenericRefTest(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

public class GenericReferenceDemo {
    public static void main(String[] args) {
        GenericRefTest<String> testInstance = new GenericRefTest<>("-150_222");
        InterfaceForGeneric<?> get = testInstance::getValue;
        System.out.println(get.get());
        InterfaceForGenericConstructor<Integer> constructor = GenericRefTest::new;
        constructor.init(10);
    }
}
