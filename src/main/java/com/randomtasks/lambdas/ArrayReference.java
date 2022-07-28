package com.randomtasks.lambdas;
interface InterfaceForArrayRef {
    ForReferenceInstance[] init(int value);
}

interface InterfaceForOneInstanceRef {
    ForReferenceInstance init(int value);
}

interface InterfaceForGenericArrayRef {
    GenericReferenceInstance<Number>[] init(int value);
}

class GenericReferenceInstance<T extends Number> {
    private T value;

    public GenericReferenceInstance(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

class ForReferenceInstance {
    private int value;

    public ForReferenceInstance(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

public class ArrayReference {
    public static void main(String[] args) {
        InterfaceForOneInstanceRef ref = ForReferenceInstance::new;
        ForReferenceInstance instance1 = ref.init(10);
        System.out.println(instance1.getValue());
        InterfaceForArrayRef refs = ForReferenceInstance[]::new;
        ForReferenceInstance[] instanceArray = refs.init(5);
        for (int i = 0; i < 5; i++) {
            instanceArray[i] = ref.init(i);
            System.out.println(instanceArray[i].getValue());
        }
        ForReferenceInstance[] instances = new ForReferenceInstance[5];
        InterfaceForGenericArrayRef genRefs = GenericReferenceInstance[]::new;
        GenericReferenceInstance<Number>[] genInstanceArray = genRefs.init(5);
        genInstanceArray[0] = new GenericReferenceInstance<>(5);
    }
}
