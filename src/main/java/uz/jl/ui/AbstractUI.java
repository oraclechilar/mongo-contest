package uz.jl.ui;

import jdk.jfr.consumer.RecordedStackTrace;
import uz.jl.response.Data;
import uz.jl.response.ResponseEntity;
import uz.jl.services.AbstractService;
import uz.jl.services.GenericBaseService;

/**
 * @author Bakhromjon Wed, 8:17 PM 1/26/2022
 */
public abstract class AbstractUI<S extends GenericBaseService> {
    protected final S service;

    public AbstractUI(S service) {
        this.service = service;
    }

    public <T> void showResponse(ResponseEntity<Data<T>> response) {
        System.out.println(response.toString());
    }
}
