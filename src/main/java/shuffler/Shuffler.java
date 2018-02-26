package shuffler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Shuffler {

	public List<String> shuffle(Collection<String> source) {
		List<String> shuffled = new ArrayList<>(source);
		
		Collections.shuffle(shuffled);
		
		return shuffled;
	}
}
