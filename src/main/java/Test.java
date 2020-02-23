/*import java.util.ArrayList;
import java.util.Map;

import io.swagger.models.ArrayModel;
import io.swagger.models.HttpMethod;
import io.swagger.models.Model;
import io.swagger.models.ModelImpl;
import io.swagger.models.Operation;
import io.swagger.models.Path;
import io.swagger.models.Response;
import io.swagger.models.Swagger;
import io.swagger.models.parameters.BodyParameter;
import io.swagger.models.parameters.FormParameter;
import io.swagger.models.parameters.HeaderParameter;
import io.swagger.models.parameters.Parameter;
import io.swagger.models.parameters.PathParameter;
import io.swagger.models.parameters.QueryParameter;
import io.swagger.models.properties.Property;
import io.swagger.models.properties.RefProperty;
import io.swagger.models.refs.RefFormat;
import io.swagger.parser.SwaggerParser;

*/

import io.swagger.parser.SwaggerParser;
import io.swagger.models.*;
import io.swagger.models.properties.RefProperty;
import io.swagger.inflector.examples.ExampleBuilder;
import io.swagger.inflector.examples.*;
import io.swagger.inflector.examples.models.Example;
import io.swagger.inflector.processors.JsonNodeExampleSerializer;

import io.swagger.util.Json;

import java.util.HashSet;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ObjectNode;


