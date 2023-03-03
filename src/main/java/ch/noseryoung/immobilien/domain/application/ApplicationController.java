package ch.noseryoung.immobilien.domain.application;

import ch.noseryoung.immobilien.domain.application.applicationDto.ApplicationDto;
import ch.noseryoung.immobilien.domain.application.applicationDto.ApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/applications")
public class ApplicationController {
    private ApplicationService applicationService;
    private ApplicationMapper applicationMapper;

    @Autowired
    public ApplicationController(ApplicationService applicationService, ApplicationMapper applicationMapper) {
        this.applicationService = applicationService;
        this.applicationMapper = applicationMapper;
    }
    @PostMapping("/property/{propertyId}/user/{userId}")
    public ResponseEntity<ApplicationDto> create(@PathVariable("propertyId") UUID propertyId, @PathVariable("userId") UUID userId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(applicationMapper.toDTO(applicationService.create(userId, propertyId)));
    }

    @PatchMapping("/accept/property/{propertyId}/user/{userId}")
    public ResponseEntity<ApplicationDto> acceptStatus(@PathVariable("propertyId") UUID propertyId, @PathVariable("userId") UUID userId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(applicationMapper.toDTO(applicationService.acceptedStatus(userId, propertyId)));
    }

    @PatchMapping("/deny/property/{propertyId}/user/{userId}")
    public ResponseEntity<ApplicationDto> deniedStatus(@PathVariable("propertyId") UUID propertyId, @PathVariable("userId") UUID userId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(applicationMapper.toDTO(applicationService.deniedStatus(userId, propertyId)));
    }



}
