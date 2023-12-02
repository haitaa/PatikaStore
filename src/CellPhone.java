import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CellPhone {
    private int id;
    private double price;
    private int discount;
    private int amountStock;
    private String name;
    private Brand brand;
    private int storage;
    private double inches;
    private double power;
    private int ram;
    private String color;

    public CellPhone(int id, double price, int discount, int amountStock, String name, Brand brand, int storage, double inches, double power, int ram, String color) {
        this.id = id;
        this.discount = discount;
        this.price = calculateDiscount();
        this.amountStock = amountStock;
        this.name = name;
        this.brand = brand;
        this.storage = storage;
        this.inches = inches;
        this.power = power;
        this.ram = ram;
        this.color = color;
    }

    public static int getProductById(int id, List<CellPhone> arr) throws IllegalArgumentException{
        for(CellPhone cellPhone : arr) {
            if(cellPhone.getId() == id) {
                return id;
            }
        }
        throw new IllegalArgumentException("Hatalı id girişi yapıldı!");
    }

    public static void getProductsByBrand(String brand, List<CellPhone> arr) throws IllegalArgumentException {
        List<CellPhone> tempArr = new ArrayList<>();
        for(CellPhone cellPhone : arr) {
            if(Objects.equals(cellPhone.getBrand().getName().toLowerCase(), brand.toLowerCase())) {
                tempArr.add(cellPhone);
            }
        }

        if(!tempArr.isEmpty()) {
            System.out.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s  \n", "ID", "Name", "Price", "Brand", "Storage", "Screen", "Power" , "RAM", "Color");
            for(CellPhone cellPhone : tempArr) {
                System.out.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", cellPhone.getId(), cellPhone.getName(), cellPhone.getPrice(), cellPhone.getBrand().getName(), cellPhone.getStorage(), cellPhone.getInches(), cellPhone.getPower(), cellPhone.getRam(), cellPhone.getColor());
            }
        } else {
            throw new IllegalArgumentException("Hatalı ürün markası girişi yapıldı!");
        }
    }

    public double calculateDiscount() {
        if(this.discount <= 0) {
            return this.price;
        }
        return (double) (this.price * (this.discount / 100));
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return this.discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getAmountStock() {
        return this.amountStock;
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

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
