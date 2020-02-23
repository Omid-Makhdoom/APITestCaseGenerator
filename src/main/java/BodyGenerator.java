import java.util.HashSet;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.module.SimpleModule;

import io.swagger.inflector.examples.ExampleBuilder;
import io.swagger.inflector.examples.models.Example;
import io.swagger.inflector.processors.JsonNodeExampleSerializer;
import io.swagger.models.Model;
import io.swagger.util.Json;

public class BodyGenerator {
	
	
	public  BodyGenerator() {
		
		
	}
	
	
	public String GetValidBody(String modelName,Map<String, Model> definitions) {
		
		String body="";

		Model Model = definitions.get(modelName);
		
		Example example = ExampleBuilder.fromModel("Model", Model, definitions, new HashSet<String>());
		// Another way:
		// Example example = ExampleBuilder.fromProperty(new RefProperty("ApiCreateDeviceResponse"), swagger.getDefinitions());
		
		// Convert the Example object to string

		// JSON example
		
		
		return body;
	}
	
	

}
