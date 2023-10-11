package ee.eek.intro.service;

import ee.eek.intro.dto.HelloRequest;
import ee.eek.intro.dto.HelloResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloService {
    private final IdentityProvider identityProvider;
//    public HelloService(IdentityProvider identityProvider) {
//        this.identityProvider = new IdentityProvider();
//    }
    public HelloResponse createName(HelloRequest helloRequest) {
        return new HelloResponse()
                .setFullName(helloRequest.getFirstName() + " " + helloRequest.getLastName())
                .setUniversity(identityProvider.getUniversity(helloRequest))
                .setRole(identityProvider.getRole(helloRequest));
    }
}
