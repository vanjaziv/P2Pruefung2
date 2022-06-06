package at.campus02.iwi.pr2;

public class Hotel extends Facility{

    protected int stars;
    protected int maxNrGuests;
    protected int nrGuests;

    public Hotel(double area, double heightAboveSeaLevel, int stars, int maxNrGuests, int nrGuests) {
        super(area, heightAboveSeaLevel);
        if (stars < 1 || stars > 3){
            this.stars = 1;
        } else {
            this.stars = stars;
        }
        this.maxNrGuests = maxNrGuests;
        this.nrGuests = nrGuests;
    }

    public int getStars() {
        return stars;
    }

    public int getMaxNrGuests() {
        return maxNrGuests;
    }

    public int getNrGuests() {
        return nrGuests;
    }


    @Override
    public String toString() {
        return "Hotel: " + nrGuests;
    }

    @Override
    public double calculateProfit() {
        double expenses = (0.1 * stars + 0.1) * 30 * maxNrGuests;
        double revenue = nrGuests;
        switch (stars)
        {
            case 1:
                revenue *= 60;
                break;
            case 2:
                revenue *= 75;
                break;
            case 3:
                revenue *=120;
                break;
        }

        return revenue - expenses;
    }

    @Override
    public int getNrPalms() {

        double quotient = (double) nrGuests / maxNrGuests;
        if (quotient > 0.85){
            return 3;
        }

        if(quotient > 0.5){
            return 2;
        }
        return 1;

    }
}