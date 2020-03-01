package org.sophize.data;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Project extends Resource {
    private String description;

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }
}
