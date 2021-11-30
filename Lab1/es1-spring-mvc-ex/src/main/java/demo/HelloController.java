package demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @RequestMapping("/") //mappa la pagina a un URL
    public String display(
        @RequestParam(name="name",required=false,defaultValue="World") String name, Model model){
        model.addAttribute("name",name);
        return "index";
    }

    @RequestMapping("query")
    public String ask(){
            return("ask");//ritorno il nome del file dove ho messo la pagina
    }


}
