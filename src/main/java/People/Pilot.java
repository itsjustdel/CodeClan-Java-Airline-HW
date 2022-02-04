package People;

public class Pilot extends StaffMember{
    private String licenseNumber;

    public Pilot(String name, Rank rank, String licenseNumber) {
        super(name, rank);
        this.licenseNumber = licenseNumber;
    }

    public String getLicense() {
        return this.licenseNumber;
    }

    public String flyPlane() {
        return "I'm flying!";
    }
}
