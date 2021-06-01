public class CustomerCheckManager implements CustomerCheckService {

    @Override
    public boolean checkIfRealPerson(String nationalId) {
        System.out.println("Müşteri Id doğrulandı");
        return true;
    }

}