package com.inuki.HelloWorld;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class NameController {

    @GetMapping("/names")
    public List<String> getNames() {
	return Arrays.asList("inuki", "yamada");
    }

    @PostMapping("/names")
    public ResponseEntity<String> create(@Validated @RequestBody CreateForm form) {
	URI url = UriComponentsBuilder.fromUriString("http://localhost:8080").path("/names/id").build().toUri();
	return ResponseEntity.created(url).body("name successfully created");
    }

    Map<String, String> message = new HashMap<>();

    @PatchMapping("/names/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int id, @Validated @RequestBody UpdateForm form) {
	return ResponseEntity.ok(message.put("message", "name successfully updated"));
    }

    Map<String, String> deleteMessage = new HashMap<>();

    @DeleteMapping("/names/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id, @Validated @RequestBody DeleteForm form) {
	return ResponseEntity.ok(deleteMessage.put("message", "name successfully deleted"));
    }
}
