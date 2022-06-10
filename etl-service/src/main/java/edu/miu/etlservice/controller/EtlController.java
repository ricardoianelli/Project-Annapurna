package edu.miu.etlservice.controller;

import edu.miu.etlservice.service.EtlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static edu.miu.etlservice.constant.WebResourceKeyConstant.API_V1;
import static edu.miu.etlservice.constant.WebResourceKeyConstant.UserConstants.USER_BASE;

@RestController
@RequestMapping(value = API_V1 + USER_BASE)
public class EtlController {

    private final EtlService etlService;

    public EtlController(EtlService etlService) {
        this.etlService = etlService;
    }

    @PostMapping("/fetch")
    public ResponseEntity<?> fetch(){
        etlService.fetch();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
