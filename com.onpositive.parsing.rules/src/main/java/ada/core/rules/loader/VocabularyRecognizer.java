package ada.core.rules.loader;

import org.ada.metamodel.Universe;

import com.onpositive.model.IClass;
import com.onpositive.model.IUniverse;
import com.onpositive.nlp.lexer.EntityRecognizer;

public class VocabularyRecognizer extends EntityRecognizer{

	protected Universe voc;

	public VocabularyRecognizer(IUniverse voc) {
		for (IClass t:voc.classes()) {
			addEntity(t.name(), t);
			t.properties().forEach(p->{
				addEntity(p.name(), p);
			});
		}
		
	}
}
