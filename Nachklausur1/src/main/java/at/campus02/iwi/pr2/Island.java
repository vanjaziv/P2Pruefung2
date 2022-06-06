package at.campus02.iwi.pr2;

import java.nio.file.ClosedWatchServiceException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Island {

   public ArrayList<Facility> facilities;
   public double facilityArea;

    public Island(ArrayList<Facility> facilities, double facilityArea) {
        facilities = new ArrayList<Facility>();
        facilityArea = 0;
    }

    public void add(Facility f){

        facilities.add(f);
        facilityArea = facilityArea + f.area;

    }


    public Facility findHighestProfit(){

        Facility result = null;

        for (Facility f: facilities)
        {
            if(result == null || result.calculateProfit() < f.calculateProfit())
            {
                result = f;
            }

        }

        return result;
    }


    public HashMap<String, Integer> groupFacilities() {

        HashMap<String, Integer> erg = new HashMap<>();

        int low = 0;
        int average = 0;
        int high = 0;

        for (Facility g : facilities)
        {
            double profit = g.calculateProfit();
            if(profit < 1000)
            {
                ++low;
            }
            else
            {
                if(profit < 10000)
                    ++average;
            }
            else
            {
                ++high;
            }
        }

        erg.put("Low", low);
        erg.put("Average", average);
        erg.put("High", high);
        return erg;
    }

 public ArrayList<Facility> risingWaterSimulation(double waterLevel) {

     ArrayList<Facility> blub = new ArrayList<>();

     for (Facility f : facilities) {
         if (f.heightAboveSeaLevel <= waterLevel) {
             blub.add(f);
         }
     }
         return blub;
 }

 public void sortedPrint() {

     Collections.sort(facilities, new IslandComparator());

     for (Facility f : facilities) {

         System.out.println(f + " " + f.getHeightAboveSeaLevel() + " " + f.getArea());

     }

    }

}

