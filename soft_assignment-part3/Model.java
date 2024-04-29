import java.util.ArrayList;

public class Model {
    private static Employee employee;
    private static Customer customer ;
    private static Double totalPrice;
    private static ArrayList <Cart> cart;
    private static Manager manager;
    private static Administrator administrator;
    private static String search;
    
    public static String getSearch() {
        return search;
    }


    public static void setSearch(String search) {
        Model.search = search;
    }


    public ArrayList<Cart> getCart() {
        return cart;
    }


    public static Administrator getAdministrator() {
        return administrator;
    }


    public static void setAdministrator(Administrator administrator) {
        Model.administrator = administrator;
    }


    public void setCart(ArrayList<Cart> cart) {
        this.cart = cart;
    }


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public Customer getCustomer() {
        return customer;
    }


    public Double getTotalPrice() {
        return totalPrice;
    }


    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Employee getEmployee(){
        return employee;
    }

    public void setEmployee(Employee emp){
        employee = emp;
    }

    public void setManager(Manager manager){
        this.manager = manager;
    }

    public Manager getManger(){
        return manager;
    }

   

   
    
}
