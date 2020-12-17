import org.junit.Assert;
import org.testng.annotations.Test;

public class PhoneTest {

    @Test
    public void testName() {
        Phone myPhone = new Phone("blue");
        myPhone.ring();

        String actualColor = myPhone.getColor();
        Assert.assertTrue(actualColor.equals("blue"));
    }

    @Test
    public void testPhoneTest002() {
        Phone myPhoneOne = new Phone("red");
        Phone myPhoneTwo = new Phone("yellow");

        Phone anotherPhone = new Phone(9, "iPhone", 32, "blue");

        myPhoneOne.setMemorySize(64);
        myPhoneTwo.setMemorySize(32);

        boolean isFirstPhoneBetter = myPhoneOne.getMemory() > myPhoneTwo.getMemory();

        Assert.assertTrue(isFirstPhoneBetter);

    }
}
