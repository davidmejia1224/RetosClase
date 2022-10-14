package com.doctors.controller;

import com.doctors.model.MessageModel;
import com.doctors.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<MessageModel> getAllMessage() {
        return messageService.getAllMessage();
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<MessageModel> getAllMessage2() {
        return messageService.getAllMessage();
    }

    @GetMapping("/{idMessage}")
    public Optional<MessageModel> getMessage(@PathVariable Integer idMessage) {
        return messageService.getMessage(idMessage);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageModel saveMessage(@RequestBody MessageModel messageModel) {
        return messageService.saveMessage(messageModel);
    }

    @DeleteMapping("/{idMessage}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteMessage(@PathVariable Integer idMessage) {
        return messageService.deleteMessage(idMessage);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageModel updateMessage(@RequestBody MessageModel messageModel) {
        return messageService.updateMessage(messageModel);
    }


}
