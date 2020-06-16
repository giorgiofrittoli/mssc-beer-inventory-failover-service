package it.frigir.msscbeerinventoryfailoverservice.web;

import it.frigir.brewery.model.BeerInventoryDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RequestMapping("api/v1/inventory-failover")
@Component
public class InventoryHandler {

    @GetMapping
    public Mono<ServerResponse> inventoryFailover(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(BeerInventoryDto.builder()
                        .beerId(UUID.fromString(StringUtils.repeat("0", 40))).build()), BeerInventoryDto.class);
    }

}
