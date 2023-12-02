import java.util.*;

public class Store {
    TreeSet<Brand> brands = new TreeSet<>(new OrderBrandByNameComparator());
    List<Notebook> notebooks = new ArrayList<>();
    List<CellPhone> cellPhones = new ArrayList<>();

    Brand samsung = new Brand(1, "Samsung");
    Brand lenovo = new Brand(2, "Lenovo");
    Brand apple = new Brand(3, "Apple");
    Brand huawei = new Brand(4, "Huawei");
    Brand casper = new Brand(5, "Casper");
    Brand asus = new Brand(6, "Asus");
    Brand hp = new Brand(7, "HP");
    Brand xiaomi = new Brand(8, "Xiaomi");
    Brand monster = new Brand(9, "Monster");
    public Store() {
        brands.add(samsung);
        brands.add(lenovo);
        brands.add(apple);
        brands.add(huawei);
        brands.add(casper);
        brands.add(asus);
        brands.add(hp);
        brands.add(xiaomi);
        brands.add(monster);
        Notebook matebook14 = new Notebook(1, 7000, 0, 15, "HUAWEI Matebook 14", huawei, 16, 512, 14.0);
        Notebook v14 = new Notebook(2, 4500, 15, 40, "LENOVO V14 IGL" , lenovo, 8, 1024, 14.0);
        Notebook tuf = new Notebook(3, 8000, 5, 20, "ASUS Tuf Gaming", asus, 32, 2048, 15.6);
        notebooks.add(matebook14);
        notebooks.add(v14);
        notebooks.add(tuf);
        CellPhone a51 = new CellPhone(1, 3500, 5, 50, "SAMSUNG GALAXY A51", samsung, 128, 6.5, 4000.0, 6, "Siyah");
        CellPhone iphone11 = new CellPhone(2, 4500, 5, 120, "iPhone 11 64 GB", apple, 64, 6.1, 3046.0, 6, "Mavi");
        CellPhone RedmiNote10 = new CellPhone(3, 3000, 10, 50, "Redmi Note 10 Pro 8GB", xiaomi, 128, 6.5, 4000.0, 12, "Beyaz");
        cellPhones.add(a51);
        cellPhones.add(iphone11);
        cellPhones.add(RedmiNote10);

        searchPage();
    }

