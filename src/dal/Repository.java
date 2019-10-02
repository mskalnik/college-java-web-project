package dal;

public class Repository {
    public static Repo getRepository() {
        return new HibernateRepo();
    }
}
