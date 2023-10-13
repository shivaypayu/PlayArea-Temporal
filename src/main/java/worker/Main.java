package worker;

import io.temporal.api.common.v1.WorkflowExecution;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.common.RetryOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import lombok.extern.slf4j.Slf4j;
import workflow.SecondI;

import java.time.Duration;

@Slf4j
public class Main {
    private static final WorkflowServiceStubs service =  WorkflowServiceStubs.newLocalServiceStubs();
    public static final WorkflowClient client = WorkflowClient.newInstance(service);



    public static void main(String[] args) {
        SecondI testWorkFlow = client.newWorkflowStub(SecondI.class,
                                    WorkflowOptions.newBuilder().setTaskQueue(Utils.taskQueue).
                                            setRetryOptions(RetryOptions.newBuilder().setMaximumAttempts(4).build())
                                    .setWorkflowRunTimeout(Duration.ofSeconds(50)).build());


        System.out.println("!!!--------!!!");







        //CompletableFuture<String> resultFuture = WorkflowClient.execute(testWorkFlow::exec);





        WorkflowExecution workflowExecution = WorkflowClient.start(testWorkFlow::run);


        SecondI workflowById = client.newWorkflowStub(SecondI.class ,workflowExecution.getWorkflowId());
        workflowById.testSignal(9);
        System.out.println("test");


        String id = workflowExecution.getWorkflowId();
        System.out.println(id);


    }
}
