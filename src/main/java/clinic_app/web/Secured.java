package clinic_app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/secured")
public class Secured {

    @GetMapping
    public String getSecuredView() {
        return "secured";
    }
}
