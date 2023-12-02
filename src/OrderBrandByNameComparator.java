import java.util.Comparator;

public class OrderBrandByNameComparator implements Comparator<Brand> {
    @Override
    public int compare(Brand brand1, Brand brand2) {
        return brand1.getName().compareTo(brand2.getName());
    }
}