public class Test {
	
	
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {

		String BaseUrl = "";
		String basePath = "";	
		String Schema = "";
		/*
		ArrayList<HttpRequest> reqList = new ArrayList<HttpRequest>();
		String swaggerpath="D:\\IDE\\Eclps wrkplc\\APITestCaseGenerator\\src\\main\\resources\\swaggerbd.json";
		// OpenAPI openAPI= new OpenAPIV3Parser().read("D:\\IDE\\Eclps
		// wrkplc\\APITestCaseGenerator\\src\\main\\resources\\swagger.json");
		//"D:\\IDE\\Eclps wrkplc\\APITestCaseGenerator\\src\\main\\resources\\swaggerPOD.json"
		// OpenAPI openAPI= new
		// OpenAPIV3Parser().read("http://iot.pod.ir/apidocs/api-docs.json");
		Swagger swagger = new SwaggerParser()
				.read(swaggerpath);
		
		BaseUrl = swagger.getHost();
		basePath=swagger.getBasePath();
		HttpRequest req = new HttpRequest();

		for (Map.Entry<String, Path> entry : swagger.getPaths().entrySet()) {

			String Path = entry.getKey();

			Map<HttpMethod, Operation> operationMap = entry.getValue().getOperationMap();

			for (Map.Entry<HttpMethod, Operation> op : operationMap.entrySet()) {

				req = new HttpRequest();
				Schema = "";

				req.setBaseUrl(BaseUrl);
				req.setBasePath(basePath);
				req.setPath(Path);

				req.setMethod(op.getKey().toString());

				req.setSummary(op.getValue().getSummary());
				req.setOperationId(op.getValue().getOperationId());
				
				
				// Get Parameters:
				for (Parameter p : op.getValue().getParameters()) {
					
					
					if(p instanceof HeaderParameter) {

						req.addHeaderParameter((HeaderParameter)p);
					}
					
					else  if(p instanceof QueryParameter) {

						req.addQueryParameter((QueryParameter)p);
					}
					else if(p instanceof FormParameter) {
						req.addFormParameter((FormParameter)p);
					}
					if(p instanceof PathParameter) {

						req.addPathParameter((PathParameter)p);
					}
					
					////BodyParameter-----

					else if (p instanceof BodyParameter) {
						

						Model m=((BodyParameter) p).getSchema();

						if(m.getClass().getSimpleName().matches("ModelImpl")) {
							System.out.println(((ModelImpl) m).getRequired().toString());

						}

						else 
						// if(m.getClass().getSimpleName().matches("w"))   {
							RefProperty rp = new RefProperty(m.getReference());



							System.out.println(rp.getType());
							System.out.println(rp.getRefFormat());
							System.out.println();

							if (rp.getRefFormat().equals(RefFormat.INTERNAL)
									&& swagger.getDefinitions().containsKey(rp.getSimpleRef())) {
								 m = swagger.getDefinitions().get(rp.getSimpleRef());

								if (m instanceof ArrayModel) {
									ArrayModel arrayModel = (ArrayModel) m;
									// System.out.println(rp.getSimpleRef() + "[]");
									if (arrayModel.getItems() instanceof RefProperty) {
										RefProperty arrayModelRefProp = (RefProperty) arrayModel.getItems();
										// printReference(swagger, arrayModelRefProp);
									}
								}

								if (m.getProperties() != null) {
										m.
									for (Map.Entry<String, Property> propertyEntry : m.getProperties().entrySet()) {
										req.addBody(propertyEntry);
										System.out.println(" " + propertyEntry.getKey() + " : " +
												propertyEntry.getValue().getType()+"  R"+propertyEntry.getValue().getRequired()+"class"+propertyEntry.getValue().getClass().getSimpleName());

									}
								}
							}
						}
					}
					

				}
				
				
				for (Map.Entry<String, Response> response : op.getValue().getResponses().entrySet()) {

					if (response.getKey().startsWith("2")) {
						//Schema += "\n" + response.getKey() + ": " + response.getValue().getDescription();
						req.setResponsestatus(Integer.parseInt(response.getKey()));
					}
				}
				
			}

			/*	System.out.println("Responses:");
				for (Map.Entry<String, Response> response : op.getValue().getResponses().entrySet()) {

					if (response.getKey().startsWith("2")) {
						Schema += "\n" + response.getKey() + ": " + response.getValue().getDescription();

						if (response.getValue().getSchema() instanceof RefProperty) {
							RefProperty rp = (RefProperty) response.getValue().getSchema();
							Schema += "\n" + gettReference(swagger, rp);
						}

						if (response.getValue().getSchema() instanceof ArrayProperty) {
							ArrayProperty ap = (ArrayProperty) response.getValue().getSchema();
							if (ap.getItems() instanceof RefProperty) {
								RefProperty rp = (RefProperty) ap.getItems();
								Schema += "\n" + rp.getSimpleRef() + "[]";
								Schema += "\n" + gettReference(swagger, rp);
							}
						}
					}
				}

				System.out.println(Schema);
				System.out.println("--------------------------------------");

			reqList.add(req);  
			
			
			
			
			
			
			
			
		}
		
		//return reqList;*/
		
		
		
		
		
		
		
		Swagger swagger = new SwaggerParser().read("D:\\IDE\\Eclps wrkplc\\APITestCaseGenerator\\src\\main\\resources\\swaggerbd.json");

		// Create an Example object for the Pet model
		Map<String, Model> definitions = swagger.getDefinitions();
		Model pet = definitions.get("ApiCreateDeviceResponse");
		
		Example example = ExampleBuilder.fromModel("Pet", pet, definitions, new HashSet<String>());

		//("Pet", pet, definitions, new HashSet<String>());
		// Another way:
		// Example example = ExampleBuilder.fromProperty(new RefProperty("ApiCreateDeviceResponse"), swagger.getDefinitions());

		// Configure example serializers
		SimpleModule simpleModule = new SimpleModule().addSerializer(new JsonNodeExampleSerializer());
		Json.mapper().registerModule(simpleModule);
		//Yaml.mapper().registerModule(simpleModule);

		// Convert the Example object to string

		// JSON example
		String jsonExample = Json.pretty(example);
		System.out.println(jsonExample);
		System.out.println("-------------------------");
		
		
		//Main main = new Main();
       // File file = main.getFile("data.json");
        ObjectMapper mapper = new ObjectMapper();
        
        JsonNode root = mapper.readTree(jsonExample);
        
       
            ObjectNode o = (ObjectNode) root;
            o.remove("id");
            o.remove("apiSsoKeys[0].certificate");
  
        
       /* for (JsonNode jsonNode : root) {
        	
            if (jsonNode instanceof ObjectNode) {
                ObjectNode o = (ObjectNode) jsonNode;
                o.remove("certificate");
            }
            
        }*/

        System.out.println(root.toPrettyString());    
		
		
		
		
		/*// YAML example
		String yamlExample = Yaml.pretty().writeValueAsString(example);
		System.out.println(yamlExample);

		// XML example (TODO: pretty-print it)
		String xmlExample = new XmlExampleSerializer().serialize(example);
		System.out.println(xmlExample);
		*/
		
		
		
		
		
		
		
		
		
	}

}
