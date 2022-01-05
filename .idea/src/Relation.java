import java.util.ArrayList;
public abstract class Relation{
    
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

    public void getDayi(Person x){
        ArrayList<Person> temp = new ArrayList<Person>();
        if(x.cocuklar!=null){
            for(int i=0; i<x.anne.anne.cocuklar.size(); i++){
                if(x.anne.anne.cocuklar.get(i).gender=="Erkek"){ 
                    temp.add(x.anne.anne.cocuklar.get(i));
                }
            }
            System.out.println(x.isim + " kişisinin dayilari: ");
            for(int i=0; i<temp.size(); i++){
                System.out.println(temp.get(i).isim);
            }
        }
        else{
            System.out.println("Dayi bulunmuyor.");
        }
    }
    public void getHala(Person x) {
        ArrayList<Person> temp = new ArrayList<Person>();
        if(x.cocuklar!=null){
            for(int i=0; i<x.baba.anne.cocuklar.size(); i++){
                if(x.baba.anne.cocuklar.get(i).gender=="Kadin"){ 
                    temp.add(x.baba.anne.cocuklar.get(i));
                }
            }
            System.out.println(x.isim + " kişisinin halalari: ");
            for(int i=0; i<temp.size(); i++){
                System.out.println(temp.get(i).isim);
            }
        }
        else{
            System.out.println("Hala bulunmuyor.");
        }


    }
    
    public void getAmca(Person x) {
        ArrayList<Person> temp = new ArrayList<Person>();
        if(x.cocuklar!=null){
            for(int i=0; i<x.baba.anne.cocuklar.size(); i++){
                if(x.baba.anne.cocuklar.get(i).gender=="Erkek"){ 
                    temp.add(x.baba.anne.cocuklar.get(i));
                }
            }
            System.out.println(x.isim + " kişisinin amcalari: ");
            for(int i=0; i<temp.size(); i++){
                System.out.println(temp.get(i).isim);
            }
        }
        else{
            System.out.println("Amca bulunmuyor.");
        }
    }

}
