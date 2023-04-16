package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    //This method will create a map for payload --
    public Map<String, Object> expectedDataMapMethod(Integer userId, String title, Boolean completed){//put here wrapper class
        //because others may not accept null values that we may need to use.

        Map<String, Object> expectedData = new HashMap<>();

        if(userId!=null){
            expectedData.put("userId", userId);
        }if(title!=null){
            expectedData.put("title", title);
        }if(completed!=null){
            expectedData.put("completed", completed);
        }
        return expectedData;
    }

}
