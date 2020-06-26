package co.edu.escuelaing.arsw.tablero;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
    /*
    @GetMapping("/status")
    public String status() {
        return "{\"status\":\"Greetings from Spring Boot. "
                + java.time.LocalDate.now() + ", "
                + java.time.LocalTime.now()
                + ". " + "The server is Runnig!\"}";
    }

    /*
    @GetMapping("/")
    public String get(){
        System.out.println(request.getSession().getId());
        return "index";
    }
     */
    /**
     * Este método agrega un punto a la cola
     * @param x posición en x del punto
     * @param y posición en y del punto
     */
    @PostMapping("/addPoint")
    public void addPoint(@RequestParam(value = "x") String x, @RequestParam(value = "y") String y) {
        Double x1 = Double.parseDouble(x);
        Double y1 = Double.parseDouble(y);
        Cola.getInstance().add(new Punto(x1, y1));
    }
    /**
     * Este método devuelve el punto que sigue en la cola
     * @return json el punto represntado en JSON
     */
    @GetMapping("/getPoint")
    public String getPoint() {
        try {
            ObjectMapper map = new ObjectMapper();
            Punto p = Cola.getInstance().next();
            String json = map.writeValueAsString(p);
            return json;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(WebSiteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    /**
     * Este método consulta si la cola de Puntos está vacia
     * @return true si está vacía
     */
    @GetMapping("/vacio")
    public boolean isEmpty(){
        return Cola.getInstance().isEmpty();
    }

}
