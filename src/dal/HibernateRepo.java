package dal;

import model.*;
import util.HibernateHelper;

import java.util.List;

public class HibernateRepo implements Repo {
    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        HibernateHelper hibernateHelper = new HibernateHelper<User>();
        return hibernateHelper.get("User");
    }

    @Override
    public Integer addUser(User user) {
        HibernateHelper hibernateHelper = new HibernateHelper<Integer>();
        return hibernateHelper.add(user);
    }

    @Override
    public Integer editUser(User user) {
        return null;
    }

    @Override
    public Bill getBill(int id) {
        return null;
    }

    @Override
    public List<Bill> getBills() {
        return null;
    }

    @Override
    public Integer addBill(Bill bill) {
        return null;
    }

    @Override
    public Integer editBill(Bill bill) {
        return null;
    }

    @Override
    public UserLog getUserLog(int id) {
        return null;
    }

    @Override
    public List<UserLog> getUserLogs() {
        return null;
    }

    @Override
    public Integer addUserLog(UserLog userLog) {
        return null;
    }

    @Override
    public Product getProduct(int id) {
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public Integer addProduct(Product product) {
        return null;
    }

    @Override
    public Country getCountry(int id) {
        return null;
    }

    @Override
    public List<Country> getCountries() {
        HibernateHelper hibernateHelper = new HibernateHelper<Country>();
        return hibernateHelper.get("Country");
    }

    @Override
    public Integer addCountry(Country country) {
        HibernateHelper hibernateHelper = new HibernateHelper<Integer>();
        return hibernateHelper.add(country);
    }
}
