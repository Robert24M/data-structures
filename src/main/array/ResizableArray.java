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
            if (sourceArray[index] != null) {
                shiftElementsToRight(index);
            }
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

    private void shiftElementsToLeft(int startingPoint) {
        for (int i = startingPoint; i < size - 1; i++) {
            sourceArray[i] = sourceArray[i + 1];
        }
    }

    private void shiftElementsToRight(int startingPoint) {
        if (currentIndex == size) {
            grow();
        }
        for (int i = numberOfElements; i > startingPoint; i--) {
            sourceArray[i] = sourceArray[i - 1];
        }
    }

    public void delete(int index) {
        shiftElementsToLeft(index);
        sourceArray[size - 1] = null;
        numberOfElements--;
    }

    public void set(int index, E object) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        sourceArray[index] = object;
    }

    public int indexOf(E object) {
        for (int i = 0; i < numberOfElements; i++) {
            if (sourceArray[i] == object) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }
}
