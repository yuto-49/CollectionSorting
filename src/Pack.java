public class Pack implements Comparable<Pack> {

    private static int counter=1;

    private int packageID;

    private String receiver;

    private String zone;

    private Date deliveryDate;

    private int weight, volume;

    private static final String DEFAULT_RECEIVER="Default Company", DEFAULT_ZONE="A1";

    private static final int DEFAULT_WEIGHT=1, DEFAULT_VOLUME=1;

    public Pack() {
        packageID=counter;
        setReceiver(DEFAULT_RECEIVER);
        setZone(DEFAULT_ZONE);
        setDeliveryDate(new Date());
        setWeight(DEFAULT_WEIGHT);
        setVolume(DEFAULT_VOLUME);
        counter++;
    }

    public Pack(String newReceiver, String newZone, Date newDate, int newWeight, int newVolume) {

        packageID=counter;
        setReceiver(newReceiver);
        setZone(newZone);
        setDeliveryDate(newDate);
        setWeight(newWeight);
        setVolume(newVolume);
        counter++;
    }

    public int getPackageID(){return packageID;}

    public String getReceiver(){return receiver;}

    public String getZone(){return zone;}

    public Date getDeliveryDate() {

        return new Date(deliveryDate.getMonth(),deliveryDate.getDay(),deliveryDate.getYear());

    }

    public int getWeight(){return weight;}

    public int getVolume(){return volume;}

    public void setReceiver(String newReceiver){

        if (newReceiver!=null) receiver=newReceiver;

        else receiver=DEFAULT_RECEIVER;

    }

    public void setZone(String newZone){

        if (newZone!=null && newZone.charAt(0)>='A' && newZone.charAt(0)<='Z' &&

                newZone.charAt(1)>='1' && newZone.charAt(1)<='9')

            zone=newZone;

        else zone = DEFAULT_ZONE;

    }

    public void setDeliveryDate(Date newDate) {

        if (newDate!=null) deliveryDate=new Date(newDate);

        else deliveryDate=new Date();

    }

    public void setWeight(int newWeight) {

        if (newWeight>0) weight=newWeight;

        else weight=DEFAULT_WEIGHT;

    }

    public void setVolume(int newVolume) {

        if (newVolume>0) volume=newVolume;

        else volume=DEFAULT_VOLUME;

    }

    public String toString() {
        return   "ID:"+packageID+" Company:"+receiver+" Zone:"+zone+" Date:"+deliveryDate+" Weight:"+weight+" Volume:"+volume;
    }

    public int compareTo(Pack other){
        int zone_comparison = this.getZone().compareTo(other.getZone());
        if(zone_comparison == 0){
            if(this.getVolume() < other.getVolume()){
                return -1;
            } else if(this.getVolume() > other.getVolume()){
                return 1;
            }
            return 0;
        }
        return zone_comparison;
    }
}

