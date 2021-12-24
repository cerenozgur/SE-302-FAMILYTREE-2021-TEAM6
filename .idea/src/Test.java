import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test{
public static void main(String[] args) {

    Person me = new Person();
    Person anne = new Person();
    me.setAnne(anne);
    me.setIsim("Esra");

    Person anneanne = new Person();
    anne.setAnne(anneanne);

    Person teyze = new Person();
    teyze.setIsim("Ceren");
    teyze.setGender("Kadin");
    anneanne.cocuklar.add(teyze);

    Person teyze1 = new Person();
    teyze1.setIsim("Elif");
    teyze1.setGender("Kadin");
    anneanne.cocuklar.add(teyze1);

    Person teyze2 = new Person();
    teyze2.setIsim("Nergis");
    teyze2.setGender("Kadin");
    anneanne.cocuklar.add(teyze2);

    me.getTeyze(me);
    

    // try (Scanner scan1 = new Scanner(System.in)) {
    //     System.out.println("write the name of the first person");
    //     testPerson.isim = scan1.nextLine();
    // }
    // JSONObject jsonObject = new JSONObject();
    // jsonObject.put("ID", "1");
    // jsonObject.put("First_Name", testPerson.isim);
    
    // try {
    //     FileWriter file = new FileWriter("C:/try/mynewjsonfile.json");
    //     file.write(jsonObject.toJSONString());
    //     file.close();
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // System.out.println("JSON file created: "+jsonObject);

}
}