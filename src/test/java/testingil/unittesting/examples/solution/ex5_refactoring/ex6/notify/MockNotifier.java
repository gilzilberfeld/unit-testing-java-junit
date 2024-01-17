package testingil.unittesting.examples.solution.ex5_refactoring.ex6.notify;

public class MockNotifier implements NotifyService{
    public String notification_log="";

    @Override
    public void notifyTownCrier(String message) {
        notification_log += message;
        notification_log += "\n";
    }
}
