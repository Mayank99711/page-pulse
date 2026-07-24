package com.mayank.pagepulse.controller;

import com.mayank.pagepulse.dto.AuditRequest;
import com.mayank.pagepulse.dto.AuditResponse;
import com.mayank.pagepulse.service.AuditService;   // <-- Ye import add karo
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AuditController {

    private final AuditService auditService;

    public AuditController(AuditService auditService) {
        this.auditService = auditService;
    }

    @PostMapping("/analyze")
    public AuditResponse analyze(@Valid @RequestBody AuditRequest request) throws Exception {
        return auditService.analyze(request.getUrl());
    }
}