import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Notebook {
    private int id;
    private double price;
    private int discount;
    private int amountStock;
    private String name;
    private Brand brand;
    private int ram;
    private int storage;
    private double inches;

    public Notebook(int id, double price, int discount, int amountStock, String name, Brand brand, int ram, int storage, double inches) {
        this.id = id;
        this.discount = discount;
        this.price = price;
        this.amountStock = amountStock;
        this.name = name;
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.inches = inches;
    }

    public static int getProductById(int id, List<Notebook> arr) throws IllegalArgumentException{
        for(Notebook notebook : arr) {
            if(notebook.getId() == id) {
                return id;
            }
        }
        throw new IllegalArgumentException("Hatalı ID girişi yapıldı.");
    }

    public static void getProductByBrand(String brand, List<Notebook> arr) throws IllegalArgumentException{
        List<Notebook> tempArr = new ArrayList<>();
        boolean flag = false;
        for(Notebook notebook : arr) {
            if(Objects.equals(notebook.getBrand().getName().toLowerCase(), brand.toLowerCase())) {
                tempArr.add(notebook);
            }
        }
        if(!tempArr.isEmpty()) {
            System.out.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s \n", "ID", "Name", "Price", "Brand", "Storage", "Screen", "RAM");
            for(Notebook notebook : tempArr) {
                System.out.format("%-15d %-10s %-15s %-15s %-15d %-15s %-15d \n", notebook.getId(), notebook.getName(), notebook.getPrice(), notebook.getBrand().getName(), notebook.getStorage(), notebook.getInches(), notebook.getRam());
            }
        } else {
            throw new IllegalArgumentException("Girdiğiniz markaya ait ürün bulunamadı!");
        }
    }

    /*
    public double calculateDiscount() {
        if(this.discount <= 0) {
            return this.price;
        }
        return (double) (this.price * (this.discount / 100));
    }
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getAmountStock() {
        return amountStock;
    }

    public void setAmountStock(int amountStock) {
        this.amountStock = amountStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public double getInches() {
        return inches;
    }

    public void setInches(double inches) {
        this.inches = inches;
    }
}
