package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {
    Object[] list;
    int size = 0;

    public ImmutableArrayList() {
        list = new Object[0];
    }

    public ImmutableArrayList(Object e) {
        list = new Object[1];
        list[0] = e;
        size += 1;
    }

    public ImmutableArrayList(Object[] e) {
        list = e;
        size = e.length;
    }

    @Override
    public ImmutableArrayList add(Object e) {
        Object[] l = new Object[size + 1];
        for (int i = 0; i < size; i++) {
            l[i] = list[i];
        }
        l[size] = e;
        return new ImmutableArrayList(l);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        Object[] l = new Object[size + 1];
        for (int i = 0; i < index; i++) {
            l[i] = list[i];
        }
        l[index] = e;
        for (int i = index; i < size; i++) {
            l[i + 1] = list[i];
        }
        return new ImmutableArrayList(l);
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        Object[] l = new Object[size + c.length];
        for (int i = 0; i < size; i++) {
            l[i] = list[i];
        }

        for (int i = 0; i < c.length; i++) {
            l[i + size] = c[i];
        }
        return new ImmutableArrayList(l);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        Object[] l = new Object[size + c.length];
        for (int i = 0; i < index; i++) {
            l[i] = list[i];
        }

        for (int i = 0; i < c.length; i++) {
            l[i + index] = c[i];
        }

        for (int i = index; i < size; i++) {
            l[i + c.length] = list[i];
        }
        return new ImmutableArrayList(l);

    }

    @Override
    public Object get(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        return list[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        Object[] l = new Object[size - 1];
        for (int i = 0; i < index; i++) {
            l[i] = list[i];
        }

        for (int i = index + 1; i < size; i++) {
            l[i - 1] = list[i];
        }
        return new ImmutableArrayList(l);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        list[index] = e;
        Object[] l = new Object[size];
        for (int i = 0; i < size; i++) {
            l[i] = list[i];
        }
        return new ImmutableArrayList(l);

    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (list[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return list;
    }

    @Override
    public String toString() {
        return Arrays.toString(list);
    }
}
