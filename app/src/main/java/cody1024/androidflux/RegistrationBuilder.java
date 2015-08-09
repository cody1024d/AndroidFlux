package cody1024.androidflux;

import java.lang.reflect.Method;

import cody1024.androidflux.store.FluxRegistrationException;

public class RegistrationBuilder {

    private Object actor;
    private Object reactor;

    public RegistrationBuilder actor(Object actor) {
        this.actor = actor;
        return this;
    }

    public RegistrationBuilder reactor(Object reactor) {
        this.reactor = reactor;
        return this;
    }

    public void execute() {
        if(actor == null || reactor == null) {
            throw new FluxRegistrationException();
        }

        try {
            Method registerMethod = getClass().getMethod("register", actor.getClass());
            if (registerMethod != null) {
                registerMethod.invoke(this, reactor);
            }
        } catch (Exception e) {
            //TODO--Change this error handling to be more robust
            throw new FluxRegistrationException();
        }
    }
}
