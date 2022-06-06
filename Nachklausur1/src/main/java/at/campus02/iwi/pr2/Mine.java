package at.campus02.iwi.pr2;

public class Mine extends Facility{

    protected double miningDepth;
    protected RawMaterial rawMaterial;

    public Mine(double area, double heightAboveSeaLevel, double miningDepth, RawMaterial rawMaterial) {
        super(area, heightAboveSeaLevel);
        this.miningDepth = miningDepth;
        this.rawMaterial = rawMaterial;
    }

    public double getMiningDepth() {
        return miningDepth;
    }

    public RawMaterial getRawMaterial() {
        return rawMaterial;
    }

    @Override
    public String toString() {
        return "Mine: " + miningDepth + " " + heightAboveSeaLevel;
    }


    @Override
    public double calculateProfit() {
        double profit;
        if (rawMaterial == RawMaterial.LITHIUM || rawMaterial == RawMaterial.NEODYMIUM)
        {
            profit = 200 * area;
        } else {
            profit = 300 * area;
        }

        return profit;
    }

    @Override
    public int getNrPalms() {
        if(miningDepth > 100){
            return 3;
        }if (rawMaterial == RawMaterial.TERBIUM) {
            return 2;
        }
        return 1;
    }
}