package cloud.demo.controller;

import cloud.demo.dto.ResponseDto;
import cloud.demo.services.Service1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {
    //@Autowired
    private Service1 service1;

    @Autowired
    public SampleController(Service1 service1) {
        this.service1 = service1;
    }

    @GetMapping("/v1/samples")
    @ResponseBody
    public ResponseDto get(@RequestParam("id") String id) {
        String ret = service1.getSample(id);
        ResponseDto resp = new ResponseDto();
        resp.setVal(ret);
        return resp;
    }
}
