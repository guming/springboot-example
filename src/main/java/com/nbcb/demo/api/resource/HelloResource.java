

package com.nbcb.demo.api.resource;

import com.nbcb.demo.config.Constants;
import com.nbcb.demo.domain.entity.Hello;
import com.nbcb.demo.api.dto.request.HelloRequestDTO;
import com.nbcb.demo.api.dto.response.HelloResponseDTO;
import com.nbcb.demo.service.HelloService;
import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(Constants.REST_BASE_URL_PATTERN)
public class HelloResource {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final HelloService helloService;

    @Autowired
    public HelloResource(HelloService helloService) {
        this.helloService = helloService;
    }

    @ApiOperation(value = "Hello", notes = "Display hello greeting", nickname = "hello")
    @GetMapping(value = "/hello")
    @Timed(value = "timer.api.hello", longTask = true)
    public ResponseEntity<HelloResponseDTO> hello(@Valid @ModelAttribute HelloRequestDTO helloRequestDTO) {
        logger.info("Request: " + helloRequestDTO);

        Hello hello = helloService.hello(helloRequestDTO.getName(), helloRequestDTO.getTitle());

        HelloResponseDTO helloResponseDTO = new HelloResponseDTO();

        BeanUtils.copyProperties(hello, helloResponseDTO);

        ResponseEntity<HelloResponseDTO> responseEntity = new ResponseEntity<>(helloResponseDTO, HttpStatus.OK);

        logger.info("Response: " + responseEntity);

        return responseEntity;
    }
}
