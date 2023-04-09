package main.array;

public class ResizableArray<E> {

    private Object[] sourceArray;
    private int size;
    private static final int initialDefaultCapacity = 10;
    private int currentIndex = 0;
    private int numberOfElements = 0;

    public ResizableArray(int initialCapacity) {
        this.size = initialCapacity;
        this.sourceArray = new Object[initialCapacity];

    }

    public ResizableArray() {
        this(initialDefaultCapacity);
    }

    public void add(E element) {
        if (currentIndex == size) {
            grow();
        }
        add(element, currentIndex);
    }

    public void add(E element, int index) {
        try {
            sourceArray[index] = element;
            numberOfElements++;

            if (index == currentIndex) {
                currentIndex++;
            }

        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException();
        }
    }

    public E get(int index) {
        if (index <= numberOfElements - 1) {
            return (E) sourceArray[index];
        }
        throw new IndexOutOfBoundsException();
    }

    private void grow() {
        Object[] newSourceArray = new Object[size + 1];
        for (int i = 0; i < size; i++) {
            newSourceArray[i] = sourceArray[i];
        }
        sourceArray = newSourceArray;
        size = sourceArray.length;
    }

    private void shiftElements(int startingPoint) {
        for (int i = startingPoint; i < size - 1; i++) {
            sourceArray[i] = sourceArray[i + 1];
        }
    }
}
