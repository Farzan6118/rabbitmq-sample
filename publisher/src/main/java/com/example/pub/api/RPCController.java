package com.example.pub.api;

import com.example.pub.model.Contact;
import com.example.pub.send.RPCPublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@Profile("rpc")
@RestController
@RequestMapping("/api/v1/rpc")
public class RPCController {
    private final RPCPublisher rpcPublisher;

    public RPCController(RPCPublisher rpcPublisher) {
        this.rpcPublisher = rpcPublisher;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String SendInRPC(@RequestBody Contact message) throws ExecutionException, InterruptedException, TimeoutException {
        return rpcPublisher.sendAndReceiveWithRPC(message);
    }
}
