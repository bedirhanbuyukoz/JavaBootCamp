public class UserManager implements UserService{
    private EdevletManager eDevletLogger;

    public UserManager(EdevletManager eDevletLogger) {
        this.eDevletLogger = eDevletLogger;
    }

    @Override
    public void register(User user) {
        // TODO Auto-generated method stub
        if(eDevletLogger.check(user) == true) {

            System.out.println("Kayıt Olundu: " + user.getFirstName());
        }
        else
            System.out.println("Lütfen Geçerli Kimlik No Giriniz.");
    }

    @Override
    public void login(User user) {

        if(eDevletLogger.check(user) == true) {

            System.out.println("Giris yapıldı: " + user.getFirstName());
        }
        else
            System.out.println("Lütfen Geçerli Kimlik No Giriniz.");
    }

    @Override
    public void delete(User user) {
        if(eDevletLogger.check(user) == true) {

            System.out.println("Hesabınız silindi: " + user.getFirstName());
        }
        else
            System.out.println("Lütfen Geçerli Kimlik No Giriniz.");
    }


}