import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.module.SimpleModule;

import io.swagger.inflector.examples.ExampleBuilder;
import io.swagger.inflector.examples.models.Example;
import io.swagger.inflector.processors.JsonNodeExampleSerializer;
import io.swagger.models.Model;
import io.swagger.models.properties.Property;
import io.swagger.util.Json;


public class BodyItem {


	private Map<String, Model> definitions=null;
	private Model model=null;
			String  name="";

	public BodyItem() {


	}


	public BodyItem( Model model, Map<String, Model> definitions) {


		this.definitions=definitions;
		this.model=model;

	}

	public void setModel(Model model){
		this.model=model;

	}
	
	public void setDefinitions(Map<String, Model> definitions){
		this.definitions=definitions;

	}

	 public void SetName(String Name) {
		 
		 this.name=name;
		 
	 }
	 
	 public String GetValidBodyString() {
			
			String body="";
			
			Example example = ExampleBuilder.fromModel(name, model, definitions, new HashSet<String>());
			// Another way:
			// Example example = ExampleBuilder.fromProperty(new RefProperty("ApiCreateDeviceResponse"), swagger.getDefinitions());

			// Configure example Serializer
			SimpleModule simpleModule = new SimpleModule().addSerializer(new JsonNodeExampleSerializer());
			Json.mapper().registerModule(simpleModule);
			// Convert the Example object to string

			// JSON example
			body = Json.pretty(example);
			body=body.replace("\\", "\\\\").replace("/", "\\/").replace("\"", "\\\"").replace("'", "\\'").replace("\n", " \\n").replace("\r", "");
					
			return body;
		}

}