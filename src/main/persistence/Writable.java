package persistence;

import  org.json.JSONObject;
//  return the writable object

public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
