package ee.eek.intro.web;

import ee.eek.intro.dto.HelloRequest;
import ee.eek.intro.dto.HelloResponse;
import ee.eek.intro.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class HelloController {
    private final HelloService helloService;

    @GetMapping("hello-world")
    public String sayHello() {
        return "Hello world!";
    }

    @GetMapping("hello")
    public String sayHello_ReqParam(@RequestParam String name) {
        return "Hello " + name + "!";
    }

    @GetMapping("hello/{name}")
    public String sayHello_PathVar(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @PostMapping("hello")
    public HelloResponse createName(@RequestBody HelloRequest helloRequest) {
//        return "new name record created " + helloRequest.getName();
//        return String.format("new name record created: %s %s", helloRequest.getFirstName(), helloRequest.getLastName());
//        return new HelloDto().setFullName(helloRequest.getFirstName() + " " + helloRequest.getLastName());
        return helloService.createName(helloRequest);
    }

    @GetMapping("bye")
    public String sayBye() {
        return "Goodbye world!";
    }
}
