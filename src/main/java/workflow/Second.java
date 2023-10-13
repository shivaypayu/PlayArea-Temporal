package workflow;

import activities.TestActivity;
import activities.TestActivity2;
import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Second implements SecondI {

    ActivityOptions options = ActivityOptions.newBuilder().setStartToCloseTimeout(Duration.ofSeconds(50)).
                                setRetryOptions(RetryOptions.newBuilder().setMaximumAttempts(4)
                                        .build()).build();
    private final TestActivity activity = Workflow.newActivityStub(TestActivity.class,options);

    private final TestActivity2 activity2 = Workflow.newActivityStub(TestActivity2.class,options);


    List<Integer> response = new ArrayList<>();

    boolean exit = false;

    @Override
    public String run() {

        System.out.println("started......");

//        response.add(1);
//
//        if(response.get(0) == 9){
//            exit = true;
//        }
        Workflow.await(() -> !exit);



            activity2.diff();

            Workflow.sleep(Duration.of(3, ChronoUnit.SECONDS));

            activity.sum();


        return "second workflow...";
    }


    @Override
    public void testSignal(int i) {
        System.out.println("inside signal...");
        exit =  true;

        System.out.println("lets break everything.....:( ");
    }

}
