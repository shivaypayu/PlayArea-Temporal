//package workflow;
//
//import activities.TestActivity;
//import activities.TestActivity2;
//import io.temporal.activity.ActivityOptions;
//import io.temporal.workflow.Workflow;
//import workflow.TestWorkFlow;
//
//import java.time.Duration;
//
//public class TestWorkFlowImpl implements TestWorkFlow {
//
//   ActivityOptions options2 = ActivityOptions.newBuilder().setStartToCloseTimeout(Duration.ofSeconds(1)).build();
//   ActivityOptions options1 = ActivityOptions.newBuilder().setStartToCloseTimeout(Duration.ofSeconds(1)).build();
//    private final TestActivity activity = Workflow.newActivityStub(TestActivity.class,options1);
//
//    private final TestActivity2 activity2 = Workflow.newActivityStub(TestActivity2.class,options2);
//
//    @Override
//    public String exec()  {
//        System.out.println("shivay");
//        String id = Workflow.getInfo().getWorkflowId();
//        System.out.println(id);
//
//        System.out.println("implementing second activity!!");
//        activity2.diff();
//
//        Workflow.await(()-> true);
//
//        System.out.println("implementing first activity!!");
//        activity.sum();
//
////        Workflow.await(()-> true);
////
////        System.out.println("implementing first activity again!!!!");
////        activity.mult();
//
//
//        return "test";
//
//
//    }
//
//
//    @Override
//    public void run() {
//
//    }
//
//
////   @Override
////   public void run(){
////       System.out.println("2nd worker running");
////   }
//
//
//
//
//
//}
