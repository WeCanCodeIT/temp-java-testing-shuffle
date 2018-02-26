package shuffler;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PairSelector {

	private Shuffler shuffler;
	
	private PersonRepository repository;

	public Collection<String> generate() {
		
		Collection<String> namesFromRepo = repository.findAll();
		
		List<String> shuffled = shuffler.shuffle(namesFromRepo);
		
		List<String> pairs = new ArrayList<>();
		for(int index = 0; index < shuffled.size(); index += 2) {
			pairs.add(format("%s and %s", shuffled.get(index), shuffled.get(index + 1)));
		}
		return pairs;
	}

}
