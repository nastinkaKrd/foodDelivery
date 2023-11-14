package com.project.food_delivery.rest_controllers;

import com.project.food_delivery.dtos.PlaceCategoryDto;
import com.project.food_delivery.exceptions.ErrorResponse;
import com.project.food_delivery.services.PlaceCategoryService;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/place-categories")
@OpenAPIDefinition(
        info = @Info(
                title = "Place category controller",
                version = "1.0",
                description = "Controller that add and return place category data"
        )
)
public class PlaceCategoryController {
    private final PlaceCategoryService placeCategoryService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get place categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Place categories are found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PlaceCategoryDto.class))}),
            @ApiResponse(responseCode = "404", description = "Place categories are not found", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse.class))})
    })
    public ResponseEntity<List<PlaceCategoryDto>> getPlaceCategories(){
        return ResponseEntity.ok(placeCategoryService.getPlaceCategories());
    }

    @PostMapping("/{place-category}")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add new place category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Place category is added"),
    })
    public void addNewPlaceCategory(@Parameter(description = "Place category", example = "Supermarket") @PathVariable(name = "place-category") String placeCategory){
        placeCategoryService.addPlaceCategoryAndReturn(placeCategory);
    }
}