    public void searchPage() {
        Scanner input = new Scanner(System.in);
        boolean isOver = false;
        while(!isOver) {
            System.out.println("PatikaStore Ürün Yönetim Paneli!\n 1 - Notebook İşlemleri\n 2 - Cep Telefonu İşlemleri\n 3 - Marka Listele\n 0 - Çıkış Yap");
            System.out.print("Tercihiniz: ");
            int choice = input.nextInt();
            switch (choice) {
                case 0:
                    isOver = true;
                    System.out.println("Tekrar bekleriz!");
                    break;
                case 1:
                    boolean exit = false;
                    while(!exit) {
                        System.out.println("-----------------------");
                        System.out.println("Notebook İşlemleri Yönetim Paneli!\n 1 - Ürünleri Listele\n 2 - Ürün Ekle\n 3 - Ürün Sil\n 4 - Ürünleri Filtrele\n 0 - Ana Sayfaya Dön");
                        System.out.print("Terchiniz: ");
                        int notebookChoice = input.nextInt();
                        switch(notebookChoice) {
                            case 0:
                                exit = true;
                                break;
                            case 1:
                                System.out.println("Notebook Ürünleri");
                                System.out.println("------------------------");
                                System.out.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s \n", "ID", "Name", "Price", "Brand", "Storage", "Screen", "RAM");
                                for (Notebook notebook : notebooks) {
                                    System.out.format("%-15d %-10s %-15s %-15s %-15d %-15s %-15d \n", notebook.getId(), notebook.getName(), notebook.getPrice(), notebook.getBrand().getName(), notebook.getStorage(), notebook.getInches(), notebook.getRam());
                                }
                                break;
                            case 2:
                                System.out.println("Notebook Ürün Ekleme Paneli");
                                System.out.println("-----------------------");
                                System.out.print("Ürün ID: ");
                                int id = input.nextInt();
                                System.out.print("Ürünün adı: ");
                                String name = input.nextLine();
                                System.out.print("Ürünün fiyatı: ");
                                double price = input.nextDouble();
                                System.out.print("Indirim kampanyası: ");
                                int discount = input.nextInt();
                                System.out.print("Stok adedi: ");
                                int stockAmount = input.nextInt();
                                System.out.print("Ürün Markası: ");
                                String strBrand = input.nextLine().toLowerCase();
                                Brand newBrand = null;
                                switch (strBrand) {
                                    case "samsung":
                                        newBrand = samsung;
                                        break;
                                    case "apple":
                                        newBrand = apple;
                                        break;
                                }
                                System.out.print("RAM: ");
                                int ram = input.nextInt();
                                System.out.print("Storage: ");
                                int storage = input.nextInt();
                                System.out.print("Inches: ");
                                double inches = input.nextDouble();

                                notebooks.add(new Notebook(id, price, discount, stockAmount, name, newBrand, ram, storage, inches));
                                System.out.println("Ürün başarıyla veritabanına eklenmiştir.");
                                break;
                            case 3:
                                System.out.println("Ürün Silme Portalı!");
                                System.out.print("Silmek istediğiniz ürünün idsini giriniz: ");
                                int userInput = input.nextInt();
                                int index = Notebook.getProductById(userInput, notebooks);
                                notebooks.remove(index);
                                System.out.println("Ürün başarıyla silinmiştir. Ana ekrana döndürülüyorsunuz.");
                                break;
                            case 4:
                                System.out.println("Ürün Portalı");
                                System.out.println("--------------------------");
                                System.out.println("1 - ID'ye göre filtreleme\n2 - Markaya göre filtreleme\n0 - Çıkış");
                                System.out.print("Seçiniz: ");
                                int choice1 = input.nextInt();
                                switch(choice1) {
                                    case 0:
                                        System.out.println("Ana sayfaya yönlendiriliyorsunuz!");
                                        break;
                                    case 1:
                                        System.out.print("Görüntülemek istediğiniz ürünün kodunu giriniz: ");
                                        int productId = input.nextInt();
                                        try {
                                            index = Notebook.getProductById(productId, notebooks) - 1;
                                            Notebook product = notebooks.get(index);
                                            System.out.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s \n", "ID", "Name", "Price", "Brand", "Storage", "Screen", "RAM");
                                            System.out.format("%-15d %-10s %-15s %-15s %-15d %-15s %-15d \n", product.getId(), product.getName(), product.getPrice(), product.getBrand().getName(), product.getStorage(), product.getInches(), product.getRam());
                                        } catch(Exception e) {
                                            System.out.println(e.getMessage());
                                            break;
                                        }
                                        break;
                                    case 2:
                                        System.out.print("Görüntülemek istediğiniz markayı giriniz: ");
                                        String userInput1 = input.next();
                                        try {
                                            Notebook.getProductByBrand(userInput1, notebooks);
                                        } catch (Exception e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                }
                                break;
                        }
                    }
                    break;
                case 2:
                    exit = false;
                    while(!exit) {
                        System.out.println("---------------------------------");
                        System.out.println("Cep Telefonu İşlemleri Yönetim Paneli!\n1 - Ürünleri Listele\n 2 - Ürün Ekle\n 3 - Ürün Sil\n 4 - Ürünleri Filtrele\n 0 - Ana Sayfaya Dön");
                        System.out.print("Tercihiniz: ");
                        int userInput = input.nextInt();
                        switch (userInput) {
                            case 0:
                                System.out.println("Ana sayfaya yönlendiriliyorsunuz.");
                                exit = true;
                                break;
                            case 1:
                                System.out.println("Cep Telefon Ürünleri");
                                System.out.println("----------------------------");
                                System.out.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s  \n", "ID", "Name", "Price", "Brand", "Storage", "Screen", "Power" , "RAM", "Color");
                                for(CellPhone cellPhone : cellPhones) {
                                    System.out.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", cellPhone.getId(), cellPhone.getName(), cellPhone.getPrice(), cellPhone.getBrand().getName(), cellPhone.getStorage(), cellPhone.getInches(), cellPhone.getPower(), cellPhone.getRam(), cellPhone.getColor());
                                }
                                break;
                            case 2:
                                System.out.println("Cep Telefonu Ürün Ekleme Paneli");
                                System.out.println("-----------------------");
                                System.out.print("Ürün ID: ");
                                int id = input.nextInt();
                                System.out.print("Ürünün adı: ");
                                String name = input.nextLine();
                                System.out.print("Ürünün fiyatı: ");
                                double price = input.nextDouble();
                                System.out.print("Indirim kampanyası: ");
                                int discount = input.nextInt();
                                System.out.print("Stok adedi: ");
                                int stockAmount = input.nextInt();
                                System.out.print("Ürün Markası: ");
                                String strBrand = input.nextLine().toLowerCase();
                                Brand newBrand = null;
                                switch (strBrand) {
                                    case "samsung":
                                        newBrand = samsung;
                                        break;
                                    case "apple":
                                        newBrand = apple;
                                        break;
                                }
                                System.out.print("RAM: ");
                                int ram = input.nextInt();
                                System.out.print("Storage: ");
                                int storage = input.nextInt();
                                System.out.print("Inches: ");
                                double inches = input.nextDouble();
                                System.out.println("Power: ");
                                int power = input.nextInt();
                                System.out.println("Color: ");
                                String color = input.next();

                                cellPhones.add(new CellPhone(id, price, discount, stockAmount, name, newBrand, storage, inches, power, ram, color));
                                System.out.println("Cep Telefonu başarıyla veritabanına eklenmiştir!");
                                break;
                            case 3:
                                System.out.println("Ürün Silme Portalı!");
                                System.out.print("Silmek istediğiniz ürünün idsini giriniz: ");
                                userInput = input.nextInt();
                                try {
                                    int index = CellPhone.getProductById(userInput, cellPhones);
                                    cellPhones.remove(index);
                                    System.out.println("Ürün başarıyla veritabanından silinmiştir.");
                                } catch(Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 4:
                                System.out.println("Ürün Portalı");
                                System.out.println("--------------------------");
                                System.out.println("1 - ID'ye göre filtreleme\n2 - Markaya göre filtreleme\n0 - Çıkış");
                                System.out.print("Seçiniz: ");
                                userInput = input.nextInt();
                                switch (userInput) {
                                    case 0:
                                        System.out.println("Ana sayfaya yönlendiriliyorsunuz!");
                                        break;
                                    case 1:
                                        System.out.print("Görüntülemek istediğiniz ürünün kodunu giriniz: ");
                                        userInput = input.nextInt();
                                        try {
                                            int index = CellPhone.getProductById(userInput, cellPhones) - 1;
                                            CellPhone cellPhone = cellPhones.get(index);
                                            System.out.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s  \n", "ID", "Name", "Price", "Brand", "Storage", "Screen", "Power" , "RAM", "Color");
                                            System.out.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", cellPhone.getId(), cellPhone.getName(), cellPhone.getPrice(), cellPhone.getBrand().getName(), cellPhone.getStorage(), cellPhone.getInches(), cellPhone.getPower(), cellPhone.getRam(), cellPhone.getColor());
                                        } catch(Exception e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                    case 2:
                                        System.out.print("Görüntülemek istediğiniz ürünlerin markalarını giriniz: ");
                                        String strInput = input.next();
                                        try {
                                            CellPhone.getProductsByBrand(strInput, cellPhones);
                                        } catch(Exception e) {
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                }
                                break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Markalarımız");
                    System.out.println("-------------------");
                    Iterator<Brand> itr = brands.iterator();
                    while(itr.hasNext()) {
                        System.out.println(itr.next().getName());
                    }
                    break;
            }
        }
    }
}
