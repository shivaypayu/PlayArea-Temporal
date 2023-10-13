package workflow;

import io.temporal.workflow.SignalMethod;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface SecondI {

    @WorkflowMethod
    public String run();

    @SignalMethod
    public void testSignal(int i);


}
