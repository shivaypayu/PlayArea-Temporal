package activities;

public class TestActivityImpl2 implements TestActivity2 {

    @Override
    public int diff(){
        System.out.println("activity 2...");
        return 10 - 9;
    }
}
