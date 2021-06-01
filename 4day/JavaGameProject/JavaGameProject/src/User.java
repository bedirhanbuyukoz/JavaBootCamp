import java.time.LocalDate;

public class User {
    private int id;
    private String firstName;
    private String nationalIdentity;
    private LocalDate birthOfDay;

    public User() {

    }

    public User(int id, String firstName, String nationalIdentity, LocalDate birthOfDay) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.nationalIdentity = nationalIdentity;
        this.birthOfDay = birthOfDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNationalIdentity() {
        return nationalIdentity;
    }

    public void setNationalIdentity(String nationalIdentity) {
        this.nationalIdentity = nationalIdentity;
    }

    public LocalDate getBirthOfDay() {
        return birthOfDay;
    }

    public void setBirthOfDay(LocalDate birthOfDay) {
        this.birthOfDay = birthOfDay;
    }
}