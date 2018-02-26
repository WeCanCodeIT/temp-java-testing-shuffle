package shuffler;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

public class ShufflerTest {

	/**
	 * This isn't really very testable. All we can really do is verify that all of
	 * the same elements are in the {@link List} that comes back.
	 */
	@Test
	public void shouldShuffle() {
		Collection<String> elements = Arrays.asList("a", "b", "c");
		Shuffler underTest = new Shuffler();
		
		List<String> result = underTest.shuffle(elements);
		
		assertThat(result, containsInAnyOrder("a", "b", "c"));
	}
}
