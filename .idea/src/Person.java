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

}