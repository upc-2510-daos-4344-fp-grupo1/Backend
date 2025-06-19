package com.acme.trackzonebackend.Payments.interfaces;

import com.acme.trackzonebackend.Payments.domain.model.aggregates.Payment;
import com.acme.trackzonebackend.Payments.domain.model.queries.GetAllPaymentByPaymentsApiKeyQuery;
import com.acme.trackzonebackend.Payments.domain.model.queries.GetPaymentByIdQuery;
import com.acme.trackzonebackend.Payments.domain.model.queries.GetPaymentByPaymentsApiKeyAndSourceIdQuery;
import com.acme.trackzonebackend.Payments.domain.services.PaymentCommandService;
import com.acme.trackzonebackend.Payments.domain.services.PaymentQueryService;
import com.acme.trackzonebackend.Payments.interfaces.resources.CreatePaymentResource;
import com.acme.trackzonebackend.Payments.interfaces.resources.PaymentResource;
import com.acme.trackzonebackend.Payments.interfaces.transform.CreatePaymentCommandFromResourceAssembler;
import com.acme.trackzonebackend.Payments.interfaces.transform.PaymentResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(value = "/api/v1/Payment", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Favorite Sources", description = "Endpoints for favorite sources")
public class PaymentController {
    private final PaymentCommandService PaymentCommandService;
    private final PaymentQueryService PaymentQueryService;


    public PaymentController(PaymentCommandService PaymentCommandService, PaymentQueryService PaymenteQueryService) {
        this.PaymentCommandService = PaymentCommandService;
        this.PaymentQueryService = PaymentQueryService;
    }


    @Operation(
            summary = "Create a Payment",
            description = "Creates a Payment with the provided Payments API key and source ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Payment created"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping
    public ResponseEntity<PaymentResource> createFavoriteSource(@RequestBody CreatePaymentResource resource) {
        Optional<Payment> Payment = PaymentCommandService
                .handle(CreatePaymentCommandFromResourceAssembler.toCommandFromResource(resource));
        return Payment.map(source -> new ResponseEntity<>(PaymentResourceFromEntityAssembler.toResourceFromEntity(source), CREATED))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }


    @Operation(
            summary = "Get a Payment by ID",
            description = "Gets a Payment by the provided ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Payment found"),
            @ApiResponse(responseCode = "404", description = "Payment not found")
    })
    @GetMapping("{id}")
    public ResponseEntity<PaymentResource> getFavoriteSourceById(@PathVariable Long id) {
        Optional<Payment> Payment = PaymentQueryService.handle(new GetPaymentByIdQuery(id));
        return Payment.map(source -> ResponseEntity.ok(PaymentResourceFromEntityAssembler.toResourceFromEntity(source)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    private ResponseEntity<List<PaymentResource>> getAllPaymentByPaymentsApiKey(String PaymentsApiKey) {
        var getAllPaymentByPaymentsApiKeyQuery = new GetAllPaymentByPaymentsApiKeyQuery(PaymentsApiKey);
        var Payment = PaymentQueryService.handle(getAllPaymentByPaymentsApiKeyQuery);
        if (Payment.isEmpty()) return ResponseEntity.notFound().build();
        var PaymentResources = Payment.stream().map(PaymentResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(PaymentResources);
    }

    private ResponseEntity<PaymentResource> getFavoriteSourceByNewsApiKeyAndSourceId(String PaymentsApiKey, String sourceId) {
        var getPaymentByPaymentsApiKeyAndSourceIdQuery = new GetPaymentByPaymentsApiKeyAndSourceIdQuery(PaymentsApiKey, sourceId);
        var Payment = PaymentQueryService.handle(getPaymentByPaymentsApiKeyAndSourceIdQuery);
        if (Payment.isEmpty()) return ResponseEntity.notFound().build();
        return Payment.map(source -> ResponseEntity.ok(PaymentResourceFromEntityAssembler.toResourceFromEntity(source)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @Operation(
            summary = "Get Payments with parameters (Payments API key and optionally Source ID)",
            description = "Gets Payments based on the provided parameters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Payment(s) found"),
            @ApiResponse(responseCode = "404", description = "Payment(s) not found"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @Parameters({
            @Parameter(name = "PaymentsApiKey", description = "Payments API key", required = true),
            @Parameter(name = "sourceId", description = "Source ID")})
    @GetMapping
    public ResponseEntity<?> getPaymentWithParameters(
            @Parameter(name = "params", hidden = true)
            @RequestParam Map<String, String> params) {
        if (params.containsKey("PaymentsApiKey") && params.containsKey("sourceId")) {
            return getPaymentByPaymentsApiKeyAndSourceIdQuery(params.get("PaymentsApiKey"), params.get("sourceId"));
        } else if (params.containsKey("PaymentsApiKey")) {
            return getAllPaymentByPaymentsApiKey(params.get("newsApiKey"));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
