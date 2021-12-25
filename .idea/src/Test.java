import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test{
public static void main(String[] args) {

    Person me = new Person();
    Person anne = new Person();
    anne.setGender("Kadin");
    anne.setIsim("Anne");

    me.setIsim("Esra");
    me.setGender("Kadin");
    me.setAnne(anne);
    
    Person anneanne = new Person();
    anneanne.setIsim("Nene");
    anneanne.setGender("Kadin");
    anne.setAnne(anneanne);

    Person teyze = new Person();
    teyze.setIsim("Ceren");
    teyze.setGender("Kadin");
    anneanne.setCocuk(teyze);

    Person teyze1 = new Person();
    teyze1.setIsim("Elif");
    teyze1.setGender("Kadin");
    anneanne.setCocuk(teyze1);

    Person teyze2 = new Person();
    teyze2.setIsim("Nergis");
    teyze2.setGender("Kadin");
    anneanne.setCocuk(teyze2);

    me.getTeyze(me);
    
    for(int i=0; i<anneanne.cocuklar.size();i++){
        System.out.println(anneanne.cocuklar.get(i).getIsim());
    }

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