package ee.eek.intro.service;

import ee.eek.intro.dto.HelloRequest;
import org.springframework.stereotype.Component;

@Component
public class IdentityProvider {
    public static final String MAINOR_TEACHER = "Nikita";
    public static final String MAINOR_STUDENT = "tim";

    public String getUniversity(HelloRequest helloRequest) {
        if (helloRequest.getFirstName().equalsIgnoreCase(MAINOR_TEACHER) ||
        helloRequest.getFirstName().equalsIgnoreCase(MAINOR_STUDENT)) {
            return "Mainor";
        }
        return "TalTech";
    }

    public String getRole(HelloRequest helloRequest) {
        if (helloRequest.getFirstName().equalsIgnoreCase(MAINOR_TEACHER)) {
            return "teacher";
        }
        if (helloRequest.getFirstName().equalsIgnoreCase(MAINOR_STUDENT)) {
            return "student";
        }
        return "student";
    }

}
