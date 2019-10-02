package dal;

import model.*;

import java.util.List;

public interface Repo {
    User            getUser(int id);
    List<User>      getUsers();
    Integer         addUser(User user);
    Integer         editUser(User user);

    Bill            getBill(int id);
    List<Bill>      getBills();
    Integer         addBill(Bill bill);
    Integer         editBill(Bill bill);

    UserLog         getUserLog(int id);
    List<UserLog>   getUserLogs();
    Integer         addUserLog(UserLog userLog);

    Product         getProduct(int id);
    List<Product>   getProducts();
    Integer         addProduct(Product product);

    Country         getCountry(int id);
    List<Country>   getCountries();
    Integer         addCountry(Country country);
}
