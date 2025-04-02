import java.util.*;

public class Catalogue {
  // Actual list of items for sale
  private ArrayList<PC> cataloguePCs;
  private ArrayList<Laptop> catalogueLaptops;
  private ArrayList<Monitor> catalogueMonitors;
  private ArrayList<Phone> cataloguePhones;
  private ArrayList<Tv> catalogueTvs;
  public Catalogue () {
    this.cataloguePCs = new ArrayList<>();
    cataloguePCs.add(new PC("PC 1", 2000, 15, 32, "AMD", "NVIDIA", 3200, "Tower", true, 6));
    cataloguePCs.add(new PC("PC 2", 3000, 15, 32, "AMD", "NVIDIA", 3200, "Tower", true, 6));
    this.catalogueLaptops = new ArrayList<> ();
    catalogueLaptops.add(new Laptop("Laptop 1", 1500, 12, 16, "AMD", "NVIDIA", 2000));
    catalogueLaptops.add(new Laptop("Laptop 2", 800, 26, 16, "AMD", "NVIDIA", 2000));
    this.catalogueMonitors = new ArrayList<> ();
    catalogueMonitors.add(new Monitor("Monitor 1", 200, 34, "30 x 24", "1440 x 1080", 164));
    catalogueMonitors.add(new Monitor("Monitor 2", 250, 7, "35 x 28", "1440 x 1080", 164));
    this.cataloguePhones = new ArrayList<> ();
    cataloguePhones.add(new Phone("Phone 1", 200, 62, "iPhone 14", true, "5 x 12"));
    cataloguePhones.add(new Phone("Phone 2", 300, 49, "iPhone 15", false, "5 x 12"));
    this.catalogueTvs = new ArrayList<> ();
    catalogueTvs.add(new Tv("Tv 1", 400, 34, "40 x 35", "1080 x 1080", 60));
    catalogueTvs.add(new Tv("Tv 2", 350, 13, "38 x 32", "1080 x 1080", 60)); 
  }

 public ArrayList<PC> getCataloguePCs (){
  return cataloguePCs;
 }

 public ArrayList<Laptop> getCatalogueLaptops () {
  return catalogueLaptops;
 }

 public ArrayList<Monitor> getCatalogeMonitors () {
  return catalogueMonitors;
 }

 public ArrayList<Phone> getCatalogPhones () {
  return cataloguePhones;
 }

 public ArrayList<Tv> getCatalogeTvs () {
  return catalogueTvs;
 }

  public String toString() {
        
    String tempPc = "";
    for (PC pc : cataloguePCs) {
      tempPc += pc.toString();
    }

    String tempLaptop = "";
    for (Laptop laptop : catalogueLaptops) {
      tempLaptop += laptop.toString();
    }

    String tempMonitor = "";
    for (Monitor monitor : catalogueMonitors) {
      tempMonitor += monitor.toString();
    }

    String tempPhone = "";
    for (Phone phone : cataloguePhones) {
      tempPhone += phone.toString();
    }

    String tempTv = "";
    for (Tv tv : catalogueTvs) {
      tempTv += tv.toString();
    }

    return (
        tempPc + "\n" +
        tempLaptop + "\n" +
        tempMonitor + "\n" +
        tempPhone + "\n" +
        tempTv
        );
  }

  public void printCatalogue () {
    System.out.println(toString());
  }

  public void changeNumPC (int num, int option) {
    if (cataloguePCs.get(option).getStock() > 0) {
      cataloguePCs.get(option).setStock(cataloguePCs.get(option).getStock() - num);
    }
  }

  public void changeNumLaptop (int num, int option) {
    if (catalogueLaptops.get(option).getStock() > 0) {
      catalogueLaptops.get(option).setStock(catalogueLaptops.get(option).getStock() - num);
    }
  }

  public void changeNumMonitor (int num, int option) {
    if (catalogueMonitors.get(option).getStock() > 0) {
      catalogueMonitors.get(option).setStock(catalogueMonitors.get(option).getStock() - num);
    }
  }

  public void changeNumPhone (int num, int option) {
    if (cataloguePhones.get(option).getStock() > 0) {
      cataloguePhones.get(option).setStock(cataloguePhones.get(option).getStock() - num);
    }
  }
  
  public void changeNumTv (int num, int option) {
    if (catalogueTvs.get(option).getStock() > 0) {
      catalogueTvs.get(option).setStock(catalogueTvs.get(option).getStock() - num);
    }
  }
  
}
