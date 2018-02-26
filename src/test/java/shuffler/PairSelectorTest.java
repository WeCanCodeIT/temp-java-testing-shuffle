package shuffler;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PairSelectorTest {

	@InjectMocks
	private PairSelector underTest;
	
	@Mock
	private Shuffler shuffler;
	
	@Mock
	private PersonRepository repository;
	
	@Mock
	private Collection<String> namesFromRepository;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		
		when(repository.findAll()).thenReturn(namesFromRepository);
	}
	
	@Test
	public void shouldGenerateOnePair() {
		
		when(shuffler.shuffle(namesFromRepository)).thenReturn(Arrays.asList("Larry", "Curly"));
		
		Collection<String> pairs = underTest.generate();
		
		assertThat(pairs, contains("Larry and Curly"));
	}
	
	@Test
	public void shouldGenerateTwoPair() {
		
		when(shuffler.shuffle(namesFromRepository)).thenReturn(Arrays.asList("Larry", "Curly", "Yakko", "Wakko"));
		
		Collection<String> pairs = underTest.generate();
		
		assertThat(pairs, contains("Larry and Curly", "Yakko and Wakko"));
	}
}
