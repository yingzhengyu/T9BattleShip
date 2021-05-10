import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


import controller.Controller;
import controller.Message;
import model.Board;
import view.View;

public class App {
	
	public static void main(String [] args) {
		BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
		Board model = new Board();
		View view = new View(queue);
		Controller controller = new Controller(queue, model, view);
		controller.mainLoop();
	}
}
