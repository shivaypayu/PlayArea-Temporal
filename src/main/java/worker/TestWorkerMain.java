//package worker;
//
//import io.temporal.api.common.v1.WorkflowExecution;
//import io.temporal.client.WorkflowClient;
//import io.temporal.client.WorkflowOptions;
//import io.temporal.serviceclient.WorkflowServiceStubs;
//import lombok.extern.slf4j.Slf4j;
//import workflow.TestWorkFlow;
//
//import java.time.Duration;
//
//@Slf4j
//public class TestWorkerMain {
//
//    private static final WorkflowServiceStubs service =  WorkflowServiceStubs.newLocalServiceStubs();
//    public static final WorkflowClient client = WorkflowClient.newInstance(service);
//
//
//    public static void main(String[] args) {
//        TestWorkFlow testWorkFlow = client.newWorkflowStub(TestWorkFlow.class,
//                WorkflowOptions.newBuilder().setTaskQueue(Utils.taskQueue).build());
//
//
//
//        WorkflowExecution workflowExecution = WorkflowClient.start(testWorkFlow::exec);
//
//
//
//
//
//
//
//
//        //CompletableFuture<String> resultFuture = WorkflowClient.execute(testWorkFlow::exec);
//
//
//        String reslt = workflowExecution.toString();
//        System.out.println(reslt);
//
//
//
//        log.info("workflow id " +  "::" + workflowExecution.getWorkflowId());
//    }
//
//
//
//}
