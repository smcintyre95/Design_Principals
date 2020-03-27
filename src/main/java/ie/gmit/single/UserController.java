
/*
Stephen McIntyre
G00325469
Design Principles Lab

 */

package ie.gmit.single;

import com.fasterxml.jackson.databind.ObjectMapper;
/*
Stephen McIntyre
G00325469
Design Principles Lab

 */

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController {

    //Handles incoming JSON requests that work on User resource/entity

        //Store used by controller
        private Store store = new Store();

        //Create a new user
        public String createUser(String userJson) throws IOException {
            ObjectMapper mapper = new ObjectMapper();

            User user = mapper.readValue(userJson, User.class);
            Validation validation = new Validation(user);


            if(!validation.isValidUser(user)) {
                return "ERROR";
            }

            store.store(user);

            return "SUCCESS";
        }





 }

