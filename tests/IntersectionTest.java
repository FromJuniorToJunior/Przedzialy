import lastOne.RelationshipBetweenSections;
import lastOne.Section;
import org.junit.Assert;
import org.junit.Test;

public class IntersectionTest {
    @Test
    public void  tesdt()
    {
        Assert.assertEquals(true, RelationshipBetweenSections.checkIntersection(
                new Section("2000-12-15T00:00:00","2000-12-30T00:00:00"),new Section("2000-12-15T00:00:00","2000-12-30T00:00:00")));
        Assert.assertEquals(true, RelationshipBetweenSections.checkIntersection(
                new Section("2000-12-15T00:00:00","2000-12-30T00:00:00"),new Section("2000-12-17T00:00:00","2001-12-30T00:00:00")));
        Assert.assertEquals(true, RelationshipBetweenSections.checkIntersection(
                new Section("2000-12-15T00:00:00","2000-12-30T00:00:00"),new Section("2000-12-17T00:00:00","2000-12-28T00:00:00")));
        Assert.assertEquals(false, RelationshipBetweenSections.checkIntersection(
                new Section("2000-12-15T00:00:00","2000-12-30T00:00:00"),new Section("2000-12-31T00:00:00","2001-12-30T00:00:00")));
        Assert.assertEquals(true, RelationshipBetweenSections.checkIntersection(
            new Section("2001-03-01T00:00:00","2001-04-01T00:00:00"),new Section("2001-01-01T00:00:00","2001-03-20T00:00:00")));
        Assert.assertEquals(true, RelationshipBetweenSections.checkIntersection(
                new Section("2001-03-01T00:00:00","2001-05-27T00:00:00"),new Section("2001-05-01T00:00:00","2001-05-20T00:00:00")));
        Assert.assertEquals(true, RelationshipBetweenSections.checkIntersection(
                new Section("2001-03-15T00:00:00","2001-03-30T00:00:00"),new Section("2001-03-15T00:00:00","2001-03-25T00:00:00")));
        Assert.assertEquals(true, RelationshipBetweenSections.checkIntersection(
                new Section("2001-03-15T00:00:00","2001-03-25T00:00:00"),new Section("2001-03-15T00:00:00","2001-03-30T00:00:00")));
        Assert.assertEquals(false, RelationshipBetweenSections.checkIntersection(
                new Section("2001-05-01T00:00:00","2001-05-20T00:00:00"),new Section("2000-12-15T00:00:00","2001-04-01T00:00:00")));

        Assert.assertEquals(true, RelationshipBetweenSections.checkIntersection(
                new Section("2000-12-10T00:00:00", "2000-12-31T00:00:00"),
                new Section("2000-12-15T00:00:00", "2000-12-30T00:00:00")));

        Assert.assertEquals(true, RelationshipBetweenSections.checkIntersection(
                new Section("2000-05-05T00:00:00","2005-05-05T00:00:00"),
                new Section("2000-05-05T00:00:00","2010-05-05T00:00:00")));
    }
}
