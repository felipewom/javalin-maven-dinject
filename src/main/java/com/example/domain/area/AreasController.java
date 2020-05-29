package com.example.domain.area;

import io.dinject.controller.Controller;
import io.dinject.controller.Get;
import io.dinject.controller.Path;
import io.javalin.http.Context;

@Controller
@Path("/areas")
public class AreasController {

    @Get("/:id")
    public AreaDTO getOne(Integer id, Context context) {
        return new AreaDTO(String.valueOf(id), context.path());
    }
}
