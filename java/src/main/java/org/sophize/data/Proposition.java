package org.sophize.data;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Proposition extends Resource {
    private Language language;
    private String[] lookupTerms;
    private String negativeStatement;
    private String statement;

    @JsonProperty("language")
    public Language getLanguage() { return language; }
    @JsonProperty("language")
    public void setLanguage(Language value) { this.language = value; }

    @JsonProperty("lookupTerms")
    public String[] getLookupTerms() { return lookupTerms; }
    @JsonProperty("lookupTerms")
    public void setLookupTerms(String[] value) { this.lookupTerms = value; }

    @JsonProperty("negativeStatement")
    public String getNegativeStatement() { return negativeStatement; }
    @JsonProperty("negativeStatement")
    public void setNegativeStatement(String value) { this.negativeStatement = value; }

    @JsonProperty("statement")
    public String getStatement() { return statement; }
    @JsonProperty("statement")
    public void setStatement(String value) { this.statement = value; }
}
