package worker;

import activities.TestActivityImpl;
import activities.TestActivityImpl2;
import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import io.temporal.worker.WorkflowImplementationOptions;
import workflow.Second;


public class TestWorker {

    private static final WorkflowServiceStubs service =  WorkflowServiceStubs.newLocalServiceStubs();
    public static final WorkflowClient client = WorkflowClient.newInstance(service);


    public static void main(String[] args) {
        WorkflowImplementationOptions workflowImplementationOptions = WorkflowImplementationOptions.newBuilder().build();

        WorkerFactory workerFactory = WorkerFactory.newInstance(client);
        Worker worker = workerFactory.newWorker(Utils.taskQueue);

        //ActivityOptions activityOptions = ActivityOptions.newBuilder().build();



        worker.registerWorkflowImplementationTypes(Second.class);
        worker.registerActivitiesImplementations(new TestActivityImpl() , new TestActivityImpl2());

        workerFactory.start();

        System.out.println("worker started...");
    }

}
