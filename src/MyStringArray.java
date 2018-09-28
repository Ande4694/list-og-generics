import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MyStringArray implements MyList {


    private Object[] StringArray;
    private int size;

    private static final int DEFAULT_CAPACITY = 100;

    public MyStringArray() {

        this(DEFAULT_CAPACITY);

    }

    public MyStringArray(int capacity) {

        StringArray = new String[100];
        size = 0;
    }

    @Override
    public String toString() {
        if(size==0){
            return"[]";
        } else {
            String result = "["+StringArray[0];
            for (int i = 1; i < size; i++){
                result += ", "+StringArray[i];
            }
            result += "]";
            return result;
        }
    }

    @Override
    public void add(Object element) {
        ensureCapacity();
        StringArray[size] = element;
        size++;
    }

    public void add(int index, Object value) {
        ensureCapacity();
        for (int i = size; i >= index + 1; i--) {
            StringArray[i] = StringArray[i-1];
        }
        StringArray[index] = value;
        size++;
    }

    private void ensureCapacity(){
        if (size < StringArray.length){
            return;
        }

        resize();
    }

    private void resize() {

        Object[] temp = (Object[]) new Object [StringArray.length * 2];
        copy(StringArray, temp);
        StringArray = temp;

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
    public void remove(int index) {
        for (int i = index; i < size - 1; i++){
            StringArray[i] = StringArray[i+1];
        }
        size--;
    }

    public int indexOf(Object value){
        for(int i = 0; i<size; i++){
            if (StringArray==value){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object get(int index) {

        return StringArray[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        Arrays.stream(StringArray)
                .filter(t-> t !=null)
                .forEach(t -> System.out.println(t));
        // lamda expressions
        // flere metoder på et kald


    }
}
