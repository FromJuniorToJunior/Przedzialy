package lastOne;

import java.util.Collections;
import java.util.LinkedList;
//TODO pozbyć się warunków zwracających throw po zapewnieniu w mainie, że te warunki będa niespełnialne
public class RelationshipBetweenSections {
    public static Section sectionBetween(Section a , Section b)
    {
        if(a.startOfSection.equals(b.startOfSection))
        {
            throw new ArithmeticException();
        }
        else
        return new Section(a.endOfSection.toString(),b.startOfSection.toString());
    }
    public  static Section markIntersection(Section first, Section second)
    {
        if(first.startOfSection.equals(second.startOfSection)&&first.endOfSection.isBefore(second.endOfSection))
            return new Section(first.startOfSection.toString(),first.endOfSection.toString());
        if(second.startOfSection.isAfter(first.startOfSection)&&second.endOfSection.isBefore(first.endOfSection))
            return new Section(second.startOfSection.toString(),second.endOfSection.toString());
        if(first.startOfSection.isAfter(second.startOfSection)&&first.endOfSection.isBefore(second.endOfSection))
            return new Section(first.startOfSection.toString(),first.endOfSection.toString());
        if(first.startOfSection.equals(second.startOfSection)&&first.endOfSection.equals(second.endOfSection))
            return new Section(first.startOfSection.toString(),first.endOfSection.toString());
        if(second.startOfSection.isBefore(first.startOfSection)&&second.endOfSection.isAfter(first.startOfSection)&&second.endOfSection.isBefore(first.endOfSection))
            return new Section(first.startOfSection.toString(),second.endOfSection.toString());
        if(second.startOfSection.isAfter(first.startOfSection)&&second.startOfSection.isBefore(first.endOfSection)&&second.endOfSection.isAfter(first.endOfSection))
            return  new Section(second.startOfSection.toString(),first.endOfSection.toString());
        else
            throw new ArithmeticException();
    }

    public  static Section markOutIntersection(Section first, Section second)
    {
        if(first.startOfSection.equals(second.startOfSection)&&first.endOfSection.isBefore(second.endOfSection))
            return new Section(first.endOfSection.toString(),second.endOfSection.toString());
        if(second.startOfSection.isAfter(first.startOfSection)&&second.endOfSection.isBefore(first.endOfSection))
            throw new ArithmeticException("");
        if(first.startOfSection.isAfter(second.startOfSection)&&first.endOfSection.isBefore(second.endOfSection))
            throw new ArithmeticException("");
        if(first.startOfSection.equals(second.startOfSection)&&first.endOfSection.equals(second.endOfSection))
            throw new ArithmeticException("przedzial pusty");
        if(second.startOfSection.isBefore(first.startOfSection)&&second.endOfSection.isAfter(first.startOfSection)&&second.endOfSection.isBefore(first.endOfSection))
            return new Section(second.startOfSection.toString(),first.startOfSection.toString());
        if(second.startOfSection.isAfter(first.startOfSection)&&second.startOfSection.isBefore(first.endOfSection)&&second.endOfSection.isAfter(first.endOfSection))
            return  new Section(first.endOfSection.toString(),second.endOfSection.toString());
        else
            throw new ArithmeticException("Proba uzyskania roznicy z dwoch takich samych przedziałow");

    }
    public static  LinkedList merge(LinkedList<Section> zadanie)
    {
        for(int j=0;j<zadanie.size()*2;j++) {
            for (int i = 0; i < zadanie.size() - 1; i++) {
                if (zadanie.get(i).endOfSection.equals(zadanie.get(i + 1).startOfSection)) {
                    zadanie.add(new Section(zadanie.get(i).startOfSection.toString(), zadanie.get(i + 1).endOfSection.toString()));
                    zadanie.remove(i);
                    zadanie.remove(i);
                }
            }
            Collections.sort(zadanie);
        }
        return zadanie;
    }
    public static boolean checkIntersection(Section p1, Section p2)
    {
        if(p2.startOfSection.isAfter(p1.startOfSection)&&p2.startOfSection.isBefore(p1.endOfSection))
            return true;
        if(p1.startOfSection.equals(p2.startOfSection)&&p1.endOfSection.equals(p2.endOfSection))
            return true;
        if(p2.startOfSection.isAfter(p1.startOfSection)&&p2.endOfSection.isBefore(p1.endOfSection))
            return true;
        if(p1.startOfSection.isAfter(p2.endOfSection))
            return false;
        else
            if(p1.startOfSection.isAfter(p2.startOfSection)&&p1.endOfSection.isAfter(p2.endOfSection))
                return true;
        if(p1.startOfSection.isAfter(p2.startOfSection)&&p1.endOfSection.isBefore(p2.endOfSection))
            return true;
        if(p1.startOfSection.equals(p2.startOfSection)&&p1.endOfSection.isAfter(p2.endOfSection))
            return true;
        if(p2.startOfSection.equals(p1.startOfSection)&&p2.endOfSection.isAfter(p1.endOfSection))
            return true;


        return false;
    }
    public static boolean checkForSimilarSections(LinkedList<Section> poOdczycie,LinkedList<Section> zadanie)
    {
        int i =0;
        for (int z =0;z<poOdczycie.size();z++) {
            if(poOdczycie.get(z).equals(zadanie.getLast()))
                return true;
        }
        return false;
    }

    public static int rodzajPrzesuniecia(Section first ,Section second)
    {
        if(second.startOfSection.isAfter(first.startOfSection)&&second.startOfSection.isBefore(first.endOfSection)&&second.endOfSection.isAfter(first.endOfSection))
            return 1;
        if(second.startOfSection.isBefore(first.startOfSection)&&second.endOfSection.isAfter(first.startOfSection)&&second.endOfSection.isBefore(first.endOfSection))
            return 2;
        if(first.startOfSection.equals(second.startOfSection)&&first.endOfSection.equals(second.endOfSection))
            return 3;
        if(second.startOfSection.isAfter(first.startOfSection)&&second.endOfSection.isBefore(first.endOfSection))
            return 5;
        //typy skrajne
        //lewy
        if(second.endOfSection.equals(first.endOfSection)&&second.startOfSection.isAfter(first.startOfSection))
            return 6;
        //prawy
        if(second.startOfSection.equals(first.startOfSection)&&second.endOfSection.isBefore(first.endOfSection))
            return 7;
        if(first.startOfSection.equals(second.startOfSection)&&first.endOfSection.isBefore(second.endOfSection))
            return 8;
        return 4;
    }
    public static int zadsize;
}
