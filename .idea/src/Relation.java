import java.util.ArrayList;
public abstract class Relation{
    
    public void indicateRelation(Person a, String b){
        ArrayList<Person> temp = new ArrayList<Person>(); //return type ArrayList<Person> yapılıp returnde tek kişi bile olsa tempi döndürmek mantıklı kuzen gibi relationlar için
        switch(b){
            case "Anne":
            a.getAnne();
            case "Baba":
            a.getBaba();
            case "Çocuk":
            a.getCocuk();
            case "Eş":
            a.getPartner();
            case "Teyze":
            for(int i=0; i==a.getAnne().getAnne().getCocuk().size(); i++){
                if(a.getAnne().getAnne().getCocuk().get(i).getGender()=="Kadin"){
                    if(a.getAnne().getAnne().getCocuk().get(i)!=a.getAnne()){
                        temp.add(a.getAnne().getAnne().getCocuk().get(i));
                    }
                }
            }
            case "Dayı":
            for(int i=0; i==a.getAnne().getAnne().getCocuk().size(); i++){
                if(a.getAnne().getAnne().getCocuk().get(i).getGender()=="Erkek"){
                        temp.add(a.getAnne().getAnne().getCocuk().get(i));
                }
            }
            case "Amca":
            for(int i=0; i==a.getBaba().getAnne().getCocuk().size(); i++){
                if(a.getBaba().getAnne().getCocuk().get(i).getGender()=="Erkek"){
                        temp.add(a.getBaba().getAnne().getCocuk().get(i));
                }
            }
            case "Yenge":
            for(int i=0; i==a.getBaba().getAnne().getCocuk().size(); i++){
                if(a.getBaba().getAnne().getCocuk().get(i).getGender()=="Erkek"){
                        temp.add(a.getBaba().getAnne().getCocuk().get(i).getPartner());
                }
            }
            for(int i=0; i==a.getAnne().getAnne().getCocuk().size(); i++){
                if(a.getAnne().getAnne().getCocuk().get(i).getGender()=="Erkek"){
                        temp.add(a.getAnne().getAnne().getCocuk().get(i).getPartner());
                }
            }
            
            case "Kuzen":
            for(int i=0; i==a.getAnne().getAnne().getCocuk().size(); i++){ //teyze&dayı
                if(a.getAnne().getAnne().getCocuk().get(i)!=a.getAnne()){
                    for(int c=0; c==a.getAnne().getAnne().getCocuk().get(i).getCocuk().size(); c++ ){
                        temp.add(a.getAnne().getAnne().getCocuk().get(i).getCocuk().get(c));
                    }
                }
            }
            for(int i=0; i==a.getBaba().getAnne().getCocuk().size(); i++){ //amca&hala (amcaya veya teyzeye gidip onların çocuklarını çekebiliriz)
                if(a.getBaba().getAnne().getCocuk().get(i)!=a.getBaba()){
                    for(int c=0; c==a.getBaba().getAnne().getCocuk().get(i).getCocuk().size(); c++ ){
                        temp.add(a.getBaba().getAnne().getCocuk().get(i).getCocuk().get(c));
                    }
                }
            }
        }
    }
}
