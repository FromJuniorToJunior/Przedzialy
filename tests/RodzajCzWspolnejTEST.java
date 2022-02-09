import lastOne.RelationshipBetweenSections;
import lastOne.Section;
import org.junit.Assert;
import org.junit.Test;

public class RodzajCzWspolnejTEST {
    @Test
    public void test1()
    {
        Assert.assertEquals(1, RelationshipBetweenSections.rodzajPrzesuniecia(new Section
                    ("2000-12-15T00:00:00","2000-12-30T00:00:00"),
            new Section("2000-12-17T00:00:00","2001-01-01T00:00:00")));

        Assert.assertEquals(2, RelationshipBetweenSections.rodzajPrzesuniecia(new Section
                        ("2000-12-15T00:00:00", "2000-12-30T00:00:00"),
                new Section("2000-12-10T00:00:00", "2000-12-20T00:00:00")));
        Assert.assertEquals(3, RelationshipBetweenSections.rodzajPrzesuniecia(new Section
                        ("2000-12-15T00:00:00", "2000-12-30T00:00:00"),
                new Section("2000-12-15T00:00:00", "2000-12-30T00:00:00")));
        Assert.assertEquals(4, RelationshipBetweenSections.rodzajPrzesuniecia(new Section
                        ("2000-12-15T00:00:00", "2000-12-30T00:00:00"),
                new Section("2000-12-10T00:00:00", "2000-12-32T00:00:00")));

        Assert.assertEquals(6, RelationshipBetweenSections.rodzajPrzesuniecia(new Section
                        ("2000-12-15T00:00:00", "2001-04-01T00:00:00"),
                new Section("2001-03-01T00:00:00", "2001-04-01T00:00:00")));
        Assert.assertEquals(7, RelationshipBetweenSections.rodzajPrzesuniecia(new Section
                        ("2001-05-25T00:00:00", "2001-05-30T00:00:00"),
                new Section("2001-05-25T00:00:00", "2001-05-27T00:00:00")));

    }
}
