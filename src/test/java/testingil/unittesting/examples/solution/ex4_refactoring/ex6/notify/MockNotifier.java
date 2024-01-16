package testingil.unittesting.examples.solution.ex4_refactoring.ex6.notify;

public class MockNotifier implements NotifyService{
    public String notification_log="";

    @Override
    public void notifyTownCrier(String message) {
        notification_log += message;
        notification_log += "\n";
    }
}
