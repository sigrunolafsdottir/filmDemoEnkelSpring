package com.example.filmdemoenkelspring.BookRESTAPI;



import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {

    protected int id;

    @NotEmpty(message = "Title Is Mandatory")
    @Size(min = 3, message = "At least 3 Letters for Title is Needed")

    protected String title;

    @NotEmpty(message = "Author Is Mandatory")
    @Size(min = 3, message = "At least 3 Letters for Author")
    @Pattern(regexp="^[A-Öa-ö]*$", message = "Only Letters for Author")
    protected String author;

}
