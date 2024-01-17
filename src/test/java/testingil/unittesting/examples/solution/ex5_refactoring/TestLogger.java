package testingil.unittesting.examples.solution.ex5_refactoring;

public class TestLogger {
	
	private StringBuilder sb = new StringBuilder();
	
	public void append(char key, String display) {
		sb.append("Pressed " + key + ", Display shows: " + display + "\n");
	}

	public String getAll() {
		return sb.toString();
	}
}
