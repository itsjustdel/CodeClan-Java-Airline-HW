package People;

public class CabinCrewMember extends StaffMember {
    public CabinCrewMember(String name, Rank rank) {
        super(name, rank);
    }

    public String relayMessage(String message) {
        return message;
    }
}
