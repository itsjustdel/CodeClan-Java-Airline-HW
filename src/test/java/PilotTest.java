import People.Pilot;
import People.Rank;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PilotTest {
    private Pilot pilot;

    @Before
    public void before(){
        pilot = new Pilot( "Billy", Rank.PILOT,"AH235689");
    }

    @Test
    public void hasName() {
        assertEquals("Billy", pilot.getName());
    }

    @Test
    public void hasRank() {
        assertEquals(Rank.PILOT,pilot.getRank());
    }

    @Test
    public void hasLicenseNumber() {
        assertEquals("AH235689", pilot.getLicense());
    }

    @Test
    public void canFlyPlane(){
        assertEquals("I'm flying!", pilot.flyPlane());
    }
}
