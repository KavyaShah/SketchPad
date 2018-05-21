package tutorials;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Contains the steps to draw Mickey Mouse.
 * @author kavyashah
 * @version 5/20/2018
 */
public class MickeyTutorial extends Tutorial{
	private static final ArrayList<String> mickeySteps = new ArrayList<String>(Arrays.asList("mickey/mickey1.jpg", "mickey/mickey2.jpg", "mickey/mickey3.jpg", "mickey/mickey4.jpg", "mickey/mickey5.jpg", "mickey/mickey6.jpg"));
	/**
	 * Creates a MickeyTutorial with pre-loaded images for the steps
	 */
	public MickeyTutorial() {
		super(mickeySteps);
	}
}
