package com.api.book.bootrestbook.controllers;



@Controller
public class BookController {

    @RequestMapping(value="/books", method = RequestMethod.GET)
    @ResponseBody
    public String getBook() {
         
        return "this is testing book first...";
    }
}