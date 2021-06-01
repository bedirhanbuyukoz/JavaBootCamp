
public class NeroCustomerManager extends BaseCustomerManager {

    @Override
    public void add(Customer customer) {
        // TODO Auto-generated method stub
        System.out.println("Neroya musteri eklendi"+customer.getFirstName());
    }

    @Override
    public void update(Customer customer) {
        // TODO Auto-generated method stub
        System.out.println("Neroya musteri guncellendi"+customer.getFirstName());
    }

    @Override
    public void delete(Customer customer) {
        // TODO Auto-generated method stub
        System.out.println("Neroya musteri silindi"+customer.getFirstName());
    }

    @Override
    public void getall(Customer customer) {
        // TODO Auto-generated method stub
        System.out.println("Nero musteri bilgileri guncellendi"+" "+customer.getFirstName()+" "+customer.getLastName()+" "+customer.getDateOfBirth()+" "+customer.getNationalIdentity());
    }

}