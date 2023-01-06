package SA;

public class City {
    private final int x;
    private final int y;
    private final String cityName;

    //Constructor
    //creates a city given its name and (x,y) location
    public City(String cityName, int x, int y){
        this.cityName = cityName;
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }




    public int getY() {
        return y;
    }



    /**
     * @return the cityName
     */
    public String getCityName() {
        return cityName;
    }



}
