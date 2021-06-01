
public class EdevletManager implements EdevletService {

    @Override
    public boolean check(User user) {

        if(user.getNationalIdentity().length()==11) {
            return true;
        }else {
            return false;
        }
    }

}