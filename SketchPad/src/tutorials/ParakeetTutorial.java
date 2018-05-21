package tutorials;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Contains the steps to draw a parakeet.
 * @author kavyashah
 * @version 5/20/2018
 */
public class ParakeetTutorial extends Tutorial {

	private static final ArrayList<String> parakeetSteps = new ArrayList<String>(Arrays.asList("bird/bird1.jpg", "bird/bird2.jpg", "bird/bird3.jpg", "bird/bird4.jpg","bird/bird5.jpg", "bird/bird6.jpg", "bird/bird7.jpg", "bird/bird8.jpg", "bird/bird9.jpg", "bird/bird10.jpg"));
	/**
	 * Creates a ParakeetTutorial with pre-loaded images for the steps
	 */
	public ParakeetTutorial() {
		super(parakeetSteps);
	}
}
