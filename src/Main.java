import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        // polymorph default på venstre og type på højre, lettere at lave om

        strings.add("test");
        strings.add("test1");
        strings.add("test2");
        strings.add("test3");
        strings.add("test4");
        strings.add("test5");

        for (int i = 0; i<strings.size();i++) {
            if(!strings.get(i).equals("test4")){
                System.out.println(strings.get(i));
            }
//            if (i != 4) {
//                System.out.println(strings.get(i));
            }


        strings.stream()
                .forEach(s ->
                        if strings != "test4"{
                            System.out.println(s));
                        }
                // lamda giver kode til argument
                // s er det første element i mit array
                //  med stream undgår du store mængder i bufferen
                // hvor bliver s defineret til at være noge???
                // stream inboxer s, og aflevere s til dig en af gangen
                // på venstre side siger du hvad den skal hede
                // på højre side siger du hvad du vil gøre med det
    }
}
