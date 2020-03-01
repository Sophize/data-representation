package org.sophize.data;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Term extends Resource {
    private String definition;
    private String description;
    private Language language;
    private String[] lookupTerms;
    private String phrase;
    private Boolean primitive;

    @JsonProperty("definition")
    public String getDefinition() { return definition; }
    @JsonProperty("definition")
    public void setDefinition(String value) { this.definition = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("language")
    public Language getLanguage() { return language; }
    @JsonProperty("language")
    public void setLanguage(Language value) { this.language = value; }

    @JsonProperty("lookupTerms")
    public String[] getLookupTerms() { return lookupTerms; }
    @JsonProperty("lookupTerms")
    public void setLookupTerms(String[] value) { this.lookupTerms = value; }

    @JsonProperty("phrase")
    public String getPhrase() { return phrase; }
    @JsonProperty("phrase")
    public void setPhrase(String value) { this.phrase = value; }

    @JsonProperty("primitive")
    public Boolean getPrimitive() { return primitive; }
    @JsonProperty("primitive")
    public void setPrimitive(Boolean value) { this.primitive = value; }
}
