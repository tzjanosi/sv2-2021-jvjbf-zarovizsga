package shipping;

import java.util.*;
import java.util.stream.Collectors;

public class ShippingService {
    private List<Transportable> packages=new ArrayList<>();

    public void addPackage(Transportable pack){
        packages.add(pack);
    }

    public List<Transportable> sortInternationalPackagesByDistance(){
        return packages.stream()
                .filter(pack->pack.getClass().getName().equals("shipping.InternationalPackage"))
                .sorted()
                .collect(Collectors.toList());
    }

    Map<String, Integer> collectTransportableByCountry(){
        Map<String, Integer> packNumbersByCountry=new TreeMap<>();

        for(Transportable pack:packages){
            String country=pack.getDestinationCountry();
            packNumbersByCountry.putIfAbsent(country, 0);
            int count = packNumbersByCountry.get(country);
            packNumbersByCountry.put(country,count+1);
        }
        return packNumbersByCountry;
    }

    List<Transportable> collectItemsByBreakableAndWeight(boolean breakable, int weight){
        return packages.stream()
                .filter(pack->(pack.getWeight()>=weight && pack.isBreakable()==breakable))
                .collect(Collectors.toList());
    }

    public List<Transportable> getPackages() {
        return packages;
    }
}
