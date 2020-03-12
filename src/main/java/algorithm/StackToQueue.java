package algorithm;

import java.util.Stack;

/**
 * @author: duke
 * @date: 2019/7/16 10:20 AM
 */
public class StackToQueue {

    private void appendTail(Object object){
        input.push(object);
    }

    public Object deleteHead() throws Exception {
        if (output.size() <= 0){
            while (input.size() > 0){
                output.push(input.pop());
            }
        }
        if (output.size() == 0){
            throw new Exception("queue is empty");
        }
        return output.pop();
    }

    private Stack<Object> input;
    private Stack<Object> output;

    public StackToQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public Stack<Object> getInput() {
        return input;
    }

    public void setInput(Stack<Object> input) {
        this.input = input;
    }

    public Stack<Object> getOutput() {
        return output;
    }

    public void setOutput(Stack<Object> output) {
        this.output = output;
    }

    public static void main(String[] args) throws Exception {
        StackToQueue stackToQueue = new StackToQueue();
        stackToQueue.appendTail(1);
        stackToQueue.appendTail("2");
        System.out.println();
        System.out.println(stackToQueue.deleteHead());
        System.out.println(stackToQueue.deleteHead());
    }
}
