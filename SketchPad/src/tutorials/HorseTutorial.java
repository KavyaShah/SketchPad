package tutorials;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Contains the steps to draw a horse.
 * @author kavyashah
 * @version 5/20/2018
 */
public class HorseTutorial extends Tutorial {

	private static final ArrayList<String> horseSteps = new ArrayList<String>(Arrays.asList("horse/1horse.tif", "horse/2horse.tif", "horse/3horse.tif", "horse/4horse.tif", "horse/5horse.tif", "horse/6horse.JPG"));
	/**
	 * Creates a HorseTutorial with pre-loaded images for the steps
	 */
	public HorseTutorial() {
		super(horseSteps);
	}
}
