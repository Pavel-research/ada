package org.amf.nlp.metamodel;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

import org.ada.metamodel.TypedStore;
import org.ada.metamodel.Universe;
import org.ada.metamodel.VocabularyLoader;
import org.raml.store.Store;
import org.raml.store.StoreManager;
import org.raml.vocabularies.Vocabulary;

import com.onpositive.clauses.ISelector;
import com.onpositive.clauses.impl.AllInstancesOf;
import com.onpositive.clauses.impl.MapByProperty;
import com.onpositive.clauses.impl.PropertyFilter;
import com.onpositive.clauses.impl.PropertyFilter.PropertyFilterMode;
import com.onpositive.clauses.impl.SingleSelector;
import com.onpositive.model.Builtins;
import com.onpositive.model.IClass;
import com.onpositive.model.IProperty;

import junit.framework.TestCase;

public class BasicTest extends TestCase {
	
	public void test0(){
		try {
			Universe loadFrom = new VocabularyLoader().loadFrom(new Vocabulary(BasicTest.class.getResource("/definition.yaml")));
			assertEquals(loadFrom.classes().size(), 9);
		} catch (IOException e) {
			assertTrue(false);
		}
	}
	
	public void test1(){
		Store st=StoreManager.getDebugStore();
		assertEquals(st.size(), 18688);
		try {
			Universe loadFrom = new VocabularyLoader().loadFrom(new Vocabulary(BasicTest.class.getResource("/definition.yaml")));
			TypedStore typedStore = new TypedStore(st, loadFrom,"http://github.org/model#");
			assertEquals(typedStore.allInstances().size(),18688);
			IClass tp = (IClass) typedStore.get("Repository");
			Optional<IProperty> property = tp.property("owner");
			AllInstancesOf repos = new AllInstancesOf(tp);
			MapByProperty ps=MapByProperty.map(property.get());		
			ISelector mm=ps.produce(repos);
			Collection<Object> execute = typedStore.execute(mm);
			int size = execute.size();			
			assertEquals(size,1062);
			Optional<IProperty> issues = tp.property("issues");
			long l0=System.currentTimeMillis();
			Collection<Object> execute2 = typedStore.execute(PropertyFilter.propertyFilter(issues.get(),new SingleSelector(100, Builtins.INTEGER),  PropertyFilterMode.COUNT_GREATER).produce(repos));
			assertEquals(execute2.size(), 11);
			long l1=System.currentTimeMillis();
			System.out.println(l1-l0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
