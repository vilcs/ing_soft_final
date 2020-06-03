package bo.edu.ucb.sis.piratebay.controller;

import bo.edu.ucb.sis.piratebay.bl.SecurityBl;
import bo.edu.ucb.sis.piratebay.model.CredentialModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/security")
@CrossOrigin(origins = "*")
public class SecurityController {

    private SecurityBl securityBl;

    @Autowired
    public SecurityController(SecurityBl securityBl) {
        this.securityBl = securityBl;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,  consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Map<String, Object>> authenticate(@RequestBody CredentialModel credentialsModel) {

        String jwt = securityBl.authenticate(credentialsModel.getUsername(), credentialsModel.getPassword());

        if( jwt != null ) {
            Map <String, Object> response = new HashMap();
            response.put("message", "Authentication OK");
            response.put("token", jwt);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Map <String, Object> response = new HashMap();
            response.put("message", "User or password invalid");
            return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
        }
    }


}
