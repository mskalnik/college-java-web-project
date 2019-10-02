package dal;

import model.Country;

public class TestPsvm {
    public static void main(String[] args) {
        Repo repo = Repository.getRepository();

        for (Country c: repo.getCountries()) {
            System.out.println("Id:" + c.getCountryId() + " Name:" + c.getName());
        }
    }
}
