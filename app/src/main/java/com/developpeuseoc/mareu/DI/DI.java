package com.developpeuseoc.mareu.DI;

import com.developpeuseoc.mareu.service.ApiService;
import com.developpeuseoc.mareu.service.FakeApiService;

/**
 * Dependency injector to get instance of services
 */
public class DI {

    private static ApiService service = new FakeApiService();

    /**
     * Get an instance on @{@link ApiService}
     * @return
     */
    public static ApiService getMeetingsApiService() {
        return service;
    }

    /**
     * Get always a new instance on @{@link ApiService}. Useful for tests, so we ensure the context is clean.
     * @return
     */
    public static ApiService getNewInstanceApiService() {
        if(service == null){
            return new FakeApiService();
        } else {
            return service;
        }
    }
}
