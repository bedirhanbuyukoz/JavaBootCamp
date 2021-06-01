import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Customer senpai=new Customer();
        senpai.setId(1);
        senpai.setFirstName("Bedirhan");
        senpai.setLastName("BÜYÜKÖZ");
        senpai.setDateOfBirth(LocalDate.parse("1999-01-01"));
        senpai.setNationalIdentity("24680");
        BaseCustomerManager base=new StarbucksCustomerManager(new CustomerCheckManager());
        BaseCustomerManager nero=new NeroCustomerManager();
        nero.delete(senpai);
        base.add(senpai);
        base.getall(senpai);

    }

}
