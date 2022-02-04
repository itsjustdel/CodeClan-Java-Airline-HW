import People.CabinCrewMember;
import People.Rank;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CabinCrewMemberTest {

    private CabinCrewMember cabinCrewMember;

    @Before
    public void before(){
        cabinCrewMember = new CabinCrewMember("Billy", Rank.CABINCREW);
    }

    @Test
    public void hasNameBilly() {
        assertEquals("Billy", cabinCrewMember.getName());
    }

    @Test
    public void hasRankCabinCrew() {
        assertEquals(Rank.CABINCREW, cabinCrewMember.getRank());
    }

    @Test
    public void canRelayMessageHelloPlane(){
        assertEquals("Hello Plane", cabinCrewMember.relayMessage("Hello Plane"));
    }
}
