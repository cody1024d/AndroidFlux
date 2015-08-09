package cody1024.androidflux.view;

import java.util.List;

import cody1024.androidflux.RegistrationBuilder;
import cody1024.androidflux.store.FluxDataStore;

public class FluxView {

    private List<FluxDataStore> dataStores;

    protected void registerStores() {
        for(FluxDataStore dataStore : dataStores) {
            register(dataStore);
        }
    }

    private void register(FluxDataStore dataStore) {
        new RegistrationBuilder()
                .reactor(this)
                .actor(dataStore)
                .execute();

    }
}
