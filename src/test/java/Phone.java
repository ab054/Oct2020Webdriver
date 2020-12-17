public class Phone {

    int screenSize;
    String model;
    int memorySize;
    String color;

    public Phone(String colorParameter) {
        color = colorParameter;
    }

    public Phone(int screenSize, String model, int memorySize, String color) {
        this.screenSize = screenSize;
        this.model = model;
        this.memorySize = memorySize;
        this.color = color;
    }

    public void ring(){
        System.out.println("RING!!!");
    }

    public void sendMessage(){
        System.out.println("MESSAGE SENT!!!");
    }

    public void receiveCall(){
        System.out.println("CALL RECEIVED!!!");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMemorySize(int memoryValue) {
        memorySize = memoryValue;
    }

    public int getMemory() {
        return memorySize;
    }
}
