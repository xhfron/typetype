package bean;

public class RankItem implements java.io.Serializable{
    String passageName;
    int speed;
    double rate;

    public RankItem(String passageName, int speed, double rate) {
        this.passageName = passageName;
        this.speed = speed;
        this.rate = rate;
    }

    public String getPassageName() {
        return passageName;
    }

    public void setPassageName(String passageName) {
        this.passageName = passageName;
    }
    public double getRate() {
        return rate;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return passageName+" "+speed+" "+rate;
    }
}
