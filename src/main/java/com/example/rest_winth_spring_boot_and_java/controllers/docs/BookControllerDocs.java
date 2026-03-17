package com.example.rest_winth_spring_boot_and_java.controllers.docs;

import com.example.rest_winth_spring_boot_and_java.data.dto.BooksDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BookControllerDocs {
    @Operation(summary = "Find All Book",
            description = "Finds All Book",
            tags = {"Books"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            array = @ArraySchema(schema = @Schema(implementation = BooksDto.class))
                                    )
                            }),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    List<BooksDto> findAll();
    
    @Operation(summary = "Finds a Books",
            description = "Find a specific book by your ID",
            tags = {"Books"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(schema = @Schema(implementation = BooksDto.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    BooksDto findById(@PathVariable("id") Long id);
    
    @Operation(summary = "Adds a new Book",
            description = "Adds a new Book by passing in a JSON, XML or YML representation of the Book.",
            tags = {"Books"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(schema = @Schema(implementation = BooksDto.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    BooksDto create(@RequestBody BooksDto books);
    
    @Operation(summary = "Updates a Book's information",
            description = "Updates a Book's information by passing in a JSON, " +
                    "XML or YML representation of the updated books.",
            tags = {"Books"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(schema = @Schema(implementation = BooksDto.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    BooksDto update(@RequestBody BooksDto book);
    
    @Operation(summary = "Deletes a Books",
            description = "Deletes a specific Book by their ID",
            tags = {"Books"},
            responses = {
                    @ApiResponse(
                            description = "No Content",
                            responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            }
    )
    ResponseEntity<?> delete(@PathVariable("id") Long id);
}

