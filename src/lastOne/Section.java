package lastOne;

import java.time.Instant;

public class Section implements Comparable<Section>{
    //TODO napisać metodę która sprawdzi odpowiednia kolejnosc podania przedzialow i ewentualnie je odwroci (metoda do wywolania w konstruktorze)
    Instant startOfSection;
    Instant endOfSection;


    public Section(String poczatek, String koniec) {
        try {
            this.startOfSection = StaticDateFormat.simpleDateFormatStart.parse(poczatek).toInstant();
            this.endOfSection = StaticDateFormat.simpleDateFormatEnd.parse(koniec).toInstant();

        } catch (Exception e) {
            throw new ArithmeticException("Zły format przedziału");
        }
    }
    public Section()
    {

    }
    public void setStartOfSection(Instant x)
    {
        this.startOfSection=x;
    }
    public void setEndOfSection(Instant x)
    {
        this.endOfSection=x;
    }

    @Override
    public String toString() {
        return startOfSection.toString()+" - "+ endOfSection.toString();
    }

    @Override
    public int compareTo(Section o) {
        if(startOfSection.isBefore(o.startOfSection)) return -1;
        if(startOfSection.isAfter(o.startOfSection)) return 1;
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof  Section)
        {
            Section p =(Section)obj;
            if(this.startOfSection.equals(p.startOfSection)&&this.endOfSection.equals(p.endOfSection))
            {
                return true;
            }
            else
                return false;
        }
        return false;
    }
}

