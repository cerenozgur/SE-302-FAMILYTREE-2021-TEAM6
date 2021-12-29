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
    Person dayi = new Person();
    dayi.setIsim("Ahmet");
    dayi.setGender("Erkek");
    anneanne.setCocuk(dayi);

    Person dayi1 = new Person();
    dayi1.setIsim("Mehmet");
    dayi1.setGender("Erkek");
    anneanne.setCocuk(dayi1);

    Person dayi2 = new Person();
    dayi2.setIsim("Sefa");
    dayi2.setGender("Erkek");
    anneanne.setCocuk(dayi2);

    me.getDayi(me);
    
    Person baba = new Person();
    baba.setGender("Erkek");
    baba.setIsim("Baba");

    me.setIsim("Esra");
    me.setGender("Kadin");
    me.setBaba(baba);
    
    Person babaanne = new Person();
    babaanne.setIsim("Nene");
    babaanne.setGender("Kadin");
    baba.setAnne(babaanne);

    Person hala = new Person();
    hala.setIsim("Ayşe");
    hala.setGender("Kadin");
    babaanne.setCocuk(hala);

    Person hala1 = new Person();
    hala1.setIsim("Fatma");
    hala1.setGender("Kadin");
    babaanne.setCocuk(teyze1);

    Person hala2 = new Person();
    hala2.setIsim("Pınar");
    hala2.setGender("Kadin");
    babaanne.setCocuk(hala2);

     me.getHala(me);
    
   
    Person amca = new Person();
    amca.setIsim("Süleyman");
    amca.setGender("Erkek");
    babaanne.setCocuk(amca);

    Person amca1 = new Person();
    amca1.setIsim("Osman");
    amca1.setGender("Erkek");
    babaanne.setCocuk(amca1);

    Person amca2 = new Person();
    amca2.setIsim("Tarık");
    amca2.setGender("Erkek");
    babaanne.setCocuk(amca2);

    me.getAmca(me);
    
   
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


/*
 * import java.io.FileWriter;
 * import java.io.IOException;
 * import org.json.simple.*;
 * public class Test{
 * public static void main(String[] args) {
 * 
 * JSONObject jsonObject = new JSONObject();
 * jsonObject.put("ID", "1");
 * jsonObject.put("First_Name", "Esra Melike");
 * jsonObject.put("Last_Name", "Ersoy");
 * jsonObject.put("Date_Of_Birth", "1998-01-09");
 * jsonObject.put("Place_Of_Birth", "Antalya");
 * jsonObject.put("Country", "Turkey");
 * try {
 * FileWriter file = new FileWriter("C:/try/mynewjsonfile.json");
 * file.write(jsonObject.toJSONString());
 * file.close();
 * } catch (IOException e) {
 * e.printStackTrace();
 * }
 * System.out.println("JSON file created: "+jsonObject);
 * }
 * 
 * public class Test {
 * 
 * public static void main(String[] args) {
 * 
 * System.out.println("Hi family");
 * 
 * }
 * }
 */
