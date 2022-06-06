package at.campus02.iwi.pr2;

public class Plantation extends Facility {

    protected Fruit fruit;

    public Plantation(double area, double heightAboveSeaLevel, Fruit fruit) {
        super(area, heightAboveSeaLevel);
        this.fruit = fruit;
    }

    public Fruit getFruit() {
        return fruit;
    }

    @Override
    public String toString() {
        return "Plantation: " + fruit;
    }


    @Override
    public double calculateProfit() {

        double profit;
        if (fruit == Fruit.BANANA){
            profit = 30 * area * 1;
        }
        else {
            if (fruit == Fruit.COCONUT) {
                profit = 15 * area * 2.5;
            } else {
                if (fruit == Fruit.MANGO && heightAboveSeaLevel <= 150) {
                    profit = 15 * area * 3;
                } else {
                    profit = 10 * area * 3;
                }
            }
        }

        return profit;
    }

    @Override
    public int getNrPalms() {
        return 0;
    }
}