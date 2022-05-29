
package aiss.model.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonCreator;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "console",
    "name",
    "review",
    "score"
})
@Generated("jsonschema2pojo")
public class Game {

    @JsonProperty("id")
    private String id;
    @JsonProperty("console")
    private List<String> console = null;
    @JsonProperty("name")
    private String name;
    @JsonProperty("review")
    private String review;
    @JsonProperty("score")
    private Integer score;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("console")
    public List<String> getConsole() {
        return console;
    }

    @JsonProperty("console")
    public void setConsole(List<String> console) {
        this.console = console;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("review")
    public String getReview() {
        return review;
    }

    @JsonProperty("review")
    public void setReview(String review) {
        this.review = review;
    }

    @JsonProperty("score")
    public Integer getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(Integer score) {
        this.score = score;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    @JsonCreator
	public Game(@JsonProperty("id") String id, @JsonProperty("console") List<String> console,
			@JsonProperty("name") String name,@JsonProperty("review") String review, 
			@JsonProperty("score") Integer score) {
		super();
		this.id = id;
		this.console = console;
		this.name = name;
		this.review = review;
		this.score = score;
	}
    @JsonCreator
	public Game(@JsonProperty("console") List<String> console,
			@JsonProperty("name") String name, 
			@JsonProperty("score") Integer score) {
		super();
		this.console = console;
		this.name = name;
		this.score = score;
	}
    
}
