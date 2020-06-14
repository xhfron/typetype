package Item;

public class RankItem implements java.io.Serializable{
    private String passageName;
    private int speed;
    private double rate;

    public RankItem(String passageName, int speed, double rate) {
        this.passageName = passageName;
        this.speed = speed;
        this.rate = rate;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "文章"+String.format("%8.8s",passageName)+" 速度"+String.format("%4.4s",speed)+" 正确率"+String.format("%.2f",rate*100)+"%";
    }
}
