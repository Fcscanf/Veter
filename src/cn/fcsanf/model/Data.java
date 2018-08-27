package cn.fcsanf.model;

/**
    *@Author:Fcscanf
    *@Description:将数据封装成对象
    *@Date:下午 23:10 2018/4/28
    */
public class Data {
    private int id;
    private String turbidity;
    private String temperature;
    private String ph;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTurbidity() {
        return turbidity;
    }

    public void setTurbidity(String turbidity) {
        this.turbidity = turbidity;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public Data() {
        super();
    }

    public Data(String turbidity,String temperature,String ph) {
        this.turbidity = turbidity;
        this.temperature = temperature;
        this.ph = ph;
    }
}
