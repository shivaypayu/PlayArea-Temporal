package activities;

import io.temporal.workflow.Workflow;

import java.time.Duration;

public class TestActivityImpl implements TestActivity{

    @Override
    public String sum(){
        try{
            for(int i = 0 ; i < 23 ; i++){

                System.out.println("In loop exec: " + i);
                Thread.sleep(20);
            }
        }catch (Exception ignored){

        }

        return "fhghjyj";



    }


}
