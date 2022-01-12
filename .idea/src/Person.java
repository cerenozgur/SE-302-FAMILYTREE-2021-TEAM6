import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class Person extends Relation {
    String isim;
    String soyisim;
    String dogumYili;
    String gender;
    String hayattaMi;
    Person anne;
    Person baba;
    Person partner;
    int personId;
    ArrayList<Person> cocuklar = new ArrayList<Person>();
    public Person(String isim, String soyisim, String dogumyili, String gender, String hayattami, Person anne, Person baba, Person partner, int personid, ArrayList<Person> cocuklar){
        setIsim(isim);
        setSoyisim(soyisim);
        setDogumYili(dogumYili);
        setGender(gender);
        setHayattaMi(hayattami);
        setAnne(anne);
        setBaba(baba);
        setPartner(partner);
        setPersonId(personid);
        setCocuk(null);
    }
    public Person(){
        setIsim(null);
        setSoyisim(null);
        setDogumYili(null);
        setGender(null);
        setHayattaMi(null); //true yazıyordu. stringe döndürdüğüm için null oldu.
        setAnne(null);
        setBaba(null);
        setPartner(null);
        setPersonId(0);
        setCocuk(null);
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

    public String getDogumYili() {
        return this.dogumYili;
    }

    public void setDogumYili(String dogumYili) {
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

    public String isHayattaMi() {
        return hayattaMi;
    }

    public void setHayattaMi(String hayattaMi) {
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

    public ArrayList<Person> getCocuk(){
        return this.cocuklar;
    }
}