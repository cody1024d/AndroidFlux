package cody1024.androidflux.store;

import cody1024.androidflux.RegistrationBuilder;
import cody1024.androidflux.action.FluxActionCreator;

/**
 * In order to register a data store to a particular action creator, you must create a register method,
 * passing in the action creator you want to register for
 */
public abstract class FluxDataStore {

    public void register(FluxActionCreator fluxActionCreator) throws FluxRegistrationException {
        new RegistrationBuilder()
                .actor(fluxActionCreator)
                .reactor(this)
                .execute();
    }
}
