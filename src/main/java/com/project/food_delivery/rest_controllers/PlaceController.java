package com.project.food_delivery.rest_controllers;

import com.project.food_delivery.dtos.PlaceDataDto;
import com.project.food_delivery.dtos.PlaceDto;
import com.project.food_delivery.exceptions.ErrorResponse;
import com.project.food_delivery.services.PlaceService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/places")
@OpenAPIDefinition(
        info = @Info(
                title = "Place controller",
                version = "1.0",
                description = "Controller that processes place data"
        )
)
public class PlaceController {
    private final PlaceService placeService;
    @GetMapping("/category")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get places by place category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found places",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PlaceDto.class))}),
            @ApiResponse(responseCode = "404", description = "Places are not found", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse.class))})
    })
    public ResponseEntity<List<PlaceDto>> getPlacesByPlaceCategory(@Parameter(description = "Place category", example = "Supermarket") @RequestParam(name = "category") String category){
        return ResponseEntity.ok(placeService.getPlacesByPlaceCategory(category));
    }

    @GetMapping("/city")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get places by city")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found places",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PlaceDto.class))}),
            @ApiResponse(responseCode = "404", description = "Places are not found", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse.class))})
    })
    public ResponseEntity<List<PlaceDto>> getPlacesByCity(@Parameter(description = "City", example = "Ivano-Frankivsk") @RequestParam(name = "city") String city){
        return ResponseEntity.ok(placeService.getPlacesByCity(city));
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add place")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Place is added")
    })
    public void addPlace(@Parameter(required = true, content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = PlaceDataDto.class)
    )) @RequestBody PlaceDataDto placeData){
        placeService.addPlace(placeData);
    }
}
