package it.frigir.msscbeerinventoryfailoverservice.web;

import it.frigir.brewery.model.BeerInventoryDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/inventory-failover")
@Component
public class InventoryHandler {

    @GetMapping
    public Mono<ServerResponse> listInventory(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(Mono.just(Arrays.asList(BeerInventoryDto.builder()
                                .id(UUID.randomUUID())
                                .beerId(UUID.fromString("00000000-00000000-00000000-00000000"))
                                .quantityOnHand(999)
                                .createdDate(OffsetDateTime.now())
                                .lastModifiedDate(OffsetDateTime.now()).build())),
                        List.class);
    }

}
