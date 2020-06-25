package co.edu.escuelaing.arsw.tablero;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WebSiteController {

    @Resource
    private HttpServletRequest request;
    
    public static void main(String[] args) {
        SpringApplication.run(WebSiteController.class, args);
    }

    @GetMapping("/status")
    public String status() {
        return "{\"status\":\"Greetings from Spring Boot. "
                + java.time.LocalDate.now() + ", "
                + java.time.LocalTime.now()
                + ". " + "The server is Runnig!\"}";
    }
    
    @GetMapping("/")
    public String get(){
        System.out.println(request.getSession().getId());
        return "index";
    }

    @PostMapping("/addPoint")
    public void addPoint (@RequestParam (value="x") String x,@RequestParam (value="y") String y){
        Double x1 = Double.parseDouble(x);
        Double y1 = Double.parseDouble(y);
        Cola.getInstance().add(new Punto(x1,y1)); 
    }

    public String getId(){
        return request.getSession().getId();
    }
}
