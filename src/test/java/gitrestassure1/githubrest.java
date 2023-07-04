package gitrestassure1;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.json.simple.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class githubrest {
 String url="https://api.github.com";
 String repo_name="projectpostman108";
 String repo_name1="projectpostman201";
 String file_name="newcontentCreated2.txt";
 String autolinkId;
 
 @Test(priority=1)
 public void create_a_userrepo()
 {
	// RestAssured.baseURI=baseURL;
	 JSONObject jon = new JSONObject();
	 jon.put("name",repo_name);
		given().baseUri(url)
		.header("Authorization","Bearer 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")
		.header("Content-Type","application/json")
		 .body(jon.toJSONString())
		.when()
		.post("/user/repos")
		.then()
		.statusCode(201)
		.log()
		.all();
		System.out.println("created repository");
 }
 
 @Test(priority=2)
 public void update()
 {
	  
	 JSONObject jon = new JSONObject();
	jon.put("name",repo_name1);
		given().baseUri(url)
		.header("Authorization","Bearer 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")
		.header("Content-Type","application/json")
		 .body(jon.toJSONString())
		.when()
		.patch("repos/Deepika9513/"+repo_name)
		.then()
		.statusCode(200)
		.log()
		.all();
		System.out.println("updated repository");
		
 }
 
 
 @Test(priority=4)
 public void delete_repo()
 {
	  
	// JSONObject jon=new JSONObject();
	//jon.put("name","projectposman8");
		given().baseUri(url)
		.header("Authorization","Bearer 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")
		.header("Content-Type","application/json")
		// .body(jon.toJSONString())
		.when()
		.delete("repos/Deepika9513/"+repo_name1)
		.then()
		.statusCode(204)
		.log()
		.all();
		System.out.println("Delete repository");
 }
 
 @Test(priority=3)
 public void get_repo()
 {
	  
	
		given().baseUri(url)
		.header("Authorization","Bearer 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")
		.header("Content-Type","application/json")
		.when()
		.get("repos/Deepika9513/"+repo_name1)
		.then()
		.statusCode(200)
		.log()
		.all();
		System.out.println("get a projectpostman99 repository");
 }
 
 @Test(priority=5)
 public void create_forks()
 {
	 
		given().baseUri(url)
		.header("Authorization","Bearer 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")
		.header("Content-Type","application/json")
		.when()
		.post("repos/abhivaikar/howtheytest/forks")
		.then()
		.statusCode(202)
		.log()
		.all();
		System.out.println("created a fork in abhivaikar repository");
 }
 
 @Test(priority=6)
 public void list_forks()
 {
	  
		given().baseUri(url)
		.header("Authorization","Bearer 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")
		.header("Content-Type","application/json")
		.when()
		.get("repos/abhivaikar/howtheytest")
		.then()
		.statusCode(200)
		.log()
		.all();
		System.out.println("list forks");
 }
 
 @Test(priority=7)
 public void list_repo()
 {
	 JSONObject jon = new JSONObject();
	 jon.put("name","projectpostman99");
		given().baseUri(url)
		.header("Authorization","Bearer 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")
		.header("Content-Type","application/json")
		.when()
		.get("/users")
		.then()
		.statusCode(200)
		.log()
		.all();
		System.out.println("list repository for a user");
 }
 
 @Test(priority=8)
 public void listrepo_language()
 {
	  
		given().baseUri(url)
		.header("Authorization","Bearer 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")
		.header("Content-Type","application/json")
		.when()
		.get("repos/Deepika9513/thesouledproject")
		.then()
		.statusCode(200)
		.log()
		.all();
		System.out.println("list repository language");
 }
 
 @Test(priority=9)
 public void listpblic_repo()
 {
	  
	 
		given().baseUri(url)
		.header("Authorization","Bearer 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")
		.header("Content-Type","application/json")
		.when()
		.get("repositories")
		.then()
		.statusCode(200)
		.log()
		.all();
	System.out.println("list publicrepository");
 }
 
 @Test(priority=10)
 public void create_or_updatefile()
 {
	 JSONObject jon=new JSONObject();
		jon.put("message","New text Ocntantoaosdlafdoifasdlkfnoa fadfasf");
		jon.put("content","bXkgbmV3IGZpbGUgY29udGVudHM=");
		System.out.println(jon);
		given().baseUri(url)
		.header("Authorization","Bearer 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")
		.header("Content-Type","application/json")
		.body(jon.toJSONString())
		.when()
		.put("repos/Deepika9513/thesouledproject/contents/notes/"+file_name)
		.then()
		.statusCode(201)
		.log()
		.all();
		System.out.println("create or update file content");
 }
 
 @Test(priority=11)
 public void delete_file()
 {
	  
	 JSONObject jon=new JSONObject();
	jon.put("message","TestNEwo");
	jon.put("sha","0d5a690c8fad5e605a6e8766295d9d459d65de42");
	System.out.println(jon);
		given().baseUri(url)
		.header("Authorization","Bearer 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")
		.header("Content-Type","application/json")
		 .body(jon.toJSONString())
		.when()
		.delete("repos/Deepika9513/thesouledproject/contents/notes/"+file_name)
		.then()
		.statusCode(200)
		.log()
		.all();
		System.out.println("deleted file");
 }
 
 @Test(priority=12)
 public void listrepo_tags()
 {
		given().baseUri(url)
		.header("Authorization","Bearer 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")
		.header("Content-Type","application/json")
		.when()
		.get("repos/Deepika9513/thesouledproject/tags")
		.then()
		.statusCode(200)
		.log()
		.all();
		System.out.println("list repository tags");
 }
 
 @Test(priority=14)
 public void create_autolink()
 {
	  
	JSONObject jon=new JSONObject();
	jon.put("key_prefix","BUGCODE12-");
	jon.put( "url_template", "https://testcase311.atlassian.net/browse/NewTestE-<num>");
	jon.put("is_alphanumeric", true);
	System.out.println(jon);
	Response response = given().baseUri(url).header("Authorization","Bearer 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").header("Content-Type","application/json").body(jon.toJSONString())
		.log()
		.all()
		.when()
		.post("repos/Deepika9513/thesouledproject/autolinks")
		.then()
		.statusCode(201)
		.extract()
        .response();
        
		autolinkId = response.jsonPath().getString("id");

		System.out.println("create an autolink reference for a repository");
 }
 
 @Test(priority=13)
 public void getall_repotopics()
 {
	  
		given().baseUri(url)
		.header("Authorization","Bearer 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")
		.header("Content-Type","application/json")
		.when()
		.get("repos/Deepika9513/thesouledproject/topics")
		.then()
		.statusCode(200)
		.log()
		.all();
		System.out.println("get all repository topics");
 }
 
 @Test(priority=15)
 public void getan_autolinkreference()
 {
	  
		given().baseUri(url)
		.header("Authorization","Bearer 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")
		.header("Content-Type","application/json")
		.log()
		.uri()
		.when()
		.get("repos/Deepika9513/thesouledproject/autolinks/"+autolinkId)
		.then()
		.statusCode(200);
		
		System.out.println("get an autolink reference for a repository");
 }
 
 @Test(priority=16)
 public void delete_autolinkreference()
 {
	  
		given().baseUri(url)
		.header("Authorization","Bearer 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")
		.header("Content-Type","application/json")
		.log()
		.uri()
		.when()
		.delete("repos/Deepika9513/thesouledproject/autolinks/"+autolinkId)
		.then()
		.log()
		.all()
		.statusCode(204)
		.log()
		.all();
		System.out.println("delete from an autolink reference for a repository");
 }
 
 @Test(priority=17)
 public void geta_repo()
 {
		given().baseUri(url)
		.header("Authorization","Bearer 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")
		.header("Content-Type","application/json")
		.when()
		.get("repos/Deepika9513/thesouledproject")
		.then()
		.statusCode(200)
		.log()
		.all();
		System.out.println("get a repository");
 }
 
 @Test(priority=18)
 public void replaceall_repo()
 {
	  
	JSONObject jon=new JSONObject();
	JSONArray array = new JSONArray();
    array.add("testing3");
    array.add("testnew4");
    array.add("docs3");
    jon.put("names",array);
	
	System.out.println(jon);
		given().baseUri(url)
		.header("Authorization","Bearer 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")
		.header("Content-Type","application/json")
		 .body(jon.toJSONString())
		.when()
		.put("repos/Deepika9513/thesouledproject/topics")
		.then()
		.statusCode(200)
		.log()
		.all();
		System.out.println("replace all repository topics");
 }
}
