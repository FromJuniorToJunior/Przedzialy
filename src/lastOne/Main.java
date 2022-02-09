package lastOne;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int a = -1;
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        LinkedList<Section> zadanie = new LinkedList<>();
        LinkedList<Section> odczyt = new LinkedList<>();
        LinkedList<Section> poOdczycie = new LinkedList<>();
        Scanner scan = new Scanner(System.in);
        Memory memory1 = new Memory();
        RelationshipBetweenSections.zadsize=0;
//TODO zabezpieczenie przed złym formatem przedzialu //done
        while (a != 0) {
            while(zadanie.size()==RelationshipBetweenSections.zadsize) {
           System.out.println("Podaj pierwsza date przedzialu w formacie: yyyy-MM-dd'T'HH:mm:ss");
            String p1 = scan.next();
            System.out.println("Podaj druga date przedzialu w formacie: yyyy-MM-dd'T'HH:mm:ss");
            String p2 = scan.next();
            System.out.println("Otrzymano zadanie odczytu z przedzialu: "+p1+" - "+p2);



                try {
                    zadanie.add(new Section(p1, p2));
                    if (poOdczycie.isEmpty()) {
                        poOdczycie.add(new Section(p1, p2));
                        odczyt.add(new Section(p1, p2));
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            //WYZNACZAMY CZ WSPOLNE JESLI TAKIE ISTNIEJA
            if(zadanie.size()>1) {
                for(int i =0;i<poOdczycie.size();i++)
                {
                    if(RelationshipBetweenSections.checkIntersection(poOdczycie.get(i),zadanie.get(RelationshipBetweenSections.zadsize)))
                    {
                        try {
                            memory1.memory.add(RelationshipBetweenSections.markIntersection(poOdczycie.get(i), zadanie.get(RelationshipBetweenSections.zadsize)));
                        }catch (Exception e){}
                    }

                }


                //JESLI PRZYNAJMNIEJ 1 CZ WSPOLNA
                if(memory1.memory.size()==1)
                {
                    for(int i=0;i<poOdczycie.size();i++)
                    {
                        if(RelationshipBetweenSections.checkIntersection(poOdczycie.get(i),memory1.memory.get(0)))
                        {
                            if(RelationshipBetweenSections.rodzajPrzesuniecia(poOdczycie.get(i),zadanie.getLast())==1)
                            {
                                try {
                                    odczyt.add(RelationshipBetweenSections.markOutIntersection(poOdczycie.get(i), zadanie.getLast()));
                                   // poOdczycie.add(odczyt.get(0));
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                            }
                            if(RelationshipBetweenSections.rodzajPrzesuniecia(poOdczycie.get(i),zadanie.getLast())==2)
                            {
                                try {
                                    odczyt.add(RelationshipBetweenSections.markOutIntersection(poOdczycie.get(i), zadanie.getLast()));
                                   // poOdczycie.add(odczyt.get(0));
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                            }
                            if(RelationshipBetweenSections.rodzajPrzesuniecia(poOdczycie.get(i),zadanie.getLast())==3)
                            {

                            }
                            if(RelationshipBetweenSections.rodzajPrzesuniecia(poOdczycie.get(i),zadanie.getLast())==4)
                            {
                                odczyt.add(new Section(zadanie.getLast().startOfSection.toString(),memory1.memory.get(0).startOfSection.toString()));
                                odczyt.add(new Section(memory1.memory.get(0).endOfSection.toString(),zadanie.getLast().endOfSection.toString()));
                            }
                            if(RelationshipBetweenSections.rodzajPrzesuniecia(poOdczycie.get(i),zadanie.getLast())==5)
                            {

                            }
                            if(RelationshipBetweenSections.rodzajPrzesuniecia(poOdczycie.get(i),zadanie.getLast())==6)
                            {

                            }
                            if(RelationshipBetweenSections.rodzajPrzesuniecia(poOdczycie.get(i),zadanie.getLast())==7)
                            {

                            }
                            if(RelationshipBetweenSections.rodzajPrzesuniecia(poOdczycie.get(i),zadanie.getLast())==8)
                            {
                                odczyt.add(RelationshipBetweenSections.markOutIntersection(poOdczycie.get(i),zadanie.getLast()));
                            }
                        }
                    }
                    //DODANIE DO PRZEDZIALU CALKOWITEGO POBRANYCH PRZEDZIALOW
                    for(int i = 0;i<odczyt.size();i++)
                    {
                        poOdczycie.add(odczyt.get(i));
                    }


                }
                //KIEDY WIECEJ CZ WSPOLNYCH

                //TODO dokonczyc zachowanie  programou dla wielu czesci wspolnych (warunki skrajne uzupelnnione) //done

                if(memory1.memory.size()>1)
                {
                    for(int i = 0;i<memory1.memory.size()-1;i++)
                    {
                        odczyt.add(RelationshipBetweenSections.sectionBetween(memory1.memory.get(i),memory1.memory.get(i+1)));

                       if(memory1.memory.size()-1==i+1)
                        {
                            for(int z=0;z<poOdczycie.size();z++)
                            {
                                if(RelationshipBetweenSections.checkIntersection(poOdczycie.get(z),memory1.memory.getFirst()))
                                {
                                    if(RelationshipBetweenSections.rodzajPrzesuniecia(poOdczycie.get(z),memory1.memory.getFirst())==3
                                    && zadanie.getLast().startOfSection.isBefore(memory1.memory.getFirst().startOfSection))
                                    {
                                        odczyt.add(new Section(zadanie.getLast().startOfSection.toString(),memory1.memory.getFirst().startOfSection.toString()));
                                    }
                                }
                               if(RelationshipBetweenSections.checkIntersection(poOdczycie.get(z),memory1.memory.getLast()))
                                {
                                    if(RelationshipBetweenSections.rodzajPrzesuniecia(poOdczycie.get(z),memory1.memory.getLast())==3
                                    && zadanie.getLast().endOfSection.isAfter(memory1.memory.getLast().endOfSection))
                                    {
                                        odczyt.add(new Section(memory1.memory.getLast().endOfSection.toString(),zadanie.getLast().endOfSection.toString()));
                                    }
                                }
                            }
                        }
                    }
                    for(int i = 0;i<odczyt.size();i++)
                    {
                        poOdczycie.add(odczyt.get(i));
                    }
                }

                /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                //JESLI BRAK CZ WSPOLNEJ LUB PRZEDZIAL INNY
                if(memory1.memory.isEmpty()&&odczyt.isEmpty()&&!RelationshipBetweenSections.checkForSimilarSections(poOdczycie,zadanie))
                {
                    odczyt.add(zadanie.get(RelationshipBetweenSections.zadsize));
                    poOdczycie.add(odczyt.get(0));
                }
            }
            for(int i = 0;i<poOdczycie.size();i++)
            {
                RelationshipBetweenSections.merge(poOdczycie);
            }

            //WYPISANIE CZYSZCZENIE

            PrintMethod.printM(odczyt, memory1.memory,poOdczycie);

            odczyt.clear();
            memory1.memory.clear();



            RelationshipBetweenSections.zadsize+=1;

            if(zadanie.size()==15)
            {
                zadanie.clear();
                memory1.memory.clear();
                odczyt.clear();
                poOdczycie.clear();
                RelationshipBetweenSections.zadsize=0;
            }









        }
    }
}