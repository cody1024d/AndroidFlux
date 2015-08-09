package cody1024.androidflux.action;

import java.util.Arrays;
import java.util.List;

import cody1024.androidflux.store.FluxDataStore;

public class FluxActionCreator {

    private final List<FluxDataStore> stores;

    public FluxActionCreator(FluxDataStore... stores) {
        this.stores = Arrays.asList(stores);
    }

    private void registerStores() {
        for(FluxDataStore store : stores) {
            store.register(this);
        }
    }
}
