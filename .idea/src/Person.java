import java.util.ArrayList;

public class Person {
    String isim;
    String soyisim;
    int dogumYili;
    String gender;
    boolean hayattaMi;
    Person anne;
    Person baba;
    Person partner;
    int personId;  
    ArrayList<Person> cocuklar = new ArrayList<Person>();
 

    public void getTeyze(Person x){
        ArrayList<Person> temp = new ArrayList<Person>();
        if(x.cocuklar!=null){
            for(int i=0; i<x.anne.anne.cocuklar.size(); i++){
                if(x.anne.anne.cocuklar.get(i).gender=="Kadin"){ 
                    temp.add(x.anne.anne.cocuklar.get(i));
                }
            }
            System.out.println(x.isim + " kişisinin teyzeleri: ");
            for(int i=0; i<temp.size(); i++){
                System.out.println(temp.get(i).isim);
            }
        }
        else{
            System.out.println("Teyze bulunmuyor.");
        }
    }

   
    public String getIsim() {
        return this.isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return this.soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public int getDogumYili() {
        return this.dogumYili;
    }

    public void setDogumYili(int dogumYili) {
        this.dogumYili = dogumYili;
    }

    public Person getAnne() {
        return this.anne;
    }

    public void setAnne(Person anne) {
        this.anne = anne;
        anne.cocuklar.add(this);


    }

    public Person getBaba() {
        return this.baba;
    }

    public void setBaba(Person baba) {
        this.baba = baba;
    }

    public Person getPartner() {
        return this.partner;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isHayattaMi() {
        return hayattaMi;
    }

    public void setHayattaMi(boolean hayattaMi) {
        this.hayattaMi = hayattaMi;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public void setCocuk(Person cocuk){
        this.cocuklar.add(cocuk);
        if(this.gender=="Kadin"){
            cocuk.setAnne(this);
            cocuk.setBaba(this.partner);
        }
        else{
            cocuk.setBaba(this);
            cocuk.setAnne(this.partner);
        }
    }

}