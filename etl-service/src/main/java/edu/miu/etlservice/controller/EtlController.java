package edu.miu.etlservice.controller;

import edu.miu.etlservice.service.impl.EtlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static edu.miu.etlservice.constant.WebResourceKeyConstant.API_V1;
import static edu.miu.etlservice.constant.WebResourceKeyConstant.UserConstants.ETL_BASE;

@RestController
@RequestMapping(value = API_V1 + ETL_BASE)
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
