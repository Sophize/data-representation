package org.sophize.data;

import java.util.*;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Language {
    INFORMAL;

    @JsonValue
    public String toValue() {
        switch (this) {
        case INFORMAL: return "INFORMAL";
        }
        return null;
    }

    @JsonCreator
    public static Language forValue(String value) throws IOException {
        if (value.equals("INFORMAL")) return INFORMAL;
        throw new IOException("Cannot deserialize Language");
    }
}
