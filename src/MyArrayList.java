import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {

    //private Object [] array;
    private T[] array;
    private static final int DEFAULT_SIZE = 20;
    private int size = 0;

    public MyArrayList() {
        this(DEFAULT_SIZE);
        // Rammer constructor på linie 16
        // rammer næste constructor, den der er bedst fit
    }

    public MyArrayList (int size){
        array = (T[]) new Object[size];
    }

    private void ensureCapacity(){
        if (size < array.length){
            return;
        }

        resize();
    }

    private void resize() {

        T[] temp = (T[]) new Object [array.length * 2];
        copy(array, temp);
        array = temp;

    }

    private void copy (Object[] src, Object[] dest){

        if (dest.length < src.length){

            throw new RuntimeException(src + "cannot be copied into " + dest);

        }

        for (int i = 0; i< src.length;i++){
            dest[i]=src[i];
        }
    }

    @Override
    public void add(T element) {
        ensureCapacity();
        array[size++] = element;
    }

    @Override
    public T remove(int index) {
        if (index >= size || index < 0){
            throw new RuntimeException("Invalid index");
        }
        T element = (T) array[index];
        array[index] = null;
        --size;
        return element;
    }

    @Override
    public T get(int index) {
        if (index > size){
            throw new RuntimeException("Invalid Index");
        }
        T element = (T) array[index];
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        Arrays.stream(array)
                .filter(t-> t !=null)
                .forEach(t -> System.out.println(t));
                // lamda expressions
                // flere metoder på et kald


    }
}
